package com.day_record.server.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author JereChen
 */
public class TokenTool {

    public static String getNewToken(String timeStr, Long userId) {
        //currentNow + userId + random(4)
        String src = timeStr + userId + genRandomNum(4);
        return generateToken(src);
    }

    public static int genRandomNum(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }

    public static String generateToken(String src) {
        if (null == src || "".equals(src)) {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(src.getBytes());
            String result = new BigInteger(1, md.digest()).toString(16);
            if (result.length() == 31) {
                result = result + "-";
            }
            System.out.println(result);
            return result;
        } catch (Exception e) {
            return null;
        }
    }
}
