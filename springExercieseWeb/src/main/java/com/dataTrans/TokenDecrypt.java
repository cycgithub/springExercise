//package com.dataTrans;
//
//import com.jd.athena.gateway.common.utils.ValidateUtils;
//import com.jd.athena.gateway.domain.http.HttpRequest;
//import com.jd.athena.gateway.service.crypto.DESCoder;
//import com.jd.athena.gateway.service.crypto.KeyGenerate;
////import org.slf4j.Logger;
////import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.Header;
//import org.springframework.messaging.handler.annotation.Payload;
//
///**
// * 解密
// * @author zhanghao
// * @date 2016/7/20.
// */
//public class TokenDecrypt {
//
////    private static final Logger LOGGER = LoggerFactory.getLogger(TokenDecrypt.class);
//    @Autowired
//    private KeyGenerate keyGenerate;
//
//    public HttpRequest decryptByPri(HttpRequest request){
//        String privateKey = keyGenerate.getPrivateKey();
//        ValidateUtils.notBlack(privateKey,"获取签名秘钥失败");
//        String token = RSACoder.decryptByPrivateKey(request.getToken(), privateKey);
//        token = token.replace("\"","");
////        LOGGER.info("解密token：{}",token);
////        ValidateUtils.notBlack(token,"解密信息失败");
//        token = token.replace("\r","").replace("\n","");
//        String data = DESCoder.decrypt(request.getData(),token);
//        LOGGER.info("解密data：{}",data);
//        ValidateUtils.notBlack(data,"解密信息失败");
//        data = data.replace("\r","").replace("\n","");
//        request.setDataJson(data);
//        return request;
//    }
//    public String decryptByPub(@Payload HttpRequest request, @Header(value = "productCode") String productCode){
//        String publicKey = keyGenerate.getPublicKey(productCode);
//        ValidateUtils.notBlack(publicKey,"获取签名秘钥失败");
//        String token = RSACoder.decryptByPublicKey(request.getToken(), publicKey);
//        LOGGER.info("解密token：{}",token);
//        ValidateUtils.notBlack(token,"解密信息失败");
//        token = token.replace("\r","").replace("\n","");
//        String data = DESCoder.decrypt(request.getData(),token);
//        LOGGER.info("解密data：{}",data);
//        ValidateUtils.notBlack(data,"解密信息失败");
//        data = data.replace("\r","").replace("\n","");
//        return data;
//    }
//
//}
