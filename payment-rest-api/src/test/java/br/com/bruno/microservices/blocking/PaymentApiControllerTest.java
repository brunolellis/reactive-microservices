package br.com.bruno.microservices.blocking;

import static java.math.BigDecimal.ONE;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(PaymentApiController.class)
public class PaymentApiControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PaymentService paymentService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void testPayment() throws Exception {
		PaymentDTO paymentOkDTO = new PaymentDTO("f", "t", ONE);
		paymentOkDTO.setPaymentDate(new Date());

		given(paymentService.pay(any(PaymentDTO.class))).willReturn(paymentOkDTO);

		String paymentJson = objectMapper.writeValueAsString(new PaymentDTO("t", "f", ONE));

		this.mvc.perform(post("/payment").content(paymentJson).contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isCreated())
				.andExpect(content().string(containsString("paymentDate")));
	}

}
