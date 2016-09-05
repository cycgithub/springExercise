package com.dataTrans;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by chenyuchao on 2016/7/19.
 */
@Controller
@RequestMapping("dataTrans")
public class dataTransController {

    @RequestMapping(value = "transDirect.htm")
    public String dataTransDirect(Model mode, String data) {
        return "/index";
    }

    @RequestMapping(value = "testLoad")
    public String testLoad(Model mode) {
        return "/test";
    }

}
