package com.best.great.controller;

import com.best.great.dto.AdvideoDto;
import com.best.great.dto.ChannelDto;
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
        return dtoConverter.toChannelDtoList(channelService.getChannelList(pageable).toList());
    }

    @GetMapping("/detail/info")
    public ChannelDto getChanneldetailInfo(@RequestParam("channelUrl") String ch_url){
        return dtoConverter.toChannelDto(channelService.getChannelDetail(ch_url));
    }

    @GetMapping("/detail/ad/list")
    public List<AdvideoDto> getChannelAdVideoList(@RequestParam("channelUrl") String ch_url){
        return dtoConverter.toAdvideoDtoList(advideoService.getAdvideoList(channelService.getChannelDetail(ch_url)));
    }

    @PostMapping("/search")
    public List<ChannelDto> filterPage(@RequestParam("keyword") String initial_sound){
        return dtoConverter.toChannelDtoList(compareService.getSearchResult(initial_sound));
    }
}
