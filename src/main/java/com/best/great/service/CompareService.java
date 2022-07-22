package com.best.great.service;


import com.best.great.entity.Channel;
import com.best.great.repository.ChannelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompareService {

    private static final Logger log = LoggerFactory.getLogger(CompareService.class);

    
    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    SoundSearcherService soundSearcherService;

    public List<Channel> getSearchResult(String searchString){
        List<Channel> exam = channelRepository.findAll();
        int i = 0;
        while(i < exam.size()){
            if(!soundSearcherService.isMatch(exam.get(i).getCh_name(),searchString)){
                exam.remove(i);
                continue;
            }
            i++;
        }
        log.info("가져 온 것 : {}",exam );
        return exam;
    }

}
