package com.best.great.repository;

import com.best.great.entity.AdvideoComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvideoCommentRepository extends JpaRepository<AdvideoComment, String> {
}
