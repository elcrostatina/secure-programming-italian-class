package com.example.vuln;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "nosql")
public class NoSqlSecretInfoDocument {
    String value;
    String secretKey;
}
