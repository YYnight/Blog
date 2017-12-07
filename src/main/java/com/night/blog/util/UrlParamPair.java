package com.night.blog.util;

import com.alibaba.fastjson.JSONObject;

public class UrlParamPair {
    private String url;
    private JSONObject paras;

    public UrlParamPair() {
        this.paras = new JSONObject();
    }

    public UrlParamPair(String url, JSONObject paras) {
        this.url = url;
        this.paras = paras;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JSONObject getParas() {
        return paras;
    }

    public void setParas(JSONObject paras) {
        this.paras = paras;
    }
    public UrlParamPair addPara(String key,Object value){
        this.paras.put(key,value.toString());
        return this;
    }

    @Override
    public String toString() {
        return "UrlParamPair{" +
                "url='" + url + '\'' +
                ", paras=" + paras +
                '}';
    }
}
