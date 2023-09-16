package me.study.getinline.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


@WebMvcTest(BaseController.class)
class BaseControllerTest {

	final private MockMvc mvc;

	BaseControllerTest(@Autowired MockMvc mvc) {
		this.mvc = mvc;
	}

	@DisplayName("[view][GET] 기본 페이지")
	@Test
	void testRoot() throws Exception {
		// given

		// when
		ResultActions result = mvc.perform(get("/"));

		// & then
		result
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
				.andExpect(content().string(containsString("This is index page")))
				.andExpect(view().name("index"))
				.andDo(print());
	}
}