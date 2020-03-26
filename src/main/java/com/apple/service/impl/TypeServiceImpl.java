package com.apple.service.impl;

import com.apple.mapper.TypeMapper;
import com.apple.pojo.Type;
import com.apple.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by apple on 20/3/14.
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> findList() {
        return typeMapper.findAll();
    }
}
