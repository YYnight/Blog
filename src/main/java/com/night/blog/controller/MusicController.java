package com.night.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.night.blog.util.URLConstants;
import com.night.blog.util.UrlParamPair;
import com.night.blog.util.WebMusicConnectionApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {

    @RequestMapping("/findPlayList")
    public Object topList(){
        UrlParamPair newSongsUpp = WebMusicConnectionApi.searchTopListDetail("3779629");
        String req_str1 = newSongsUpp.getParas().toJSONString();
        UrlParamPair hotSongsUpp = WebMusicConnectionApi.searchTopListDetail("19723756");
        String req_str2 = hotSongsUpp.getParas().toJSONString();
        UrlParamPair elecSoundUpp = WebMusicConnectionApi.searchTopListDetail("10520166");
        String req_str3 = elecSoundUpp.getParas().toJSONString();
        JSONObject newSongs = WebMusicConnectionApi.getResponse(URLConstants.topListURL,req_str1);
        JSONObject hotSongs = WebMusicConnectionApi.getResponse(URLConstants.topListURL,req_str2);
        JSONObject elecSoundSongs = WebMusicConnectionApi.getResponse(URLConstants.topListURL,req_str3);
        newSongs.remove("code");
        hotSongs.remove("code");
        elecSoundSongs.remove("code");
        JSONObject data = new JSONObject();
        List<Object> objectList = new ArrayList<Object>();
        JSONObject object = new JSONObject();
        object.put("newSongs",newSongs);
        object.put("hotSongs",hotSongs);
        object.put("elecSongs",elecSoundSongs);
        data.put("code",200);
        data.put("data",object);
        return data;
    }

    @GetMapping("/findMusicById")
    public Object findMusicById(@RequestParam("id")String id){
        UrlParamPair upp = WebMusicConnectionApi.searchMusicDetail(id);
        String req_str = upp.getParas().toJSONString();
        return WebMusicConnectionApi.getResponse(URLConstants.findMusicByIdURL,req_str);
    }
}
