package com.best.great.controller;


import com.best.great.entity.Advideo;
import com.best.great.service.AdvideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/advideo")
public class AdvideoController {

    @Autowired
    AdvideoService advideoService;

    @GetMapping("/detail")
    public String getAdvideoDetail(Model model, @RequestParam("ad_url") String ad_url){
        Advideo getAdvideoDetailList = advideoService.getDetailAdvideo(ad_url).get();
        model.addAttribute("detail",getAdvideoDetailList);

        return "youtube/adVideoDetailPage";
    }

}
