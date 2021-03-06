package com.best.great.service;

import com.best.great.entity.Channel;
import com.best.great.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChannelService {

    @Autowired
    ChannelRepository adVideoRepository;

    public Page<Channel> getChannelList(Pageable pageable){
        return adVideoRepository.findAll(pageable);
    }

    public Optional<Channel> getChannelDetail(String url){

        return adVideoRepository.findById(url);
    }



}
