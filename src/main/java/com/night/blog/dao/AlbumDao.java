package com.night.blog.dao;

import com.night.blog.model.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlbumDao {

    public List<Album> findAll();

    public Long findCount();

    public List<Album> findByPage(@Param("startPos") Integer startPos, @Param("pageSize") Integer pageSize);
}
