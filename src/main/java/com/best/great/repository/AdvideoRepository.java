package com.best.great.repository;

import com.best.great.entity.Advideo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvideoRepository extends JpaRepository<Advideo, String> {
    Page<Advideo> findAllByChannelUrl(String ch_url, Pageable pageable);
}
