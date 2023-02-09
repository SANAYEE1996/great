package com.best.great.controller;

import com.best.great.entity.Channel;
import com.best.great.service.ChannelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebAppConfiguration
@ContextConfiguration
public class ChannelControllerTest {

    @InjectMocks
    public ChannelController channelController;

    @Mock
    ChannelService channelService;

    private MockMvc mockMvc;

    @BeforeEach
    public void createController(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(channelController).build();
    }

    @Test
    public void getChannelDetailInfoTest() throws Exception{
        String channelUrl = "UCBkyj16n2snkRg1BAzpovXQ";

        RequestBuilder reqBuilder = MockMvcRequestBuilders.get("/channel/detail/info?channelUrl="+channelUrl).contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(reqBuilder).andExpect(status().isOk()).andDo(print());

        verify(channelService).getChannelDetail(channelUrl);

    }
}
