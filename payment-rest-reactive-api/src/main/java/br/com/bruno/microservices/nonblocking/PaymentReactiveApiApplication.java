package br.com.bruno.microservices.nonblocking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentReactiveApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentReactiveApiApplication.class, args);
	}
}
