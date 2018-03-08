package br.com.bruno.microservices.blocking;

import static org.springframework.http.HttpStatus.CREATED;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/payment")
public class PaymentApiController {

	private PaymentService paymentService;

	public PaymentApiController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@PostMapping
	@ResponseStatus(CREATED)
	public PaymentDTO pay(@RequestBody PaymentDTO payment) {
		return paymentService.pay(payment);
	}
	
	@GetMapping
	public PaymentDTO test() {
		PaymentDTO payment = new PaymentDTO("from", "to", BigDecimal.ONE);
		return paymentService.pay(payment);
	}
}