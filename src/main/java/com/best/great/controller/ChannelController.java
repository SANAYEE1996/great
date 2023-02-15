package com.best.great.controller;

import com.best.great.dto.AdvideoDto;
import com.best.great.dto.ChannelDto;
import com.best.great.entity.Advideo;
import com.best.great.entity.Channel;
import com.best.great.service.AdvideoService;
import com.best.great.service.ChannelService;
import com.best.great.service.CompareService;
import com.best.great.util.DtoConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/channel")
public class ChannelController {

    private static final Logger log = LoggerFactory.getLogger(ChannelController.class);

    private final DtoConverter dtoConverter;

    private final ChannelService channelService;


    private final CompareService compareService;


    private final AdvideoService advideoService;

    public ChannelController(DtoConverter dtoConverter, ChannelService channelService, CompareService compareService, AdvideoService advideoService) {
        this.dtoConverter = dtoConverter;
        this.channelService = channelService;
        this.compareService = compareService;
        this.advideoService = advideoService;
    }

    @GetMapping("/list")
    public List<ChannelDto> list(@PageableDefault(size = 10)Pageable pageable){
        //int startPage = Math.max(1,channels.getPageable().getPageNumber()-10);
        //int endPage = Math.min(channels.getTotalPages(),channels.getPageable().getPageNumber()+10);
        List<Channel> channelList = channelService.getChannelList(pageable).toList();
        return dtoConverter.toChannelDtoList(channelList);
    }

    @GetMapping("/detail/info")
    public ChannelDto getChanneldetailInfo(@RequestParam("channelUrl") String ch_url){
        Channel channel = channelService.getChannelDetail(ch_url);
        return dtoConverter.toChannelDto(channel);
    }

    @GetMapping("/detail/ad/list")
    public List<AdvideoDto> getChannelAdVideoList(@RequestParam("channelUrl") String ch_url, @PageableDefault(size = 5)Pageable pageable){
        List<Advideo> advideoList = advideoService.getAdvideoList(channelService.getChannelDetail(ch_url), pageable);
        log.info("list : {}", advideoList);
        return dtoConverter.toAdvideoDtoList(advideoList);
    }

    @PostMapping("/search")
    public List<ChannelDto> filterPage(@RequestParam("keyword") String initial_sound){
        List<Channel> channelList = compareService.getSearchResult(initial_sound);
        return dtoConverter.toChannelDtoList(channelList);
    }
}
