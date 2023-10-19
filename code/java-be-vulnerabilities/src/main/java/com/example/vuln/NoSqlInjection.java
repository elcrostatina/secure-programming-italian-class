package com.example.vuln;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoSqlInjection {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public NoSqlInjection(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping("/nosql-injection")
    public NoSqlSecretInfoDocument stored(@RequestParam String secretKey) {
        Query query = new Query(Criteria.where("secretKey").is(secretKey));
        return mongoTemplate.findOne(query, NoSqlSecretInfoDocument.class);
    }
}
