package com.learnspring.webservice;

import io.spring.guides.payments_web_service.GetPaymentRequest;
import io.spring.guides.payments_web_service.GetPaymentResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PaymentEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/payments-web-service";

    private final PaymentRepository paymentRepository;

    // Constructor Dependency Injection
    public PaymentEndpoint(PaymentRepository paymentsRepository) {
        this.paymentRepository = paymentsRepository;
    }

    /**
     * <code>PayloadRoot</code> annotation is then used by Spring WS to pick the handler method, based on the message’s namespace and localPart.
     * <code>RequestPayload</code> annotation indicates that the incoming message will be mapped to the method’s request parameter
     * <code>ResponsePayload</code> annotation makes Spring WS map the returned value to the response payload
     * @param request payload for fetching the payments
     * @return payment details
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaymentRequest")
    @ResponsePayload
    public GetPaymentResponse getPayment(@RequestPayload GetPaymentRequest request) {
        var response = new GetPaymentResponse();
        response.setTransaction(paymentRepository.findTransaction(request.getTransactionType()));

        return response;
    }
}
