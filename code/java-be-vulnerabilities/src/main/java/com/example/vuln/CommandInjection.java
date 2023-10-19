package com.example.vuln;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
public class CommandInjection {

    @GetMapping("/command-injection")
    public String command(@RequestParam String command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = "";
        while (reader.readLine() != null) {
            line += "  " + reader.readLine();

        }

        return line;
    }
}