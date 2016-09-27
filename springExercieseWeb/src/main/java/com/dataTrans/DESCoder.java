//package com.dataTrans;
//
//
//import org.apache.commons.codec.Charsets;
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.SecretKeySpec;
//
//
///**
// * DES
// * @author zhanghao
// * @date 2015/12/22.
// */
//public class DESCoder extends Coder{
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(DESCoder.class);
//
//	private final static String desKey = "jeiantdixadekg32";
//	/**
//	 * 加密方法
//	 *
//	 * @param text 明文
//	 * @return 密文
//	 * @throws Exception
//	 */
//	public static String encrypt(String text, String key){
//		if (StringUtils.isBlank(key)){
//			key = desKey;
//		}
//		try {
//			byte[] keyBase64DecodeBytes = decryptBASE64(key);
//
//			SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
//			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//
//			cipher.init(Cipher.ENCRYPT_MODE, skey);
//			byte[] textBytes = text.getBytes(Charsets.UTF_8);
//			byte[] bytes = cipher.doFinal(textBytes);
//			return encryptBASE64(bytes);
//		}catch (Exception e){
//			LOGGER.error("DES加密失败：",e);
//			return "";
//		}
//	}
//
//	/**
//	 * 解密方法
//	 *
//	 * @param text 密文
//	 * @return 明文
//	 * @throws Exception
//	 */
//	public static String decrypt(String text,String key) {
//
//		if (StringUtils.isBlank(key)){
//			key = desKey;
//		}
//		try{
//			byte[] keyBase64DecodeBytes = decryptBASE64(key);
//
//			SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
//			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//			cipher.init(Cipher.DECRYPT_MODE, skey);
//			byte[] textBytes = decryptBASE64(text);
//			byte[] bytes = cipher.doFinal(textBytes);
//
//			return new String(bytes, Charsets.UTF_8);
//		}catch (Exception e){
//            LOGGER.error("DES解密失败：",e);
//            return "";
//        }
//	}
//
//}