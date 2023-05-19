package com.ssafy.enjoytrip.util.encrypt;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class AES implements Encrypt{
    private static final String AES_ALGORITHM="AES";
    private static final String AES_TRANSFORMATION="AES/ECB/PKCS5Padding";
    private static final String KEY="0123456789abcdef";//수정 필요


    @Override
    public String encrypt(String data) throws Exception {
        byte[] encryptedBytes;

        SecretKeySpec secretKeySpec=new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8),AES_ALGORITHM);
        Cipher cipher=Cipher.getInstance(AES_TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE,secretKeySpec);

        encryptedBytes=cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    @Override
    public String decrypt(String encryted) throws Exception {
        byte[] decryptedBytes;

        SecretKeySpec secretKeySpec=new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8),AES_ALGORITHM);
        Cipher cipher=Cipher.getInstance(AES_TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE,secretKeySpec);

        byte[] encryptedBytes=Base64.getDecoder().decode(encryted);
        decryptedBytes=cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes,StandardCharsets.UTF_8);
    }
}
