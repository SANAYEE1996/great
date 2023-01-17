package com.best.great.controller;

import com.best.great.entity.Advideo;
import com.best.great.entity.Channel;
import com.best.great.service.AdvideoService;
import com.best.great.service.ChannelService;
import com.best.great.service.CompareService;
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



    private final ChannelService channelService;


    private final CompareService compareService;


    private final AdvideoService advideoService;

    public ChannelController(ChannelService channelService, CompareService compareService, AdvideoService advideoService) {
        this.channelService = channelService;
        this.compareService = compareService;
        this.advideoService = advideoService;
    }

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size = 10)Pageable pageable){
        Page<Channel> channels = channelService.getChannelList(pageable);
        int startPage = Math.max(1,channels.getPageable().getPageNumber()-10);
        int endPage = Math.min(channels.getTotalPages(),channels.getPageable().getPageNumber()+10);


        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("list",channels);

        return "youtube/channelList";
    }

    @GetMapping("/detail")
    public String detailPage(Model model,@RequestParam("channelUrl") String ch_url, @PageableDefault(size = 5)Pageable pageable){

        Channel channel = channelService.getChannelDetail(ch_url);
        String img = channel.getImg();
        Page<Advideo> list = advideoService.getAdvideoList(ch_url, pageable);
        int startPage = Math.max(1,list.getPageable().getPageNumber()-5);
        int endPage = Math.min(list.getTotalPages(),list.getPageable().getPageNumber()+5);


        model.addAttribute("imgUrl", img);
        model.addAttribute("detail", channel);
        model.addAttribute("list", list);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("chUrl", ch_url);

        return "youtube/channelDetailPage";
    }

    @PostMapping("/search")
    public String filterPage(Model model,@RequestParam("initial_sound") String initial_sound){

        List<Channel> getList = compareService.getSearchResult(initial_sound);

        model.addAttribute("searchString",initial_sound);
        model.addAttribute("list",getList);

        return "youtube/channelSearchList";
    }
}
