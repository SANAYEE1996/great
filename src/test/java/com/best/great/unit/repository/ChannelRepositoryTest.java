package com.best.great.unit.repository;

import com.best.great.entity.Channel;
import com.best.great.repository.ChannelRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ChannelRepositoryTest {

    @Autowired
    private ChannelRepository channelRepository;

    @Test
    @DisplayName("채널 상세정보 잘 가져오는지 테스트")
    public void getChannelDetailInfoTest() throws Exception{
        String channelUrl = "UCBkyj16n2snkRg1BAzpovXQ";

        Channel channel = channelRepository.getChannelByChannelUrl(channelUrl);

        assertThat(channel.getChannelUrl()).isEqualTo(channelUrl);
    }
}
