package com.qad.restfulwebservice.jwt.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qad.restfulwebservice.jwt.JwtUnAuthorizedResponseAuthenticationEntryPoint;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(JwtAuthenticationRestController.class)
@ContextConfiguration(classes = {JwtUnAuthorizedResponseAuthenticationEntryPoint.class})
public class JwtAuthenticationRestControllerITTest {


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
		ObjectMapper mapper = new ObjectMapper();
//		Map<String, String> headerMap = Map.ofEntries(
//				entry("Host", "localhost:9020"),
//				entry("User-Agent", "Mozilla/5.0 (X11; Fedora; Linux x86_64; rv:66.0) Gecko/20100101 Firefox/66.0"),
//				entry("Accept", "*/*"),
//				entry("Accept-Language", "en-US,en;q=0.5"),
//				entry("Accept-Encoding", "gzip, deflate"),
//				entry("Access-Control-Request-Method", "POST"),
//				entry("Access-Control-Request-Headers", "content-type"),
//				entry("Referer", "localhost:9020"),
//				entry("Origin", "http://localhost:9020"),
//				entry("Connection", "keep-alive"));

		HttpHeaders httpHeaders = new HttpHeaders();

//		for (Map.Entry<String, String> stringStringEntry : headerMap.entrySet()) {
//			httpHeaders.add(stringStringEntry.getKey(), stringStringEntry.getValue());
//		}


		//TODO: not working yet, should check if adminuser is present
		mvc.perform(MockMvcRequestBuilders.options("/authenticate")
				.characterEncoding("utf-8")
				.headers(httpHeaders))
				.andExpect(status().isOk());

		mvc.perform(MockMvcRequestBuilders.post("/authenticate")
//				.header("Access-Control-Request-Method", "POST")
				.header("Origin", "http://localhost:4200")
				.content(mapper.writeValueAsString(request)).characterEncoding("utf-8")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	@Ignore
	public void refreshAndGetAuthenticationToken() {
	}

	@Test
	@Ignore
	public void handleAuthenticationException() {
	}
}