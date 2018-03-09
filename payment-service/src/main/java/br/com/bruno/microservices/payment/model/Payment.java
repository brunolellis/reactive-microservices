package br.com.bruno.microservices.payment.model;

import java.math.BigDecimal;
import java.util.Date;

public class Payment {

	private String from;
	private String to;
	private BigDecimal amount;
	private Date paymentDate;

	protected Payment() {}
	
	public Payment(String from, String to, BigDecimal amount) {
		super();
		this.from = from;
		this.to = to;
		this.amount = amount;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public Payment pay() {
		paymentDate = new Date();
		return this;
	}

	@Override
	public String toString() {
		return "Payment [from=" + from + ", to=" + to + ", amount=" + amount + ", paymentDate=" + paymentDate + "]";
	}

}