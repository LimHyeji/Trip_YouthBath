package com.ssafy.enjoytrip.util;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//교수님 코드 그대로
public class OpenCrypt {
    public static byte[] generateKey(String algorithm, int keySize) throws NoSuchAlgorithmException {		// keySize에 따라 보안 강도가 달라짐

        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm); // algorithm을 외부에서 만들어서 넣으면 거기에 맞는 key를 생성함
        keyGenerator.init(keySize);
        SecretKey key = keyGenerator.generateKey();
        return key.getEncoded();		//byte배열 형태
    }

    public static byte[] hexToByteArray(String hex) { // 16진수 -> byteArray로 바꾸기
        if (hex == null || hex.length() == 0) {
            return null;
        }

        byte[] ba = new byte[hex.length() / 2];
        for (int i = 0; i < ba.length; i++) {
            ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return ba;
    }

    public static String getSHA256(String source, String salt) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(source.getBytes());
        md.update(salt.getBytes());
        byte[] byteData = md.digest();
        String hashMsg = byteArrayToHex(byteData);
//		System.out.println(hashMsg);
        return hashMsg;
    }

    // byte[] to hex
    public static String byteArrayToHex(byte[] ba) {
        if (ba == null || ba.length == 0) {
            return null;
        }

        StringBuffer sb = new StringBuffer(ba.length * 2);
        String hexNumber;
        for (int x = 0; x < ba.length; x++) {
            hexNumber = "0" + Integer.toHexString(0xff & ba[x]);

            sb.append(hexNumber.substring(hexNumber.length() - 2));
        }
        return sb.toString();
    }
}
