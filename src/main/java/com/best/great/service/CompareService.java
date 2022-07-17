package com.best.great.service;


import com.best.great.entity.Channel;
import com.best.great.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompareService {

    @Autowired
    ChannelRepository adVideoRepository;

    public List<Channel> getSearchResult(String searchString){
        List<Channel> exam = adVideoRepository.findAll();
        return exam;
    }

}
