package com.saiha.util.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelperUtil {

    public String getYmd(Date now, String type) {
        SimpleDateFormat sdf;

        switch(type) {
            case "A" :
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                break;
            case "B" :
                sdf = new SimpleDateFormat("yyyy_MM_dd");
                break;
            case "C" :
                sdf = new SimpleDateFormat("yyyy.MM.dd");
                break;
            case "D" :
                sdf = new SimpleDateFormat("yyyy/MM/dd");
                break;
            case "E" :
                sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
                break;

            default :
                sdf = new SimpleDateFormat("yyyyMMdd");
                break;
        }

        String date = sdf.format(now);
        return date;
    }

    public String getYm(Date now, String type) {
        SimpleDateFormat sdf;

        switch (type) {
            case "A" :
                sdf = new SimpleDateFormat("yyyy-MM");
                break;
            case "B" :
                sdf = new SimpleDateFormat("yyyy.MM");
                break;
            case "C" :
                sdf = new SimpleDateFormat("yyyy년 MM월");
                break;
            case "D" :
                sdf = new SimpleDateFormat("yyyy/MM");
                break;
            case "E" :
                sdf = new SimpleDateFormat("yyyy_MM");
                break;

            default:
                sdf = new SimpleDateFormat("yyyyMM");
                break;
        }

        String date = sdf.format(now);
        return date;
    }

    public String getHms(Date now, String type) {
        SimpleDateFormat sdf;

        switch(type) {
            case "A" :
                sdf = new SimpleDateFormat("HH:mm:ss");
                break;
            case "B" :
                sdf = new SimpleDateFormat("HHmm");
                break;
            case "C" :
                sdf = new SimpleDateFormat("HH:mm");
                break;
            case "D" :
                sdf = new SimpleDateFormat("HHmmss.SSS");
                break;
            case "E" :
                sdf = new SimpleDateFormat("HH시 mm분 ss초");
                break;

            default :
                sdf = new SimpleDateFormat("HHmmss");
                break;
        }

        String date = sdf.format(now);
        return date;
    }

    public String getYmdhms(Date now, String type) {
        SimpleDateFormat sdf;

        switch(type) {
            case "A" :
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                break;
            case "B" :
                sdf = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
                break;
            case "C" :
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                break;
            case "D" :
                sdf = new SimpleDateFormat("yyyy년 MN월 dd일 HH시 mm분 ss초");
                break;

            default :
                sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                break;
        }

        String date = sdf.format(now);
        return date;
    }

    public String getYyyy(Date now) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String date = sdf.format(now);
        return date;
    }


}