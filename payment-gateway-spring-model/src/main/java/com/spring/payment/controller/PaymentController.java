package com.spring.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.payment.model.ChargeRequest;
import com.spring.payment.model.ChargeRequest.Currency;
import com.spring.payment.service.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;

@Controller
public class PaymentController {

	@Autowired
	PaymentService service;

    @Value("${STRIPE_PUBLIC_KEY}")
    private String stripePublicKey;

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("amount", 50 * 100); // in cents
        model.addAttribute("stripePublicKey", stripePublicKey);
        model.addAttribute("currency", ChargeRequest.Currency.EUR);
        return "checkout";
    }

	@PostMapping("/charge")
	public String charge(ChargeRequest chargeRequest, Model model) throws StripeException {
		chargeRequest.setDescription("Example charge");
		chargeRequest.setCurrency(Currency.EUR);
		Charge charge = service.charge(chargeRequest);
		model.addAttribute("id", charge.getId());
		model.addAttribute("status", charge.getStatus());
		model.addAttribute("chargeId", charge.getId());
		model.addAttribute("balance_transaction", charge.getBalanceTransaction());
		return "result";
	}

	@ExceptionHandler(StripeException.class)
	public String handleError(Model model, StripeException ex) {
		model.addAttribute("error", ex.getMessage());
		return "result";
	}

}
