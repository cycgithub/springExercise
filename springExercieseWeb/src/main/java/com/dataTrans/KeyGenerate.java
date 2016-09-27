//package com.dataTrans;
//
////import org.apache.commons.lang3.StringUtils;
////import org.slf4j.Logger;
////import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.ClassRelativeResourceLoader;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.ResourceLoader;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 秘钥生成器
// * @author zhanghao
// * @date 2016/7/19.
// */
//@SuppressWarnings("Duplicates")
//@Component
//public class KeyGenerate implements InitializingBean {
//
////    private static final Logger LOGGER = LoggerFactory.getLogger(KeyGenerate.class);
//
//    private String privateKey = "";
//    private Map<String,String> publicKeys = new HashMap<String, String>();
//
//    private ResourceLoader resourceLoader;
//
//    /**
//     * 获取私钥
//     * @return
//     */
//    public String getPrivateKey(){
//        if (StringUtils.isBlank(privateKey)){
//            Resource resource = resourceLoader.getResource("classpath:keys/private.key");
//            BufferedReader reader = null;
//            try {
//                reader = new BufferedReader(new FileReader(resource.getFile()));
//                String line;
//                while ((line = reader.readLine()) != null){
//                    privateKey += line;
//                    privateKey += "\n";
//                }
//                privateKey = StringUtils.removeEnd(privateKey,"\n");
//            } catch (IOException e) {
////                LOGGER.error("error:",e);
//            }finally {
//                try {
//                    if (reader != null) {
//                        reader.close();
//                    }
//                } catch (IOException ignored) {
////                    LOGGER.error("error:",ignored);
//                }
//            }
//        }
//        return privateKey;
//    }
//    /**
//     * 获取公钥
//     * @return
//     */
//    public String getPublicKey(String keyName) {
//        if (StringUtils.isBlank(keyName)){
//            keyName = "public";
//        }
//        String publicKey = publicKeys.get(keyName);
//        if (StringUtils.isBlank(publicKey)){
//            publicKey = "";
//            Resource resource = resourceLoader.getResource("classpath:keys/"+keyName+".key");
//            BufferedReader reader = null;
//            try {
//                reader = new BufferedReader(new FileReader(resource.getFile()));
//                String line;
//                while ((line = reader.readLine()) != null){
//                    publicKey += line;
//                    publicKey += "\n";
//                }
//                publicKey = StringUtils.removeEnd(publicKey,"\n");
//            } catch (IOException e) {
////                LOGGER.error("error:",e);
//            }finally {
//                try {
//                    if (reader != null) {
//                        reader.close();
//                    }
//                } catch (IOException ignored) {
////                    LOGGER.error("error:",ignored);
//                }
//            }
//        }
//        return publicKey;
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        resourceLoader = new ClassRelativeResourceLoader(ClassPathResource.class);
//    }
//}
