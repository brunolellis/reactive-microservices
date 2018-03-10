package br.com.bruno.microservices.nonblocking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class PaymentReactiveApiConfig {

	@Value("${payment.api}")
	private String paymentApi;
	
	@Bean("paymentClient")
	public WebClient paymentClient() {
		return WebClient.builder().baseUrl(paymentApi).build();
	}
}
