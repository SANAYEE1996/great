package com.best.great.controller;


import com.best.great.entity.Advideo;
import com.best.great.service.AdvideoCommentService;
import com.best.great.service.AdvideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/advideo")
public class AdvideoController {


    private final AdvideoService advideoService;

    private final AdvideoCommentService advideoCommentService;

    public AdvideoController(AdvideoService advideoService, AdvideoCommentService advideoCommentService) {
        this.advideoService = advideoService;
        this.advideoCommentService = advideoCommentService;
    }

    @GetMapping("/comment")
    public String getAdvideoComment(@RequestParam("ad_url") Long id){
        return advideoCommentService.getComment(id);
    }

    @GetMapping("/info")
    public Advideo getAdvideoInfo(@RequestParam("ad_url") String ad_url){
        return advideoService.getDetailAdvideo(ad_url);
    }

}
