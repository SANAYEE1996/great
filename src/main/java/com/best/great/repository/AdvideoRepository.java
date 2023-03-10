package com.best.great.repository;

import com.best.great.entity.Advideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdvideoRepository extends JpaRepository<Advideo, Long> {

    @Query("select ad.id,ad.name,ad.upday,ad.category,ad.upday,ad.click " +
            "from advideo ad left join fetch channel channel on ad.channel.channelUrl = channel.channelUrl " +
            "where channel.channelUrl = :channel_url")
    List<Advideo> getAllAdvideos(String channel_url);


    Advideo findAdvideoByAdUrl(String ad_url);
}
