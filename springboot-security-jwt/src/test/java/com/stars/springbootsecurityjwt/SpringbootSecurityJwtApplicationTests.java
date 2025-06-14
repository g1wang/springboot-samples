package com.stars.springbootsecurityjwt;

import com.stars.springbootsecurityjwt.config.KeyManager;
import com.stars.springbootsecurityjwt.util.JwtUtils;
import com.stars.springbootsecurityjwt.util.KeyLoader;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;

@SpringBootTest
class SpringbootSecurityJwtApplicationTests {

    @Resource
    JwtUtils jwtUtils;

    @Test
    void rsaTest() {

        // 你可以把这个生成的 token 字符串复制到 https://jwt.io/ 去解码和验证
        // 注意：因为它们没有你的 secretKey，所以签名验证会失败，但 Header 和 Payload 可以正常查看。

        try {
            // =================================================================
            // === 1. 从文件中加载密钥对 ===
            // =================================================================
            // 请将 "path/to/your/private_key.pem" 和 "path/to/your/public_key.pem" 替换为你的实际文件路径
            /*String privateKeyPath = "D:\\IdeaProjects\\springboot-samples\\springboot-security-jwt\\src\\main\\resources\\private_key.pem";
            String publicKeyPath = "D:\\IdeaProjects\\springboot-samples\\springboot-security-jwt\\src\\main\\resources\\public_key.pem";

            PrivateKey privateKey = KeyLoader.loadRsaPrivateKey(privateKeyPath);
            PublicKey publicKey = KeyLoader.loadRsaPublicKey(publicKeyPath);*/

            // =================================================================
            // === 2. 使用加载的私钥生成 JWT ===
            // =================================================================
            String jwtToken = jwtUtils.generateToken("qwer", "123", KeyManager.getPrivateKey());
            System.out.println("\n--- Generating Token with Private Key from file ---" + jwtToken);
            jwtUtils.validateToken(jwtToken, KeyManager.getPublicKey());
        } catch (Exception e) {
            // 捕获所有可能的异常：文件未找到、密钥格式错误、JWT校验失败等
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    void hsTest() {
        //Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        // 1. 生成一个安全的密钥 (在实际应用中，这个密钥应该来自配置文件或密钥库，且不能硬编码)
        // Keys.secretKeyFor() 会为指定的算法生成一个足够强度的安全密钥。
        SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String token = jwtUtils.generateToken("alice", "ROLE_USER,ROLE_VIEWER", secretKey);
        System.out.println("Generated JWT: " + token);
        jwtUtils.validateToken(token, secretKey);
    }

}
