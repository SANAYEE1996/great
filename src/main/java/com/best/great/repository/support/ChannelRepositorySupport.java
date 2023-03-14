package com.best.great.repository.support;

import com.best.great.entity.Channel;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class ChannelRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory queryFactory;

    public ChannelRepositorySupport(JPAQueryFactory queryFactory) {
        super(Channel.class);
        this.queryFactory = queryFactory;
    }
}
