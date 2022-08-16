package com.best.great.controller;

import com.best.great.entity.Channel;
import com.best.great.service.ChannelService;
import com.best.great.service.CompareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/channel")
public class ChannelController {

    private static final Logger log = LoggerFactory.getLogger(ChannelController.class);

    @Autowired
    ChannelService channelService;

    @Autowired
    CompareService compareService;

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
        String img = channel.getImg();
        log.info("channel detail information : {} ", channel);
        log.info("channel img : {} ", img);
        model.addAttribute("imgUrl", img);
        model.addAttribute("detail", channel);


        return "youtube/channelDetailPage";
    }

    @PostMapping("/search")
    public String filterPage(Model model,@RequestParam("initial_sound") String initial_sound){

        List<Channel> getList = compareService.getSearchResult(initial_sound);
        log.info("결과 : {}", getList);
        model.addAttribute("list",getList);

        return "youtube/channelSearchList";
    }
}
