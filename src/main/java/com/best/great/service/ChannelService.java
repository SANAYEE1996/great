package com.best.great.service;

import com.best.great.entity.Channel;
import com.best.great.repository.ChannelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChannelService {

    private static final Logger log = LoggerFactory.getLogger(ChannelService.class);

    @Autowired
    ChannelRepository channelRepository;

    public Page<Channel> getChannelList(Pageable pageable){
        Page<Channel> list = channelRepository.findAll(pageable);
        log.info("실험용 {}", list);
        log.info("여러 메서드 실행 : {}",list.toList());
        log.info("여어러 메서드 실행 : {}", channelRepository.findAll(list.nextPageable()));
        Pageable pageable1 = channelRepository.findAll(list.nextPageable()).nextPageable();
        log.info("여어러 메서드 실행 : {}", channelRepository.findAll(pageable1));

        if(list.toList().get(0).getCh_name().contains("풍")){
            log.info("크기 : {}",list.toList().size());
            //list.toList().remove(0);

        }
        return channelRepository.findAll(pageable);
    }

    public Channel getChannelDetail(String url){

        return channelRepository.findById(url).get();
    }




}
