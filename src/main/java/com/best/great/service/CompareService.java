package com.best.great.service;


import com.best.great.entity.Channel;
import com.best.great.repository.ChannelRepository;
import com.best.great.util.SoundSearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompareService {

    private static final Logger log = LoggerFactory.getLogger(CompareService.class);

    
    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    SoundSearcher soundSearcherService;

    public List<Channel> getSearchResult(String searchString){
        List<Channel> exam = channelRepository.findAll();
        List<Channel> getSearchResultList = new ArrayList<>();
        for(int i=0; i < exam.size(); i++){
            if(soundSearcherService.isMatch(exam.get(i).getCh_name(),searchString)){
                getSearchResultList.add(exam.get(i));
            }
        }
        exam.clear(); //초기화 ? 굳이?
        log.info("가져 온 것 : {}",getSearchResultList );
        return getSearchResultList;
    }


}
