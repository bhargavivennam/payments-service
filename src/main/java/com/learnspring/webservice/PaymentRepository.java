package com.learnspring.webservice;

import io.spring.guides.payments_web_service.CardType;
import io.spring.guides.payments_web_service.TransactionType;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentRepository {
    private static final Map<String, TransactionType> paymentDetails = new HashMap<>();

    @PostConstruct
    public void initData() {
        var transactionTypeOne = new TransactionType();
        transactionTypeOne.setPaymentType("credit");
        transactionTypeOne.setCardType(CardType.VISA);

        paymentDetails.put(transactionTypeOne.getPaymentType(), transactionTypeOne);

        var transactionTypeTwo = new TransactionType();
        transactionTypeTwo.setPaymentType("debit");
        transactionTypeTwo.setCardType(CardType.MASTER_CARD);

        paymentDetails.put(transactionTypeTwo.getPaymentType(), transactionTypeTwo);

        var transactionTypeThree = new TransactionType();
        transactionTypeThree.setPaymentType("upi");
        transactionTypeThree.setCardType(CardType.PHONE_PE);

        paymentDetails.put(transactionTypeThree.getPaymentType(), transactionTypeThree);

    }

    public TransactionType findTransaction(String transactionType) {
        Assert.notNull(transactionType, "The payment type must not be null");
        return paymentDetails.get(transactionType);
    }
}
