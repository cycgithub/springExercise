package com.dataTrans;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.client.BasicInterface;
import com.server.http.HttpBase;
import com.test.ServiceTest;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chenyuchao on 2016/7/19.
 */
@Controller
@RequestMapping("/dataTrans")
public class dataTransController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ServiceTest impleService;
//    @Autowired
//    private BasicInterface httpClient;
    @RequestMapping(value = "transDirect.htm")
    public ModelAndView dataTransDirect(Model mode, String data,String userId,HttpServletRequest request) {
        Initial init = new Initial();
        JSONObject jsonObject=(JSONObject) JSON.toJSON(init);
       //init.setAmount(new BigDecimal(1.234));
//        return "index";
        ModelAndView mav=new ModelAndView("/index.html");
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
        String kk=impleService.play("cyc");
        HttpBase httpClient=(HttpBase) applicationContext.getBean("httpServer");
       // httpClient.doBusiness("sdfasd");
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
