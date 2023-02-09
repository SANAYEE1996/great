package com.best.great.service;

import com.best.great.entity.Advideo;
import com.best.great.entity.Channel;
import com.best.great.repository.AdvideoRepository;
import com.best.great.repository.ChannelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdvideoService {
    private static final Logger log = LoggerFactory.getLogger(AdvideoService.class);


    private final AdvideoRepository advideoRepository;

    private final ChannelRepository channelRepository;

    public AdvideoService(AdvideoRepository advideoRepository, ChannelRepository channelRepository){
        this.advideoRepository = advideoRepository;
        this.channelRepository = channelRepository;
    }

    public Page<Advideo> getAdvideoList(String ch_url,Pageable pageable){
        log.info("광고 영상 리스트 현재 페이지 : {}", pageable.getPageNumber());
        ChannelService channelService = new ChannelService(channelRepository);
        Channel targetChannel = channelService.getChannelDetail(ch_url);
        return advideoRepository.findAllByChannel(targetChannel, pageable);
    }

    public Advideo getDetailAdvideo(String ad_url){
        return advideoRepository.findAdvideoByAdUrl(ad_url);
    }

}
