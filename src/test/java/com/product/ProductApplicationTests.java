package com.product;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.product.domain.Product;


@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ProductApplicationTests {

	@LocalServerPort
    int randomServerPort;


	
	Product p1=new Product(1L, "John Player", "T-Shirt", 1500, "Red", 42, "S1234", "JJ Collections");
	
	@Test
	public void testSaveProduct() throws URISyntaxException {
		RestTemplate restTemplate=new RestTemplate();
		final String baseUrl = "http://localhost:" + randomServerPort + "/products";
		URI uri = new URI(baseUrl);
		Product p1 = new Product(1L, "John Player", "T-Shirt", 1500, "Red", 42, "S1234", "JJ Collections");

		HttpHeaders headers = new HttpHeaders();

		HttpEntity<Product> request = new HttpEntity<>(p1, headers);

		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

		// Verify request succeed
		Assertions.assertEquals(201, result.getStatusCodeValue());
	}
	

	@Autowired
    private MockMvc mockMvc;
 
    @Test
    void getProductById() throws Exception {
        mockMvc.perform(get("/products/1L"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    
    @Test
    void getProductBySeller() throws Exception {
        mockMvc.perform(get("/products/seller/JJ Collections"))
                .andExpect(view().name("1"));
    }
		
}

	


