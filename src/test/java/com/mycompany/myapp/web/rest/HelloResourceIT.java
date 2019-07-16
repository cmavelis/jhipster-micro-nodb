package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.MicroNoDbApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the HelloResource REST controller.
 *
 * @see HelloResource
 */
@SpringBootTest(classes = MicroNoDbApp.class)
public class HelloResourceIT {

    private MockMvc restMockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        HelloResource helloResource = new HelloResource();
        restMockMvc = MockMvcBuilders
            .standaloneSetup(helloResource)
            .build();
    }

    /**
     * Test greet
     */
    @Test
    public void testGreet() throws Exception {
        restMockMvc.perform(get("/api/hello/greeting"))
            .andExpect(status().isOk());
    }
}
