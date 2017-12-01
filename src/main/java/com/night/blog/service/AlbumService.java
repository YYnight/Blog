package com.night.blog.service;

import com.night.blog.model.Album;
import com.night.blog.model.PageBean;

import java.util.List;

public interface AlbumService {
    /**
     * 查询所有的相册
     * @return
     */
    public List<Album> findAll();

    /**
     * 分页查询相册
     */
    public PageBean<Album> findByPage(Integer page);
}
