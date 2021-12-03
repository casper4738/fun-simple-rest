package com.fun.simple.rest;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloControllerTest extends BaseControllerTest {

    @Test
    void test() throws Exception {

        MockHttpServletResponse response = mvc.perform(
                        MockMvcRequestBuilders.get("/api/hello/test")
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello Test test"))
                .andReturn().getResponse();

        assertEquals(
                HttpStatus.OK.value(),
                response.getStatus()
        );

        assertEquals(
                "Hello Test test",
                response.getContentAsString()
        );

//        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.get("/api/hello")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andDo(MockMvcResultHandlers.print())
//                .andExpect(status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("Hello test"))
//                .andReturn().getResponse();

//        ResponseSchema responseSchema = new ObjectMapper().readValue(response.getContentAsString(), ResponseSchema.class);

    }

}