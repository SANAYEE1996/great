package com.best.great.service;

import com.best.great.repository.AdvideoCommentRepository;
import org.springframework.stereotype.Service;

@Service
public class AdvideoCommentService {


    AdvideoCommentRepository advideoCommentRepository;

    public String getComment(Long id){
        if(advideoCommentRepository.findById(id).isPresent()){
            return advideoCommentRepository.findById(id).get().getComment();
        }
        return "";
    }
}
