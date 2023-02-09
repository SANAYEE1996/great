package com.best.great.repository;

import com.best.great.entity.Advideo;
import com.best.great.entity.Channel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvideoRepository extends JpaRepository<Advideo, Long> {
    Page<Advideo> findAllByChannel(Channel channel, Pageable pageable);

    Advideo findAdvideoByAdUrl(String ad_url);
}
