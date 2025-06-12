package com.stars.springbootsecurityjwt.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2025/6/10 15:00
 */
public class KeyLoader {
    /**
     * 从文件中加载 PKCS#8 格式的 RSA 私钥
     * @param filePath 私钥文件路径 (e.g., "path/to/private_key.pem")
     * @return PrivateKey 对象
     */
    public static PrivateKey loadRsaPrivateKey(String filePath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        // 1. 读取文件内容
        byte[] keyBytes = Files.readAllBytes(Paths.get(filePath));
        String privateKeyPem = new String(keyBytes);

        // 2. 移除 PEM 文件头尾和换行符
        privateKeyPem = privateKeyPem
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", ""); // 移除所有空白字符

        // 3. Base64 解码
        byte[] decodedKey = Base64.getDecoder().decode(privateKeyPem);

        // 4. 使用 KeyFactory 生成 PrivateKey 对象
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 从文件中加载 X.509 格式的 RSA 公钥
     * @param filePath 公钥文件路径 (e.g., "path/to/public_key.pem")
     * @return PublicKey 对象
     */
    public static PublicKey loadRsaPublicKey(String filePath) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        // 1. 读取文件内容
        byte[] keyBytes = Files.readAllBytes(Paths.get(filePath));
        String publicKeyPem = new String(keyBytes);

        // 2. 移除 PEM 文件头尾和换行符
        publicKeyPem = publicKeyPem
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");

        // 3. Base64 解码
        byte[] decodedKey = Base64.getDecoder().decode(publicKeyPem);
        // 4. 使用 KeyFactory 生成 PublicKey 对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }
}
