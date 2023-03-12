package com.best.great.service;

import com.best.great.entity.Advideo;
import com.best.great.entity.Channel;
import com.best.great.repository.AdvideoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvideoService {
    private static final Logger log = LoggerFactory.getLogger(AdvideoService.class);


    private final AdvideoRepository advideoRepository;


    public AdvideoService(AdvideoRepository advideoRepository){
        this.advideoRepository = advideoRepository;
    }

    public List<Advideo> getAdvideoList(Channel targetChannel){
        log.info("찾으려는 채널 주인 URL : {}",targetChannel.getChannelUrl());
        log.info("찾으려는 채널 주인 이름 : {}",targetChannel.getCh_name());
        List<Advideo> advideoList = advideoRepository.getAdvideosByChannel(targetChannel);
        log.info(",,, {}",advideoList);
        log.info(",,, {}",advideoList.size());
        log.info(",,, {}",advideoList.isEmpty());
        return advideoList;
    }

    public Advideo getDetailAdvideo(String ad_url){
        return advideoRepository.findAdvideoByAdUrl(ad_url);
    }

}
