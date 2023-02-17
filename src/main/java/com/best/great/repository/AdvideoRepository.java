package com.best.great.repository;

import com.best.great.entity.Advideo;
import com.best.great.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdvideoRepository extends JpaRepository<Advideo, Long> {

    @Query(value="select x from advideo x "
                +" where x.channel.channelUrl = :url")
    List<Advideo> findAllAdvideosByChannel(@Param(value = "url") String channelUrl);

    Advideo findAdvideoByAdUrl(String ad_url);
}
