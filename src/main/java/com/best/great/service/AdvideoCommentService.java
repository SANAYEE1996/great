package com.best.great.service;

import com.best.great.entity.AdvideoComment;
import com.best.great.repository.AdvideoCommentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdvideoCommentService {


    private final AdvideoCommentRepository advideoCommentRepository;

    public AdvideoCommentService(AdvideoCommentRepository advideoCommentRepository){
        this.advideoCommentRepository = advideoCommentRepository;
    }

    public String getComment(Long id){
        Optional<AdvideoComment> advideoCommentOptional = advideoCommentRepository.findById(id);
        if(advideoCommentOptional.isPresent()){
            return advideoCommentOptional.get().getComment();
        }
        return "";
    }
}
