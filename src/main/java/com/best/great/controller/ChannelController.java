package com.best.great.controller;

import com.best.great.entity.Advideo;
import com.best.great.entity.Channel;
import com.best.great.service.AdvideoService;
import com.best.great.service.ChannelService;
import com.best.great.service.CompareService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public Page<Channel> list(@PageableDefault(size = 10)Pageable pageable){
        //int startPage = Math.max(1,channels.getPageable().getPageNumber()-10);
        //int endPage = Math.min(channels.getTotalPages(),channels.getPageable().getPageNumber()+10);
        return channelService.getChannelList(pageable);
    }

    @GetMapping("/detail/info")
    public Channel getChanneldetailInfo(@RequestParam("channelUrl") String ch_url){
        return channelService.getChannelDetail(ch_url);
    }

    @GetMapping("/detail/ad/list")
    public Page<Advideo> getChannelAdVideoList(@RequestParam("channelUrl") String ch_url, @PageableDefault(size = 5)Pageable pageable){
        //int startPage = Math.max(1,list.getPageable().getPageNumber()-5);
        //int endPage = Math.min(list.getTotalPages(),list.getPageable().getPageNumber()+5);
        return advideoService.getAdvideoList(ch_url, pageable);
    }

    @PostMapping("/search")
    public List<Channel> filterPage(@RequestParam("initial_sound") String initial_sound){
        return compareService.getSearchResult(initial_sound);
    }
}
