package br.com.bruno.microservices.payment;

import static java.math.BigDecimal.TEN;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.bruno.microservices.payment.model.Payment;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentControllerTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void testPayment() throws Exception {
		webTestClient.post().uri("/payment")
	        .contentType(MediaType.APPLICATION_JSON_UTF8)
	        .accept(MediaType.APPLICATION_JSON_UTF8)
	        .body(Mono.just(new Payment("source", "destination", TEN)), Payment.class)
	        .exchange()
	        .expectStatus()
	        	.isCreated()
	        .expectBody()
	        	.jsonPath("$.paymentDate").isNotEmpty();
        
	}

}
