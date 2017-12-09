package com.night.blog.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
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

    public static UrlParamPair searchMusicUrl(String id){
        UrlParamPair upp = new UrlParamPair();
        upp.addPara("ids","["+id+"]");
        upp.addPara("br",999000);
        upp.addPara("csrf_token","");
        return upp;
    }
    /**
     * 得到歌曲详情
     */
    public static UrlParamPair searchMusicDetail(String id){
        UrlParamPair upp = new UrlParamPair();
        JSONArray array = new JSONArray();
        JSONObject obj = new JSONObject();
        obj.put("id",id);
        array.add(obj);
        upp.addPara("c",array.toJSONString());
        upp.addPara("ids","["+id+"]");
        upp.addPara("csrf_token","");
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
     * 得到热门歌手
     */
    public static UrlParamPair getHotSingers(){
        UrlParamPair upp = new UrlParamPair();
        upp.addPara("offset",0);
        upp.addPara("total","True");
        upp.addPara("limit",15);
        upp.addPara("csrf_token","");
        return upp;
    }

    public static String randomUserAgent(){
        List<String> userAgentList = new ArrayList<String>();
        userAgentList.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");
        userAgentList.add("Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1");
        userAgentList.add("Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1");
        userAgentList.add("Linux; Android 5.0; SM-G900P Build/LRX21T) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36");
        userAgentList.add("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36");
        userAgentList.add("Linux; Android 5.1.1; Nexus 6 Build/LYZ28E) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36");
        userAgentList.add("Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_2 like Mac OS X) AppleWebKit/603.2.4 (KHTML, like Gecko) Mobile/14F89;GameHelper");
        userAgentList.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/603.2.4 (KHTML, like Gecko) Version/10.1.1 Safari/603.2.4");
        userAgentList.add("Mozilla/5.0 (iPhone; CPU iPhone OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1");
        userAgentList.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36");
        userAgentList.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.12; rv:46.0) Gecko/20100101 Firefox/46.0");
        userAgentList.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:46.0) Gecko/20100101 Firefox/46.0");
        userAgentList.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0)");
        userAgentList.add("Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0)");
        userAgentList.add("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)");
        userAgentList.add("Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Win64; x64; Trident/6.0)");
        userAgentList.add("Mozilla/5.0 (Windows NT 6.3; Win64, x64; Trident/7.0; rv:11.0) like Gecko");
        userAgentList.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36 Edge/13.10586");
        userAgentList.add("Mozilla/5.0 (iPad; CPU OS 10_0 like Mac OS X) AppleWebKit/602.1.38 (KHTML, like Gecko) Version/10.0 Mobile/14A300 Safari/602.1");
        int num = (int) Math.floor(Math.random()*userAgentList.size());
        return userAgentList.get(num);
    }

    /**
     * 进行连接并返回数据
     * @param url
     * @param req_str
     * @return
     */
    public static JSONObject getResponse(String url, String req_str) {
        Connection.Response response = null;
        try {
            response = Jsoup.connect(url)
                    .userAgent(randomUserAgent())
                    .header("Accept", "*/*")
                    .header("Cache-Control", "no-cache")
                    .header("Connection", "keep-alive")
                    .header("Host", "music.163.com")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,gl;q=0.6,zh-TW;q=0.4")
                    .header("DNT", "1")
                    .header("Pragma", "no-cache")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .header("Referer","http://music.163.com")
//                    .data(JSSecret.getDatas(req_str))
                    .data(JavaEncrypt.encrypt(req_str))
                    .method(Connection.Method.POST)
                    .ignoreContentType(true)
                    .timeout(10000)
                    .execute();
            return (JSONObject) JSON.parse(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
