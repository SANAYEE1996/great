package com.best.great.controller;

import com.best.great.dto.AdvideoDto;
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
        return getChannelDtos(channelList);
    }

    @GetMapping("/detail/info")
    public ChannelDto getChanneldetailInfo(@RequestParam("channelUrl") String ch_url){
        Channel channel = channelService.getChannelDetail(ch_url);
        ChannelDto channelDto = new ChannelDto(channel.getId()
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
                                                ,channel.getAdcount());
        return channelDto;
    }

    @GetMapping("/detail/ad/list")
    public List<AdvideoDto> getChannelAdVideoList(@RequestParam("channelUrl") String ch_url, @PageableDefault(size = 5)Pageable pageable){
        List<Advideo> advideoList = advideoService.getAdvideoList(channelService.getChannelDetail(ch_url), pageable);
        return getAdvideoDtos(advideoList);
    }

    @PostMapping("/search")
    public List<ChannelDto> filterPage(@RequestParam("keyword") String initial_sound){
        List<Channel> channelList = compareService.getSearchResult(initial_sound);
        return getChannelDtos(channelList);
    }

    private List<ChannelDto> getChannelDtos(List<Channel> channelList) {
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

    private List<AdvideoDto> getAdvideoDtos(List<Advideo> advideoList){
        List<AdvideoDto> advideoDtoList = new ArrayList<>();

        return advideoDtoList;
    }
}
