package com.dataTrans;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.domain.Utils.BusinessTypeEnum;
import com.server.http.HttpBase;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by chenyuchao on 2016/7/19.
 */
@Controller
@RequestMapping("/dataTrans")
public class dataTransController {

    @Autowired
    private ApplicationContext applicationContext;

//    @Autowired
//    private ServiceTest versionService;
//    @Autowired
//    private BasicInterface httpClient;
    @RequestMapping(value = "transDirect.htm")
    public ModelAndView dataTransDirect(Model mode, String data,String userId,HttpServletRequest request) {
        Initial init = new Initial();
        JSONObject jsonObject=(JSONObject) JSON.toJSON(init);
       //init.setAmount(new BigDecimal(1.234));
//        return "index";
        BusinessTypeEnum [] tt=BusinessTypeEnum.values();
        System.out.println(tt[1].getDescription());
        System.out.println(tt[1].getCode());
        String path=applicationContext.getClassLoader().getResource("/").toString();
        ModelAndView mav=new ModelAndView("/index");
        return mav;
    }

    @RequestMapping(value = "testLoad")
    public String testLoad(Model mode) {
        return "test";
    }

    @RequestMapping(value="testPost")
    public Initial testPost(Model model,String req){
        return new Initial();
    }

    @RequestMapping(value="test.htm", method=RequestMethod.POST)
    @ResponseBody
    public Object testAjax(Model mode, HttpServletRequest request){
        AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("spring/spring-config.xml");
        String []nameskk=ctx.getBeanDefinitionNames();
        String []names=applicationContext.getBeanDefinitionNames();
        HttpBase httpClient=(HttpBase) applicationContext.getBean("httpServer");

//        httpClient.doBusiness("sdfasd");
        Initial init = new Initial();
        InputStream is=null;
        String contentStr="";
        try {
            is=request.getInputStream();
            contentStr= IOUtils.toString(is,"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject=(JSONObject) JSON.toJSON(init);
//        String id=request.getParameter("jj");
        mode.addAttribute("data",jsonObject);
        return contentStr;
    }
}
