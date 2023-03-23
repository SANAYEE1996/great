package com.best.great.unit.controller;

import com.best.great.controller.ChannelController;
import com.best.great.dto.ChannelDto;
import com.best.great.service.AdvideoService;
import com.best.great.service.ChannelService;
import com.best.great.service.CompareService;
import com.best.great.util.DtoConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ChannelController.class)
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
class ChannelControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private DtoConverter dtoConverter;

    @MockBean
    private ChannelService channelService;

    @MockBean
    private CompareService compareService;

    @MockBean
    private AdvideoService advideoService;

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentation) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
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

        mockMvc.perform(post("/channel/detail/info")
                .content(content)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("first"
                ,PayloadDocumentation.requestFields(
                    PayloadDocumentation.fieldWithPath("url").description("채널URL"),
                    PayloadDocumentation.fieldWithPath("content").description("").optional()
                )));

    }

    @Test
    void getChannelAdVideoList() {
    }

    @Test
    void filterPage() {
    }
}