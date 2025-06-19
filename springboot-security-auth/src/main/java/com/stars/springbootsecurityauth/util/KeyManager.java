package com.stars.springbootsecurityauth.util;

import com.stars.springbootsecurityjwt.config.JwtProperties;
import com.stars.springbootsecurityjwt.util.KeyLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;

/**
 * @Description:
 * @Author wanggl
 * @Date 2025/6/13 11:42
 */
@Component
public class KeyManager implements CommandLineRunner {

    @Autowired
    JwtProperties jwtProperties;

    public static PublicKey getPublicKey() {
        return PUBLIC_KEY;
    }

    public static void setPublicKey(PublicKey publicKey) {
        PUBLIC_KEY = publicKey;
    }

    public static PrivateKey getPrivateKey() {
        return PRIVATE_KEY;
    }

    public static void setPrivateKey(PrivateKey privateKey) {
        PRIVATE_KEY = privateKey;
    }

    private static PublicKey PUBLIC_KEY;
    private static PrivateKey PRIVATE_KEY;


    public void keyManagerInit() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        try {
            PUBLIC_KEY = KeyLoader.loadRsaPublicKey(jwtProperties.getPublicKeyPath());
            PRIVATE_KEY = KeyLoader.loadRsaPrivateKey(jwtProperties.getPrivateKeyPath());
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw e;
        }

    }


    /**
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        keyManagerInit();
    }


}
