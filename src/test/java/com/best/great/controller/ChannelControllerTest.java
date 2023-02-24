package com.best.great.controller;


import com.best.great.dto.ChannelDto;
import com.best.great.entity.Channel;
import com.best.great.service.ChannelService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@Rollback
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChannelControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ChannelService channelService;

    @Test
    @DisplayName("채널 상세정보 잘 가져오는지 테스트")
    public void getChannelDetailInfoTest() throws Exception{
        String channelUrl = "UCBkyj16n2snkRg1BAzpovXQ";
        String url = "http://localhost:"+port+"/channel/detail/info";

        ChannelDto channelDto = new ChannelDto(0L,channelUrl,0,"",0,"",0.0,"","","",0,0,"","",0,0.0,0);

        ResponseEntity<Object> response = restTemplate.postForEntity(url, channelDto, Object.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        //Channel channel = channelService.getChannelDetail(channelUrl);

        System.out.println(response.getBody());

    }
}
