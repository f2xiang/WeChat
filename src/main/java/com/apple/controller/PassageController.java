package com.apple.controller;

import com.apple.common.Result;
import com.apple.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by apple on 20/3/14.
 */
@RestController
@RequestMapping("/passage")
public class PassageController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/list/{typeid}")
    private Result list(@PathVariable String typeid) {
        return Result.ok(newsService.findListByType(typeid));
    }

    @GetMapping("/info/{id}")
    private Result info(@PathVariable String id) {
        return Result.ok(newsService.findById(id));
    }

}
