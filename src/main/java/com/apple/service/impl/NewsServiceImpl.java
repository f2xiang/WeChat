package com.apple.service.impl;

import com.apple.mapper.NewsMapper;
import com.apple.mapper.PassageMapper;
import com.apple.mapper.UserMapper;
import com.apple.pojo.News;
import com.apple.pojo.NewsExample;
import com.apple.pojo.Passage;
import com.apple.pojo.PassageExample;
import com.apple.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by apple on 20/3/14.
 */
@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;



    @Override
    public List<News> findListByType(String typeid) {
        NewsExample example = new NewsExample();
        example.createCriteria().andTypeIdEqualTo(typeid);
        return newsMapper.selectByExample(example);
    }

    @Override
    public News findById(String id) {
        return newsMapper.selectByPrimaryKey(id);
    }
}
