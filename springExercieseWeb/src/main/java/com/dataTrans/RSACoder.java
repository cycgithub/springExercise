package com.dataTrans;

//import org.apache.commons.codec.Charsets;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import java.nio.charset.StandardCharsets;
import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA
 * @author zhanghao
 * @date 2015/12/22.
 */
public class RSACoder extends Coder{
//    private static final Logger LOGGER = LoggerFactory.getLogger(RSACoder.class);

    public static final String KEY_ALGORITHM = "RSA";
    public static final String KEY_ALGORITHM_1 = "RSA/ECB/PKCS1Padding";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * 用私钥对信息生成数字签名
     *
     * @param data
     *            加密数据
     * @param privateKey
     *            私钥
     *
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        // 解密由base64编码的私钥
        byte[] keyBytes = decryptBASE64(privateKey);

        // 构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        // 取私钥匙对象
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

        // 用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(priKey);
        signature.update(data);

        return encryptBASE64(signature.sign());
    }

    /**
     * 校验数字签名
     *
     * @param data
     *            加密数据
     * @param publicKey
     *            公钥
     * @param sign
     *            数字签名
     *
     * @return 校验成功返回true 失败返回false
     * @throws Exception
     *
     */
    public static boolean verify(byte[] data, String publicKey, String sign)
            throws Exception {

        // 解密由base64编码的公钥
        byte[] keyBytes = decryptBASE64(publicKey);

        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        // 取公钥匙对象
        PublicKey pubKey = keyFactory.generatePublic(keySpec);

        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(data);

        // 验证签名是否正常
        return signature.verify(decryptBASE64(sign));
    }

    /**
     * 解密<br>
     * 用私钥解密
     *
     * @param sourceDate
     * @param key
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String sourceDate, String key) {
        try {
            // 对密钥解密
            byte[] keyBytes = decryptBASE64(key);
            // 取得私钥
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

            // 对数据解密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte[] bytes = cipher.doFinal(decryptBASE64(sourceDate));
            return new String(bytes,StandardCharsets.UTF_8);
//            return new String(bytes, Charsets.UTF_8);
        } catch (Exception e) {
//            LOGGER.error("RSA私钥解密失败：",e);
            return "";
        }

    }

    /**
     * 解密<br>
     * 用公钥解密
     *
     * @param sourceData
     * @param key
     * @return
     * @throws Exception
     */
    public static String decryptByPublicKey(String sourceData, String key) {
        try {
            // 对密钥解密
            byte[] keyBytes = decryptBASE64(key);
            // 取得公钥
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            Key publicKey = keyFactory.generatePublic(x509KeySpec);

            // 对数据解密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.DECRYPT_MODE, publicKey);

            byte[] bytes = cipher.doFinal(decryptBASE64(sourceData));
            return new String(bytes,StandardCharsets.UTF_8);
//            return new String(bytes, Charsets.UTF_8);
        } catch (Exception e) {
//            LOGGER.error("RSA公钥解密失败：",e);
            return "";
        }

    }

    /**
     * 加密<br>
     * 用公钥加密
     *
     * @param sourceData
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String sourceData, String key) {
        try {
            // 对公钥解密
            byte[] keyBytes = decryptBASE64(key);

            // 取得公钥
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            Key publicKey = keyFactory.generatePublic(x509KeySpec);

            // 对数据加密
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM_1);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

//            byte[] sourceDataBytes = sourceData.getBytes(Charsets.UTF_8);
            byte[] sourceDataBytes = sourceData.getBytes(StandardCharsets.UTF_8);
            byte[] bytes = cipher.doFinal(sourceDataBytes);
            return encryptBASE64(bytes);
        } catch (Exception e) {
//            LOGGER.error("RSA公钥加密失败：",e);
            return "";
        }

    }
    /**
     * 加密<br>
     * 用私钥加密
     *
     * @param sourceData
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptByPrivateKey(String sourceData, String key) {
        try {
            // 对密钥解密
            byte[] keyBytes = decryptBASE64(key);

            // 取得私钥
            PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);

            // 对数据加密
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, privateKey);

//            byte[] sourceDataBytes = sourceData.getBytes(Charsets.UTF_8);
            byte[] sourceDataBytes = sourceData.getBytes(StandardCharsets.UTF_8);
            byte[] bytes = cipher.doFinal(sourceDataBytes);
            return encryptBASE64(bytes);
        } catch (Exception e) {
//            LOGGER.error("RSA私钥加密失败：", e);
            return "";
        }
    }

    /**
     * 取得私钥
     *
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPrivateKey(Map<String, Object> keyMap)
            throws Exception {
        Key key = (Key) keyMap.get(PRIVATE_KEY);

        return encryptBASE64(key.getEncoded());
    }

    /**
     * 取得公钥
     *
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPublicKey(Map<String, Object> keyMap)
            throws Exception {
        Key key = (Key) keyMap.get(PUBLIC_KEY);

        return encryptBASE64(key.getEncoded());
    }

    /**
     * 初始化密钥
     *
     * @return
     * @throws Exception
     */
    public static Map<String, Object> initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator
                .getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);

        KeyPair keyPair = keyPairGen.generateKeyPair();

        // 公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

        // 私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        Map<String, Object> keyMap = new HashMap<String, Object>(2);

        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    public static void main(String[] args) throws Exception {
        //Map<String, Object> keyMap = RSACoder.initKey();
        //String publicKey = RSACoder.getPublicKey(keyMap);
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC4LjV5OZtFE6OIz1gpIzDnIdBjCB+pFDJXRK4g\n" +
                "Yi+lxeXT8krKDWkT3qtZvwmEc5RI4MVn9djuudc62ToyOnPrT4XakLdLqX4XCT5m/DsFrv+2qE8f\n" +
                "aIpp6c+z2hAuf1ExRMwUjkYHwVkHB4KqBayAv0xiCShTlBZ3zx0/lrMy2wIDAQAB";
        //System.err.println(publicKey);
        //String privateKey = RSACoder.getPrivateKey(keyMap);
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALguNXk5m0UTo4jPWCkjMOch0GMI\n" +
                "H6kUMldEriBiL6XF5dPySsoNaRPeq1m/CYRzlEjgxWf12O651zrZOjI6c+tPhdqQt0upfhcJPmb8\n" +
                "OwWu/7aoTx9oimnpz7PaEC5/UTFEzBSORgfBWQcHgqoFrIC/TGIJKFOUFnfPHT+WszLbAgMBAAEC\n" +
                "gYBcflg8WMGxHvuxaO9NOW8Fo+WS1jGQJ6RgTw1jFev3xDp3BeapMbLjV5+VomqVKbX+I2L/omce\n" +
                "/BUqaIzhTJmJZmVIy2+SA21P9D36uB9uiWrCvkF6GgCuG5gmmzuWgkzoFarFZ6XSpKon4EFCQ1c1\n" +
                "lHp88swNZUbO9LavIrFaAQJBAPlntUO90LA8MGI6Zsy8qbNlGTJnci8LeB9OY5I5ZzEZ2qjBi23P\n" +
                "U0WZ8A6BQ3FNCFEkXixLPVBzXr4C2DgmuxECQQC9DPo7+91kio4nd6AvSkk+/DdWwkaWAU7pMkTN\n" +
                "+3qIzpetsPe/LbIJhf4gIxufgAH8CES5UxEmuzV6GQE+r1crAkAHKX1BFsBZb0EMcRTmqDxPVIXm\n" +
                "tqXGyBOJAp1FY7Sc6lsnIXe5jYycoRENuZSQOmAUxHCX4Qk/uDBuUHKZGjOhAkB6TNPxTC3cZhoy\n" +
                "hBwXm8oougee083QKwZ+q+uBCegqauQLFIohnpEnwgw1hCDRnYErJ7o13fwhf0jINTbt84bDAkEA\n" +
                "mp3Zuj3/UKfqnb/YU3S3rRy1SnHXCw+kTlWMGoSerqilZ5qjbiYyBak3LVsQMFmm1BXzNt3UHJTM\n" +
                "Z57RrI5QeA==";
        String token = RSACoder.encryptByPublicKey("feigaigeeeelfeicda",publicKey);
        System.err.println(privateKey);
        System.err.println("公钥加密——私钥解密");
        String inputStr="{\"userId\": \"10\",\"result\": \"success\",\"bankName\": \"工商银行\"," +
                        "\"bankBranch\": \"工商银行广州分行\",\"accountName\": \"路人甲\",\"accountNo\": \"123456789\"}";
       // String inputStr = "[{\"settleId\":\"DH150703100121852\",\"userId\":\"05002\"},{\"settleId\":\"DH150703100121851\",\"userId\":\"05001\"}]";
        byte[] data = inputStr.getBytes("UTF-8");

        String encodedData = RSACoder.encryptByPublicKey(inputStr, publicKey);
       // String encryptBASE64 = RSACoder.encryptBASE64(encodedData);
        //String encryptBASE64 = "tJZM8g7cTf6P2YSxlennjgZe79SpZU0OVWAzwiFLheyhlmCASscl/sWX6MWzZN1ofBlR2Ze1F+JTpNGZ/XIln88w09xLgcA1Q/55Twn0YlbsxXNmVf5t8d5yKDAicA1qKhi3xIo9OPGMhuKa55eXX7PcRi8S/JjQJTjsV8l90cI=";
        System.err.println("加密数据：" + encodedData);

        String decodedData = RSACoder.decryptByPrivateKey(encodedData, privateKey);

        String outputStr = new String(decodedData);
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
        //System.err.println("私钥加密——公钥解密");
        //String inputStrSign = "sign";
        //byte[] dataSign = inputStrSign.getBytes();
        //
        //byte[] encodedDataSign = RSACoder.encryptByPrivateKey(dataSign, privateKey);

        //String key = "IfvNe9lcBP4u6Sz1QJtdWntVN5O5/lFCLHkbEb7RUusJ3QaUMcUJ2Mo6SDksI+FH" +
        //        "+tk3nf7aMVeyfhgxHEtxD2s5zBBT9TT0MHvpUhkw7NZbzURFZCo5Q3xp/uqsmGN0THSiMRlM/pjEvOwwdHoNZo1670QiLf0" +
        //        "/x3QF2AIHLE4=";
        //
        //String outputStrSign =  RSACoder
        //        .decryptByPublicKey(key, publicKey);
        //
        //System.err.println("解密后: " + outputStrSign);
        //System.err.println("加密前: " + inputStrSign + "\n\r" + "解密后: " + outputStrSign);
        //
        //System.err.println("私钥签名——公钥验证签名");
        //// 产生签名
        //String sign = RSACoder.sign(encodedDataSign, privateKey);
        //System.err.println("签名:\r" + sign);
        //
        //// 验证签名
        //boolean status = RSACoder.verify(encodedDataSign, publicKey, sign);
        //System.err.println("状态:\r" + status);
    }
}
