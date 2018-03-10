package br.com.bruno.microservices.nonblocking;

import static java.math.BigDecimal.ONE;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentApiControllerTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void testPayment() throws Exception {
		webTestClient.post().uri("/payment")
	        .contentType(MediaType.APPLICATION_JSON_UTF8)
	        .accept(MediaType.APPLICATION_JSON_UTF8)
	        .body(Mono.just(new PaymentDTO("t", "f", ONE)), PaymentDTO.class)
	        .exchange()
	        .expectStatus()
	        	.isCreated()
	        .expectBody()
	        	.jsonPath("$.paymentDate").isNotEmpty();
        
	}

}
