package br.com.bruno.microservices.blocking;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PaymentApiConfig {

	@Value("${payment.api}")
	private String paymentApi;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplateBuilder()
				.rootUri(paymentApi)
				.build();
	}
}
