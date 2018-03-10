package br.com.bruno.microservices.nonblocking;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class PaymentService {

	private static final String PAYMENT_URI = "/payment";
	
	private WebClient webClient;
	
	public PaymentService(WebClient webClient) {
		this.webClient = webClient;
	}

	public Mono<PaymentDTO> pay(PaymentDTO payment) {
		return webClient
			.post()
			.uri(PAYMENT_URI)
			.body(BodyInserters.fromObject(payment))
			.retrieve()
			.bodyToMono(PaymentDTO.class);
	}

}
