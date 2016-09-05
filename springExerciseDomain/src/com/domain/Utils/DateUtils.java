package com.domain.Utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by chenyuchao on 2016/9/5.
 */
public class DateUtils {

    public String getDate(String date) {
        System.out.println(date);
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
        String kkkk = "YSB";
        if (kkkk.contains("-")) kkkk = kkkk.substring(0, kkkk.indexOf('-'));
        Map<String, Set<String>> setMap = new HashMap<String, Set<String>>();
        Set<String> setList = new HashSet<String>();
        setList.add("abc");
        setMap.put("cyc", setList);
        return "/index";

    }
}
