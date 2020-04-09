package com.rent.carrentwebapi.controller_test;

import com.baomidou.mybatisplus.plugins.Page;
import com.google.gson.JsonObject;
import com.rent.carrentcommon.exception.MyException;
import com.rent.carrentcommon.util.ParserUtil;
import com.rent.carrentdal.dto.CarDto;
import com.rent.carrentservice.service.CarService;
import com.rent.carrentwebapi.AbstractTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


@Slf4j
@AutoConfigureMockMvc
@WebAppConfiguration
public class CarControllerTest extends AbstractTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private CarService carService;


    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Page<CarDto> carPage = new Page<>();
        carPage.setSize(1);
        try {
//            when(carService.queryList(any())).thenReturn(carPage);
            when(carService.queryList(any())).thenThrow(MyException.fail("car controller exception test"));
        } catch (Exception e) {
            log.error("CarControllerTest|setup|error:{}", e);
        }

    }

    @Test
    public void queryTest() throws Exception {

        String url = "/car/v1/getCarsList";
        CarDto carDto = new CarDto();
        carDto.setModel("Camry");
        carDto.setPage(1);
        carDto.setPage(2);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ParserUtil.GSON.toJson(carDto));

        MvcResult mvcResult = this.mockMvc
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        JsonObject rtJSON = ParserUtil.GSON.fromJson(contentAsString, JsonObject.class);
        log.info(contentAsString);
        int size = rtJSON.getAsJsonObject("data").get("size").getAsInt();

        Assert.assertTrue(size == 1);

    }

    @Test
    public void queryTest0() throws Exception {

        String url = "/car/v1/getCarsList";
        CarDto carDto = new CarDto();
        carDto.setModel("Camry");
        carDto.setPage(1);
        carDto.setPage(2);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(ParserUtil.GSON.toJson(carDto));

        MvcResult mvcResult = this.mockMvc
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        JsonObject rtJSON = ParserUtil.GSON.fromJson(contentAsString, JsonObject.class);
        log.info(contentAsString);
        int state = rtJSON.get("state").getAsInt();

        Assert.assertTrue(state == 1);

    }
}
