package br.com.bruno.microservices.blocking;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

	private final String paymentUri = "/payment";
	private RestTemplate restTemplate;

	public PaymentService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public PaymentDTO pay(PaymentDTO payment) {
		ResponseEntity<PaymentDTO> paymentResponse = restTemplate.postForEntity(paymentUri, payment, PaymentDTO.class);
		return paymentResponse.getBody();
	}

}
