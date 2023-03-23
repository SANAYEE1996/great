package com.best.great.unit.controller;

import com.best.great.dto.ChannelDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class ChannelControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void list() {
    }

    @DisplayName("채널 상세정보 잘 가져오는지 테스트")
    @Test
    void getChannelDetailInformationTest() throws Exception {
        String channelUrl = "UCBkyj16n2snkRg1BAzpovXQ";

        ChannelDto channelDto = new ChannelDto(channelUrl,0,"",0,"",0.0,"","","",0,0,"","",0,0.0,0);

        String content = objectMapper.writeValueAsString(channelDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/channel/detail/info")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(content))
                        .andExpect(status().isOk())
                .andExpect(jsonPath("channelUrl").value(equalTo(channelUrl)))
                .andExpect(jsonPath("ch_name").value(equalTo("우왁굳의 게임방송")))
                .andExpect(jsonPath("contact").value(equalTo("ecvhao@naver.com")))
                        .andDo(MockMvcResultHandlers.print());

    }

    @Test
    void getChannelAdVideoList() {
    }

    @Test
    void filterPage() {
    }
}