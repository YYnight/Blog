package com.night.blog.service;

import com.night.blog.model.PageBean;
import com.night.blog.model.Photograph;

public interface PhotographService {

    /**
     * 根据相册Id分页查询相片
     */
    public PageBean<Photograph> findPhotographByPhotoIdAndPage(Integer photoId,Integer pageNow);
}
