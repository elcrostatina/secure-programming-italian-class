package com.example.vuln;

import org.owasp.encoder.Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class XssController {
    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public XssController(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // reflected XSS
    @GetMapping("/xss")
    public String xss(@RequestParam(name = "name", required = false) String name) {
        return "<h1>Hello, " + name + "!</h1>";
    }

    /**
     * @link https://owasp.org/www-project-java-encoder/
     * @link https://github.com/OWASP/owasp-java-encoder/
     */
    @GetMapping("/secure-xss")
    public String secureXss(@RequestParam(name = "name", required = false) String name) {
        if (name == null || name.isEmpty()) {
            return "<h1>Name is required.</h1>";
        }

        String escapedName = Encode.forHtml(name);

        return "<h1>Hello, " + escapedName + "!</h1>";
    }

    // stored XSS
    @PostMapping("/stored-xss")
    public String stored(@RequestBody StoredXssPayload payload) {
        redisTemplate.opsForList().leftPush("names", Encode.forHtml(payload.getName()));

        return "<h1>Added!</h1>";
    }

    @GetMapping("/stored-xss")
    public String stored() {
        List<String> names = redisTemplate.opsForList().range("names", 0, -1);

        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Names</h1>");
        for (String name : names) {
            sb.append("<p>" + name + "</p>");
        }
        return sb.toString();
    }
}