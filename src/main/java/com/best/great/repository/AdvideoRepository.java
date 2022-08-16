package com.best.great.repository;

import com.best.great.entity.Advideo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvideoRepository extends JpaRepository<Advideo, String> {
    List<Advideo> findAllByChannelUrl(String ch_url);
}
