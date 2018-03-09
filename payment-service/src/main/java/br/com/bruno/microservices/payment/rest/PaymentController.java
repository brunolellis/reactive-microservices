package br.com.bruno.microservices.payment.rest;

import static org.springframework.http.HttpStatus.CREATED;

import java.time.Duration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.microservices.payment.model.Payment;
import reactor.core.publisher.Mono;

@RestController("/payment")
public class PaymentController {

	@PostMapping
	@ResponseStatus(CREATED)
	public Mono<Payment> pay(@RequestBody Mono<Payment> payment) {
		return payment
			.delayElement(Duration.ofMillis(200)) // mock blocking action
			.map(Payment::pay);
	}
}