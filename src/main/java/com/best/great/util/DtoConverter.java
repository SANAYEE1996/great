package com.best.great.util;

import com.best.great.dto.AdvideoDto;
import com.best.great.dto.ChannelDto;
import com.best.great.entity.Advideo;
import com.best.great.entity.Channel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DtoConverter {
    public ChannelDto toChannelDto(Channel channel){
        return new ChannelDto(channel.getId(),channel.getChannelUrl(),channel.getMonthView(),channel.getCh_name(),channel.getSub(),channel.getRegdate(),channel.getTotview(),channel.getCategory(),channel.getContact(),channel.getFan(),channel.getInsta(),channel.getUpload(),channel.getImg(),channel.getTag(),channel.getClust(),channel.getAdavgview(),channel.getAdcount());
    }

    public List<ChannelDto> toChannelDtoList(List<Channel> channelList){
        List<ChannelDto> channelDtoList = new ArrayList<>();
        for(Channel channel : channelList){
            channelDtoList.add(toChannelDto(channel));
        }
        return channelDtoList;
    }

    public AdvideoDto toAdvideoDto(Advideo advideo){
        return new AdvideoDto(advideo.getId(), advideo.getAdUrl(), advideo.getChannel().getChannelUrl(), advideo.getName(), advideo.getUpday(), advideo.getCategory(), advideo.getLikecnt(), advideo.getDislike(), advideo.getRatio(), advideo.getClick(), advideo.getComment(), advideo.getHashtag(), advideo.getDescript(), advideo.getForeign());
    }

    public List<AdvideoDto> toAdvideoDtoList(List<Advideo> advideoList){
        List<AdvideoDto> advideoDtoList = new ArrayList<>();
        for(Advideo advideo : advideoList){
            advideoDtoList.add(toAdvideoDto(advideo));
        }
        return advideoDtoList;
    }
}
