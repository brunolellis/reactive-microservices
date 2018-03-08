package br.com.bruno.microservices.payment.rest;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.microservices.payment.model.Payment;

@RestController("/payment")
public class PaymentController {

	@PostMapping
	@ResponseStatus(CREATED)
	public Payment pay(@RequestBody Payment payment) {
		payment.pay();
		return payment;
	}
}