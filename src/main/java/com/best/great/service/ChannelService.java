package com.best.great.service;

import com.best.great.entity.Channel;
import com.best.great.repository.ChannelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class ChannelService {

    private static final Logger log = LoggerFactory.getLogger(ChannelService.class);


    private final ChannelRepository channelRepository;

    public ChannelService(ChannelRepository channelRepository){
        this.channelRepository = channelRepository;
    }

    public Page<Channel> getChannelList(Pageable pageable){
        log.info("현재 페이지 사이즈 : {} // 현재 페이지 넘버 : {}",pageable.getPageSize(),pageable.getPageNumber());
        return channelRepository.findAll(pageable);
    }

    public Channel getChannelDetail(String url){

        return channelRepository.getChannelByChannelUrl(url);
    }


}
