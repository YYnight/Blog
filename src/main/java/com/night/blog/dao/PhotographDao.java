package com.night.blog.dao;

import com.night.blog.model.Photograph;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhotographDao {

    /**
     * 根据相册id查询相片
     */
    public List<Photograph> findByPhotoId(Integer photoId);

    /**
     * 根据相册Id分页查询相片
     */
    public List<Photograph> finByPhotoIdAndPage(@Param("photoId")Integer photoId,@Param("startPos")Integer startPos,@Param("pageSize")Integer pageSize);

    /**
     * 根据相册Id查询该相册的照片数量
     */
    public Long findCountByPhotoId(Integer photoId);
}
