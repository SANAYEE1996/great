package com.best.great.controller;


import com.best.great.entity.Advideo;
import com.best.great.service.AdvideoCommentService;
import com.best.great.service.AdvideoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/advideo")
public class AdvideoController {


    private final AdvideoService advideoService;

    private final AdvideoCommentService advideoCommentService;

    public AdvideoController(AdvideoService advideoService, AdvideoCommentService advideoCommentService) {
        this.advideoService = advideoService;
        this.advideoCommentService = advideoCommentService;
    }

    @GetMapping("/detail")
    public String getAdvideoDetail(Model model, @RequestParam("ad_url") String ad_url){
        Advideo getAdvideoDetailList = advideoService.getDetailAdvideo(ad_url);
        String comment = advideoCommentService.getComment(ad_url);
        model.addAttribute("detail",getAdvideoDetailList);
        model.addAttribute("comment",comment);

        return "youtube/adVideoDetailPage";
    }

}
