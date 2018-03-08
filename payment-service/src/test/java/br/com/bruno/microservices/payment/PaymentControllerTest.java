package br.com.bruno.microservices.payment;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

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

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bruno.microservices.payment.model.Payment;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentControllerTest {

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private ObjectMapper objectMapper;

	private MockMvc mvc;

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testPayment() throws Exception {
		
		String paymentJson = objectMapper.writeValueAsString(new Payment("source", "destination", BigDecimal.TEN));
		
		this.mvc.perform(post("/payment").content(paymentJson).contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isCreated())
			.andExpect(content().string(containsString("paymentDate")));
	}

}
