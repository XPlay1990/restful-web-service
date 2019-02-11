package com.qad.restfulwebservice.jwt;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.Assert.*;

public class JWTWebSecurityConfigTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void passwordEncoderBean() {
    }

    @Test
    public void bcryptEncoderTest(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        for(int i=0; i<10;i++){
            String encodedString = encoder.encode("rawPassword1234!ä#");
            System.out.println(encodedString);
            assertTrue(!encodedString.isEmpty());
        }
    }
}