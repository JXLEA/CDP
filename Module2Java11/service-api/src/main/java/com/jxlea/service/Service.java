package com.jxlea.service;

import com.jxlea.dto.bank.card.BankCard;
import com.jxlea.dto.subscription.Subscription;
import com.jxlea.dto.user.User;

import java.util.List;
import java.util.Optional;

public interface Service {

    void subscribe(BankCard bankCard);

    Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);

    List<User> getAllUsers();

    List<BankCard> getAllCards();
}
