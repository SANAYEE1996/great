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
        log.info("size :  {}", list.get().collect(Collectors.toList()).size());
        if(list.get().collect(Collectors.toList()).get(0).getCh_name().contains("풍")){
            list.get().collect(Collectors.toList()).remove(0);
            log.info("삭제 됐나?");
            log.info("진짜 삭제됐나? : {}",list.get().collect(Collectors.toList()).get(0).getCh_name());
        }
        log.info("실험용 {}", list);
        log.info("size :  {}", list.get().collect(Collectors.toList()).size());
        log.info("for 실험 : {}",list.get().collect(Collectors.toList()).get(0).getCh_name());
        return channelRepository.findAll(pageable);
    }

    public Optional<Channel> getChannelDetail(String url){

        return channelRepository.findById(url);
    }



}
