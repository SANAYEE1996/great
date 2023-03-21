package com.best.great.repository.support;

import com.best.great.entity.Channel;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.best.great.entity.QChannel.channel;

@Repository
public class ChannelRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public ChannelRepositorySupport(JPAQueryFactory queryFactory) {
        super(Channel.class);
        this.queryFactory = queryFactory;
    }

    public List<Channel> getFilterChannelList(){
        List<Channel> result = queryFactory
                            .select(channel)
                            .from(channel)
                            .fetch();

        return result;
    }
}
