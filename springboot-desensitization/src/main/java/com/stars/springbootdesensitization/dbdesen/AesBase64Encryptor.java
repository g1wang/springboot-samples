package com.stars.springbootdesensitization.dbdesen;

import org.apache.shardingsphere.encrypt.spi.EncryptAlgorithm;
import org.apache.shardingsphere.encrypt.spi.context.EncryptContext;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Properties;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2025/5/22 10:59
 */
public final class AesBase64Encryptor implements EncryptAlgorithm<String, String> {
    private String key;

    @Override
    public void init(Properties props) {
        key = props.getProperty("aes-key-value");
    }

    @Override
    public String encrypt(String plainValue, EncryptContext encryptContext) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(plainValue.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("AES encryption failed", e);
        }
    }

    @Override
    public String decrypt(String cipherValue, EncryptContext encryptContext) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(cipherValue));
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("AES decryption failed", e);
        }
    }

    @Override
    public String getType() {
        return "AES_BASE64";
    }

    @Override
    public Properties getProps() {
        Properties result = new Properties();
        result.setProperty("aes-key-value", key);
        return result;
    }
}
