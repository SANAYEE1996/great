package com.best.great.service;

import com.best.great.entity.Advideo;
import com.best.great.repository.AdvideoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdvideoService {
    private static final Logger log = LoggerFactory.getLogger(AdvideoService.class);

    @Autowired
    AdvideoRepository advideoRepository;

    public Page<Advideo> getAdvideoList(String ch_url,Pageable pageable){

        return advideoRepository.findAllByChannelUrl(ch_url, pageable);
    }

}
