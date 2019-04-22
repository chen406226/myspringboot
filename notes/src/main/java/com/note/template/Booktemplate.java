package com.note.template;

import com.note.util.HttpClientUtil;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2019/4/16.
 */
public class Booktemplate {
    public static String youle(String url, String bookid,String checkkey){
        String path = url+"/book/"+bookid;
        String result=checkkey;
        try {
            String searchHtml = HttpClientUtil.callUrlGet(path,"UTF-8");
            //获取dom并解析
            Document searchDocument = Jsoup.parse(searchHtml);
            if (searchDocument!=null){
                Element lastchptdiv = searchDocument.getElementsByClass("lastchpt").get(0);
                Element chptname = lastchptdiv.getElementsByClass("chptname").get(0);
                String text = chptname.text();
                String regEx = "[^0-9]";
                Pattern p = Pattern.compile(regEx);
                Matcher m = p.matcher(text);
                result = m.replaceAll("").trim();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            return checkkey;
            return result;
        }
    }


















































}
