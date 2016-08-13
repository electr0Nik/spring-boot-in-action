package com.github.electr0nik.mvc.controller.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasKey;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author nik
 * @since 1.XX-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WhoAmIControllerTest {

  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;

  @Before
  public void setup() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
  }

  @Test
  public void testOk() throws Exception {
    mockMvc.perform(get(WhoAmIController.URL_MAPPING)
        .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().is(200));
  }

  @Test
  public void testResponseFormat() throws Exception {
    mockMvc.perform(get(WhoAmIController.URL_MAPPING)
        .accept(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().is(200))
        .andExpect(jsonPath("$").value(hasKey("name")))
        .andExpect(jsonPath("$").value(hasKey("version")));
  }
}