package com.best.great.service;

import com.best.great.entity.Channel;
import com.best.great.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChannelService {

    @Autowired
    ChannelRepository adVideoRepository;

    public Page<Channel> getChannel(Pageable pageable){
        return adVideoRepository.findAll(pageable);
    }

}
