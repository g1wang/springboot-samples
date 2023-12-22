package com.stars.sb231204jwt;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2023/9/6 16:50
 */
public class KeyReader {
    private static final String KEY_ALGORITHM_RSA = "RSA";
    public static PublicKey getPublicKey(String filename) throws Exception {
        byte[] keyBytes = Files.readAllBytes(Paths.get(filename));
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance(KEY_ALGORITHM_RSA);
        return kf.generatePublic(spec);
    }
}
