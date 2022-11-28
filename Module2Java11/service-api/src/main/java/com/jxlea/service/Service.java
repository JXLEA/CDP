package com.jxlea.service;

import com.jxlea.dto.bank.card.BankCard;
import com.jxlea.dto.subscription.Subscription;
import com.jxlea.dto.user.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public interface Service {

    default double getAverageUsersAge() {
        return getAllUsers().stream()
                .map(User::birthday)
                .mapToLong(date -> ChronoUnit.YEARS.between(date, LocalDate.now()))
                .average()
                .orElseThrow();
    }

    static boolean isPayableUser(User user) {
        var dateOfBirthday = user.birthday();
        return ChronoUnit.YEARS.between(dateOfBirthday, LocalDate.now()) > 18;
    }

    void subscribe(BankCard bankCard);

    Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber);

    List<User> getAllUsers();

    List<BankCard> getAllCards();
}
