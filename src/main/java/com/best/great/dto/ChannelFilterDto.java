package com.best.great.dto;

import lombok.Getter;

@Getter
public class ChannelFilterDto {
    private int minMonthView;

    private int maxMonthView;

    private String channelName;

    private int minSubscribeCount;

    private int maxSubscribeCount;

    public ChannelFilterDto(int minMonthView, int maxMonthView, String channelName, int minSubscribeCount, int maxSubscribeCount) {
        this.minMonthView = minMonthView;
        this.maxMonthView = maxMonthView;
        this.channelName = channelName;
        this.minSubscribeCount = minSubscribeCount;
        this.maxSubscribeCount = maxSubscribeCount;
    }
}
