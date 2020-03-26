package com.apple.controller;

import com.apple.common.Result;
import com.apple.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by apple on 20/3/13.
 */

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/list")
    public Result list() {
        return Result.ok(typeService.findList());
    }

}
