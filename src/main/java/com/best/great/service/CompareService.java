package com.best.great.service;


import com.best.great.entity.Channel;
import com.best.great.repository.ChannelRepository;
import com.best.great.util.SoundSearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompareService {

    private static final Logger log = LoggerFactory.getLogger(CompareService.class);

    

    ChannelRepository channelRepository;


    SoundSearcher soundSearcherService;

    public List<Channel> getSearchResult(String searchString){
        List<Channel> exam = channelRepository.findAll();
        List<Channel> getSearchResultList = new ArrayList<>();
        for (Channel channel : exam) {
            if (soundSearcherService.isMatch(channel.getCh_name(), searchString)) {
                getSearchResultList.add(channel);
            }
        }
        exam.clear(); //초기화 ? 굳이?
        log.info("가져 온 것 : {}",getSearchResultList );
        return getSearchResultList;
    }


}
