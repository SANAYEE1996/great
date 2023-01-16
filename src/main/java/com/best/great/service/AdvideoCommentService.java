package com.best.great.service;

import com.best.great.repository.AdvideoCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvideoCommentService {


    AdvideoCommentRepository advideoCommentRepository;

    public String getComment(String url){
        if(advideoCommentRepository.findById(url).isPresent()){
            return advideoCommentRepository.findById(url).get().getComment();
        }
        return "";
    }
}
