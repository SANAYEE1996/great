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
        return advideoRepository.getAdvideosByChannel(targetChannel);
    }

    public Advideo getDetailAdvideo(String ad_url){
        return advideoRepository.findAdvideoByAdUrl(ad_url);
    }

}
