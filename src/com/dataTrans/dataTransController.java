package com.dataTrans;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println(data);
        Calendar ca = Calendar.getInstance();
        String endDate = "2016-06-31";
        GregorianCalendar gc = new GregorianCalendar();
        String startDated = "2016-06-01";
        String endDated = "2016-09-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date da = sdf.parse(endDate);
            gc.setTime(da);
        } catch (Exception e) {
        }
       /* *gc.add(1,-1)表示年份减一.
                *gc.add(2,-1)表示月份减一.
                *gc.add(3.-1)表示周减一.
                *gc.add(5,-1)表示天减一.*/
        //gc.setTime(da);
        String str = endDate.substring(8);
        String strPre = endDate.substring(0, 8);
        if (str.compareTo("00") > 0 && str.compareTo("10") <= 0) {
            gc.add(2, -1);
            gc.set(5, gc.getActualMaximum(5));
            endDated = sdf.format(gc.getTime());
            gc.set(5, 20);
            startDated = sdf.format(gc.getTime());
        } else if (str.compareTo("10") > 0 && str.compareTo("20") <= 0) {
            endDated = strPre + "10";
            startDated = strPre + "01";
        } else if (str.compareTo("20") > 0 && str.compareTo("30") <= 0) {
            endDated = strPre + "20";
            startDated = strPre + "10";
        }
        List<String> stringList = new ArrayList<String>();
        stringList.add("cyc");
        stringList.add("wzj");
        for (String kk : stringList) {
            kk = "1234";
        }
        for (String yy : stringList)
            System.out.println(yy);
        return "/index";
    }

    @RequestMapping(value = "testLoad")
    public String testLoad(Model mode) {
        return "/test";
    }

}
