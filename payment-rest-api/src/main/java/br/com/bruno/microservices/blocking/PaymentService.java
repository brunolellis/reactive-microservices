package br.com.bruno.microservices.blocking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

	@Value("${payment.api}")
	private String paymentApi;

	private final String paymentUri = "/payment";
	private RestTemplate restTemplate;

	public PaymentService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public PaymentDTO pay(PaymentDTO payment) {
		ResponseEntity<PaymentDTO> paymentResponse = restTemplate.postForEntity(paymentApi + paymentUri, payment, PaymentDTO.class);
		return paymentResponse.getBody();
	}

}
