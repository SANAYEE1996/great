package com.best.great.integration;


import com.best.great.dto.AdvideoDto;
import com.best.great.dto.ChannelDto;
import com.best.great.dto.ChannelFilterDto;
import com.best.great.entity.Channel;
import com.best.great.service.AdvideoService;
import com.best.great.service.ChannelService;
import com.best.great.util.DtoConverter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import java.util.List;

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

    @Autowired
    private AdvideoService advideoService;

    @Autowired
    private DtoConverter dtoConverter;

    @Test
    @DisplayName("채널 상세정보 잘 가져오는지 테스트")
    public void getChannelDetailInfoTest() throws Exception{
        String channelUrl = "UCBkyj16n2snkRg1BAzpovXQ";
        String url = "http://localhost:"+port+"/channel/detail/info";

        ChannelDto channelDto = new ChannelDto(channelUrl,0,"",0,"",0.0,"","","",0,0,"","",0,0.0,0);

        ResponseEntity<String> response = restTemplate.postForEntity(url, channelDto, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Channel channel = channelService.getChannelDetail(channelUrl);

        JSONObject jsonObject = new JSONObject(response.getBody());

        assertThat(jsonObject.getString("channelUrl")).isEqualTo(channel.getChannelUrl());

    }

    @Test
    @DisplayName("채널 광고 정보 테스트")
    public void getChannelAdvertisementTest() throws Exception{
        String channelUrl = "UCBkyj16n2snkRg1BAzpovXQ";
        String url = "http://localhost:"+port+"/channel/detail/ad/list?url="+channelUrl;

        ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<AdvideoDto> advideoDtoList = dtoConverter.toAdvideoDtoList(advideoService.getAdvideoList(channelService.getChannelDetail(channelUrl)));

        JSONArray jsonArray = new JSONArray(response.getBody());
        assertThat(advideoDtoList.size()).isEqualTo(jsonArray.length());

        for(int i = 0; i < jsonArray.length(); i++){
            assertThat(jsonArray.getJSONObject(i).getString("adUrl")).isEqualTo(advideoDtoList.get(i).getAdUrl());
        }

    }

    @Test
    @DisplayName("채널 필터 통합 테스트")
    public void filterChannelTest() throws Exception{
        String url = "http://localhost:"+port+"/channel/filter";

        int minMonthView = 0;
        int maxMonthView = 10000000;
        String channelName = "";
        int minSubscribeCount = 0;
        int maxSubscribeCount = 1000000;
        ChannelFilterDto channelFilterDto = new ChannelFilterDto(minMonthView, maxMonthView, channelName, minSubscribeCount, maxSubscribeCount);

        ResponseEntity<String> response = restTemplate.postForEntity(url,channelFilterDto,String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<ChannelDto> channelDtoList = dtoConverter.toChannelDtoList((channelService.getChannelList(channelFilterDto)));

        JSONArray jsonArray = new JSONArray(response.getBody());
        assertThat(channelDtoList.size()).isEqualTo(jsonArray.length());
        for(int i = 0; i < jsonArray.length(); i++){
            assertThat(jsonArray.getJSONObject(i).getString("channelUrl")).isEqualTo(channelDtoList.get(i).getChannelUrl());
        }

    }
}
