/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.SpringBootStripeCheckout.Controller;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author rv
 */
@Controller
public class MyController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/checkout")
    public String checkout(@RequestBody String payload) {
        System.out.println("Payload is ");
        System.out.println(payload);
        return "success";
    }

    @PostMapping("/chargePayment")
    @ResponseBody
    public String chargePayment(@RequestBody String payload) throws StripeException {
        System.out.println("payload is ");
        System.out.println(payload.substring(0, payload.length() - 1));
        Stripe.apiKey = "sk_test_laQ9qaADYUrP1uLDb1EP56rK";

// Token is created using Checkout or Elements!
// Get the payment token ID submitted by the form:
        Map<String, Object> params = new HashMap<>();
        params.put("amount", 3000);
        params.put("currency", "usd");
        params.put("description", "Example charge");
        params.put("source", payload.substring(0, payload.length() - 1));
        Charge charge = Charge.create(params);
        System.out.println("Charge is");
        System.out.println(charge);
        return "succees";
    }
}
