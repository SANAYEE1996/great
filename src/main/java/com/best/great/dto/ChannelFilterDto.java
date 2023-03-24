package com.best.great.dto;

import lombok.Getter;

@Getter
public class ChannelFilterDto {
    private int minMonthView;

    private int maxMonthView;

    private String channelName;

    private int minSubscribeCount;

    private int maxSubscribeCount;


}
