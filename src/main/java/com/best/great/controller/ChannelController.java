package com.best.great.controller;

import com.best.great.dto.ChannelDto;
import com.best.great.entity.Advideo;
import com.best.great.entity.Channel;
import com.best.great.service.AdvideoService;
import com.best.great.service.ChannelService;
import com.best.great.service.CompareService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public List<ChannelDto> list(@PageableDefault(size = 10)Pageable pageable){
        //int startPage = Math.max(1,channels.getPageable().getPageNumber()-10);
        //int endPage = Math.min(channels.getTotalPages(),channels.getPageable().getPageNumber()+10);
        List<Channel> channelList = channelService.getChannelList(pageable).toList();
        List<ChannelDto> channelDtoList = new ArrayList<>();
        for(Channel channel : channelList){
            channelDtoList.add(new ChannelDto(channel.getId()
                                            ,channel.getChannelUrl()
                                            ,channel.getMonthView()
                                            ,channel.getCh_name()
                                            ,channel.getSub()
                                            ,channel.getRegdate()
                                            ,channel.getTotview()
                                            ,channel.getCategory()
                                            ,channel.getContact()
                                            ,channel.getFan()
                                            ,channel.getInsta()
                                            ,channel.getUpload()
                                            ,channel.getImg()
                                            ,channel.getTag()
                                            ,channel.getClust()
                                            ,channel.getAdavgview()
                                            ,channel.getAdcount()));
        }

        return channelDtoList;
    }

    @GetMapping("/detail/info")
    public Channel getChanneldetailInfo(@RequestParam("channelUrl") String ch_url){
        return channelService.getChannelDetail(ch_url);
    }

    @GetMapping("/detail/ad/list")
    public Page<Advideo> getChannelAdVideoList(@RequestParam("channelUrl") String ch_url, @PageableDefault(size = 5)Pageable pageable){
        return advideoService.getAdvideoList(channelService.getChannelDetail(ch_url), pageable);
    }

    @PostMapping("/search")
    public List<Channel> filterPage(@RequestParam("initial_sound") String initial_sound){
        return compareService.getSearchResult(initial_sound);
    }
}
