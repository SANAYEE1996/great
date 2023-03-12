package com.best.great.repository;

import com.best.great.entity.Advideo;
import com.best.great.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvideoRepository extends JpaRepository<Advideo, Long> {

    List<Advideo> getAdvideosByChannel(Channel channel);


    Advideo findAdvideoByAdUrl(String ad_url);
}
