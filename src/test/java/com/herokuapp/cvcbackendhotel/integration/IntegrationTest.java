package com.herokuapp.cvcbackendhotel.integration;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.herokuapp.cvcbackendhotel.CvcBackendHotelApplication;

/**
 * @author Marcos Pinho
 */
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = CvcBackendHotelApplication.class
)
@AutoConfigureMockMvc
public class IntegrationTest {
}