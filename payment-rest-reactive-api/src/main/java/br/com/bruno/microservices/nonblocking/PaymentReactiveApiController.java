package br.com.bruno.microservices.nonblocking;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController("/payment")
public class PaymentReactiveApiController {

	private PaymentService paymentService;

	public PaymentReactiveApiController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@PostMapping
	@ResponseStatus(CREATED)
	public Mono<PaymentDTO> pay(@RequestBody PaymentDTO payment) {
		return paymentService.pay(payment);
	}
}