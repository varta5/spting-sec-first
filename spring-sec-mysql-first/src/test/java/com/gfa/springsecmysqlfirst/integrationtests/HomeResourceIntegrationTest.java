package com.gfa.springsecmysqlfirst.integrationtests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(value = {"/deleteallusers.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class HomeResourceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Sql({"/loaduserfour.sql"})
    @Sql({"/deleteusertwo.sql"})
    @Sql(value = {"/deleteuserthree.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void test_SqlDataLoad_First() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Stranger!"));
    }

    @Test
    public void test_SqlDataLoad_Second() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Stranger!"));
    }

    @Test
    @Sql({"/loadusersix.sql"})
    public void test_SqlDataLoad_Third() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Stranger!"));
    }

}
