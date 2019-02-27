package com.qad.restfulwebservice.jwt.resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(JwtAuthenticationRestController.class)
public class JwtAuthenticationRestControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private JwtAuthenticationRestController jwtAuthenticationRestController;

    private JwtTokenRequest request;

    @Before
    public void setUp() throws Exception {
        request = new JwtTokenRequest("XPlay", "rawPassword1234!ä#");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createAuthenticationToken() throws Exception {
        //TODO: not working yet, should check if adminuser is present
        mvc.perform(get("/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request.toString()))
                .andExpect(status().isOk());
    }

    @Test
    public void refreshAndGetAuthenticationToken() {
    }

    @Test
    public void handleAuthenticationException() {
    }
}