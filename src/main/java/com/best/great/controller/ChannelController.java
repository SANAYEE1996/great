package com.best.great.controller;

import com.best.great.entity.Channel;
import com.best.great.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/channel")
public class ChannelController {

    @Autowired
    ChannelService channelService;

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size = 10)Pageable pageable){
        Page<Channel> channels = channelService.getChannelList(pageable);
        int startPage = Math.max(1,channels.getPageable().getPageNumber()-4);
        int endPage = Math.min(channels.getTotalPages(),channels.getPageable().getPageNumber()+4);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("list",channels);


        return "youtube/channelList";
    }

    @GetMapping("/detail")
    public String detailPage(Model model,@RequestParam("ch_url") String ch_url){

        Channel channel = channelService.getChannelDetail(ch_url);
        System.out.println(channel.getCh_name());
        model.addAttribute("detail", channel);


        return "youtube/channelDetailPage";
    }
}
