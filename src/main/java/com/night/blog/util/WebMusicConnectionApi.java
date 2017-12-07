package com.night.blog.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
{
        "0": ["云音乐新歌榜", "3779629"],
        "1": ["云音乐热歌榜", "3778678"],
        "2": ["网易原创歌曲榜", "2884035"],
        "3": ["云音乐飙升榜", "19723756"],
        "4": ["云音乐电音榜", "10520166"],
        "5": ["UK排行榜周榜", "180106"],
        "6": ["美国Billboard周榜", "60198"],
        "7": ["KTV嗨榜", "21845217"],
        "8": ["iTunes榜", "11641012"],
        "9": ["Hit FM Top榜", "120001"],
        "10": ["日本Oricon周榜", "60131"],
        "11": ["韩国Melon排行榜周榜", "3733003"],
        "12": ["韩国Mnet排行榜周榜", "60255"],
        "13": ["韩国Melon原声周榜", "46772709"],
        "14": ["中国TOP排行榜(港台榜)", "112504"],
        "15": ["中国TOP排行榜(内地榜)", "64016"],
        "16": ["香港电台中文歌曲龙虎榜", "10169002"],
        "17": ["华语金曲榜", "4395559"],
        "18": ["中国嘻哈榜", "1899724"],
        "19": ["法国 NRJ EuroHot 30周榜", "27135204"],
        "20": ["台湾Hito排行榜", "112463"],
        "21": ["Beatport全球电子舞曲榜", "3812895"]
        };*/
public class WebMusicConnectionApi {

    public static UrlParamPair searchMusicDetail(String id){
        UrlParamPair upp = new UrlParamPair();
        upp.addPara("ids","["+id+"]");
        upp.addPara("br",999000);
        upp.addPara("csrf_tiken","");
        return upp;
    }

    /**
     * 搜索榜单参数封装
     * @param id
     * @return
     */
    public static UrlParamPair searchTopListDetail(String id){
        UrlParamPair upp = new UrlParamPair();
        upp.addPara("id",id);
        upp.addPara("offset",0);
        upp.addPara("total","Flase");
        upp.addPara("limit",10);
        upp.addPara("n",1000);
        upp.addPara("csrf_token","nothing");
        return upp;
    }

    /**
     * 获取用户歌单
     *
     * @param uid
     * @return
     */
    public static UrlParamPair SearchMusicList(String s,String type){
        UrlParamPair upp = new UrlParamPair();
        upp.addPara("s",s);
        upp.addPara("type",type);
        upp.addPara("offset",0);
        upp.addPara("total","False");
        upp.addPara("limit",20);
        upp.addPara("n",1000);
        upp.addPara("csrf_token","nothing");
        return upp;
    }

    /**
     * 进行连接并返回数据
     * @param url
     * @param req_str
     * @return
     */
    public static JSONObject getResponse(String url, String req_str){
        Connection.Response response = null;
        try {
            response = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:57.0) Gecko/20100101 Firefox/57.0")
                    .header("Accept", "*/*")
                    .header("Cache-Control", "no-cache")
                    .header("Connection", "keep-alive")
                    .header("Host", "music.163.com")
                    .header("Accept-Language", "zh-CN,en-US;q=0.7,en;q=0.3")
                    .header("DNT", "1")
                    .header("Pragma", "no-cache")
                    .header("Content-Type", "application/x-www-form-urlencoded")
//                    .data(JSSecret.getDatas(req_str))
                    .data(JavaEncrypt.encrypt(req_str))
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .timeout(10000)
                    .execute();
            return (JSONObject) JSON.parse(response.body());
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
