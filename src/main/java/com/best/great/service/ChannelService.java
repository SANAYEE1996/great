package com.best.great.service;

import com.best.great.entity.Channel;
import com.best.great.repository.ChannelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ChannelService {

    private static final Logger log = LoggerFactory.getLogger(ChannelService.class);

    @Autowired
    ChannelRepository channelRepository;

    public Page<Channel> getChannelList(Pageable pageable){
        return channelRepository.findAll(pageable);
    }

    public Channel getChannelDetail(String url){
        return channelRepository.findById(url).get();
    }


}
