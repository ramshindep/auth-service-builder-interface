package org.dnyanyog.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import javax.xml.xpath.XPathExpressionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testng.annotations.Test;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest extends AbstractTestNGSpringContextTests {

	@Autowired
	MockMvc mockMvc;

	@Test(priority = 1)
	public void verifyAddUser() throws XPathExpressionException, Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/auth/user")
				.content("\"username\":\"gaurav\",\r\n" + "    \"password\":\"gaurav@123\",\r\n"
						+ "    \"email\":\"gaurav@gmail.com\",\r\n" + "    \"age\":\"21\"")
				.contentType(MediaType.APPLICATION_XML_VALUE).accept(MediaType.APPLICATION_XML_VALUE);

		MvcResult result = mockMvc.perform(requestBuilder).andExpect(status().isOk())
				.andExpect(xpath("/userData/status").string("Success"))
				.andExpect(xpath("/UserData/message").string("User added successfuly"))

				.andReturn();

	}

}

