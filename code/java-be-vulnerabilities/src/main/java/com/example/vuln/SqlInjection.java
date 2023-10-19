package com.example.vuln;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SqlInjection {
    private final SecretInfoRepository secretInfoRepository;
    private final EntityManager entityManager;

    @Autowired
    public SqlInjection(SecretInfoRepository secretInfoRepository, EntityManager entityManager) {
        this.secretInfoRepository = secretInfoRepository;
        this.entityManager = entityManager;
    }

    @GetMapping("/sql-injection")
    public SecretInfoEntity getSecretInfoSqli(@RequestParam(name = "name") String name, @RequestParam(name = "secretKey") String secretKey) {
        return (SecretInfoEntity) entityManager
                .createNativeQuery("SELECT * FROM secret_info where name = '" + name + "' and secret_key = '" + secretKey + "'", SecretInfoEntity.class)
                .getSingleResult();
    }

    @GetMapping("/sql-parametrization")
    public SecretInfoEntity getSecretInfoParametrization(@RequestParam(name = "name") String name, @RequestParam(name = "secretKey") String secretKey) {
        return (SecretInfoEntity) entityManager
                .createNativeQuery("SELECT * FROM secret_info where name = :name and secret_key = :secretKey", SecretInfoEntity.class)
                .setParameter("name", name)
                .setParameter("secretKey", secretKey)
                .getSingleResult();
    }

    @GetMapping("/sql-repository")
    public SecretInfoEntity getSecretInfoRepository(@RequestParam(name = "name") String name, @RequestParam(name = "secretKey") String secretKey) {
        return secretInfoRepository.findByNameAndSecretKey(name, secretKey);
    }
}
