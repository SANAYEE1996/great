package com.best.great.service;

import com.best.great.entity.Advideo;
import com.best.great.entity.Channel;
import com.best.great.repository.AdvideoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdvideoService {
    private static final Logger log = LoggerFactory.getLogger(AdvideoService.class);


    private final AdvideoRepository advideoRepository;


    public AdvideoService(AdvideoRepository advideoRepository){
        this.advideoRepository = advideoRepository;
    }

    public Page<Advideo> getAdvideoList(String ch_url,Pageable pageable){
        log.info("광고 영상 리스트 현재 페이지 : {}", pageable.getPageNumber());
        ChannelService channelService = null;
        Channel targetChannel = channelService.getChannelDetail(ch_url);
        return advideoRepository.findAllByChannel(targetChannel, pageable);
    }

    public Advideo getDetailAdvideo(String ad_url){
        return advideoRepository.findAdvideoByAdUrl(ad_url);
    }

}
