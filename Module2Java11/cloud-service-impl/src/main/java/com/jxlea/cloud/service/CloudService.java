package com.jxlea.cloud.service;

import com.jxlea.dto.bank.card.BankCard;
import com.jxlea.dto.subscription.Subscription;
import com.jxlea.dto.user.User;
import com.jxlea.service.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class CloudService implements Service {

    //TODO REPLACE ON REDIS
    private Map<BankCard, Subscription> bankCardToSubscription = new HashMap<>();

    @Override
    public List<Subscription> getAllSubscriptionByCondition(Predicate<Subscription> condition) {
        return bankCardToSubscription.values().stream().filter(condition).toList();
    }

    @Override
    public void subscribe(BankCard bankCard) {
        Objects.requireNonNull(bankCard);
        bankCardToSubscription.put(bankCard, new Subscription(bankCard.getNumber(), LocalDate.now()));
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) {
        Objects.requireNonNull(cardNumber);
        return bankCardToSubscription.values().stream()
                .filter(subscription -> subscription.bankCard().equals(cardNumber))
                .findAny();
    }

    @Override
    public List<User> getAllUsers() {
        return bankCardToSubscription.keySet().stream()
                .map(BankCard::getUser)
                .toList();
    }

    @Override
    public List<BankCard> getAllCards() {
        return bankCardToSubscription.keySet().stream().toList();
    }
}
