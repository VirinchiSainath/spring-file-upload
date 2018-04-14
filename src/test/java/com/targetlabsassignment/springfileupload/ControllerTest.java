package com.targetlabsassignment.springfileupload;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.UnsupportedEncodingException;
import java.net.URI;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringFileUploadApplication.class)
@WebAppConfiguration
public class ControllerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
	
	
	@Test
	public void testWelcomeUser() {
		
		URI uri = URI.create("/api/");
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(org.springframework.http.MediaType.APPLICATION_JSON);
		MvcResult result = null;
		try {
			System.out.println(mockMvc.perform(requestBuilder));
			result = mockMvc.perform(requestBuilder).andReturn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String expectedOutput = "Welcome to Spring File Upload";
		String outputByTest = null;
		try {
			outputByTest = result.getResponse().getContentAsString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("----------------------------------------");
		System.out.println("ExpectedOutput "+ expectedOutput);
		System.out.println("OutputByTest "+ outputByTest);
		System.out.println("----------------------------------------");
		assertThat(expectedOutput, is(outputByTest));
		
	}

}
