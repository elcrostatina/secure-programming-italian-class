package com.example.vuln;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SecretInfoRepository extends JpaRepository<SecretInfoEntity, Long> {
    SecretInfoEntity findByNameAndSecretKey(String name, String secretKey);
}
