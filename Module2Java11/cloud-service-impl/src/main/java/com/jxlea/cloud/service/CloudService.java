package com.jxlea.cloud.service;

import com.jxlea.dto.bank.card.BankCard;
import com.jxlea.dto.subscription.Subscription;
import com.jxlea.dto.user.User;
import com.jxlea.service.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CloudService implements Service {

    private List<User> userStorage = new ArrayList<>();
    private List<Subscription> subscriptionStorage = new ArrayList<>();

    @Override
    public void subscribe(BankCard bankCard) {
        Objects.requireNonNull(bankCard);
        userStorage.add(bankCard.getUser());
        subscriptionStorage.add(new Subscription(bankCard.getNumber(), LocalDate.now()));
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) {
        return subscriptionStorage.stream()
                .filter(subscription -> subscription.bankCard().equals(cardNumber))
                .findAny();
    }

    @Override
    public List<User> getAllUsers() {
        return userStorage;
    }
}
