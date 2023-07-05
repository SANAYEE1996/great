package com.best.great.repository.support;

import com.best.great.dto.ChannelFilterDto;
import com.best.great.entity.Channel;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.best.great.entity.QChannel.channel;


@Repository
public class ChannelRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public ChannelRepositorySupport(JPAQueryFactory queryFactory) {
        super(Channel.class);
        this.queryFactory = queryFactory;
    }

    public List<Channel> getFilterChannelList(ChannelFilterDto channelFilterDto){
        BooleanBuilder builder = new BooleanBuilder();
        appendChannelFilterCondition(channelFilterDto,builder);
        List<Channel> result = queryFactory
                            .select(channel)
                            .from(channel)
                            .where(builder)
                            .fetch();

        return result;
    }

    private void appendChannelFilterCondition(ChannelFilterDto channelFilterDto, BooleanBuilder builder){
        if(StringUtils.hasText(channelFilterDto.getChannelName())){
            builder.and(channel.ch_name.contains(channelFilterDto.getChannelName()));
        }
        builder.and(channel.monthView.between(channelFilterDto.getMinMonthView(),channelFilterDto.getMaxMonthView()));
        builder.and(channel.sub.between(channelFilterDto.getMinSubscribeCount(), channelFilterDto.getMaxSubscribeCount()));
    }
}
