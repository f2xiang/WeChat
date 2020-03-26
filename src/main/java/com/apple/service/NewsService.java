package com.apple.service;

import com.apple.pojo.News;

import java.util.List;

/**
 * Created by apple on 20/3/14.
 */
public interface NewsService {

    //根据类型返回文章列表
    List<News> findListByType(String typeid);

    //文章详情
    News findById(String id);

}
