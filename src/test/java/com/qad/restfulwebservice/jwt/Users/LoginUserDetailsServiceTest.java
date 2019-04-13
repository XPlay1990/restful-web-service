package com.qad.restfulwebservice.jwt.Users;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

/**
 * Copyright (C) 2019-2019 Jan Adamczyk <j_adamczyk@hotmail.com>
 * <p>
 * Created: 13.04.19
 * This file is part of restful-web-service
 * <p>
 * This Code can not be copied and/or distributed without the express
 * permission of Jan Adamczyk
 */
@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(classes = {LoginUserDetailsService.class})
public class LoginUserDetailsServiceTest {

	@Autowired
	private LoginUserDetailsService loginUserDetailsService;

	@Test
	public void checkAdminUserIsPresentInDB() {
		UserDetails adminUser = loginUserDetailsService.loadUserByUsername("XPlay");
		assertTrue(adminUser.isEnabled());
		assertTrue(adminUser.isAccountNonExpired());
		assertTrue(adminUser.isAccountNonLocked());
		assertTrue(adminUser.isCredentialsNonExpired());
	}
}