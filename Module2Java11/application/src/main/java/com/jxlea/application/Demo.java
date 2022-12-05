package com.jxlea.application;

import com.jxlea.application.exception.NoSubscriptionForCardException;
import com.jxlea.cloud.bank.CloudBank;
import com.jxlea.cloud.service.CloudService;
import com.jxlea.dto.bank.card.type.BankCardType;
import com.jxlea.dto.user.User;
import com.jxlea.service.Service;
import java.time.LocalDate;

import static java.lang.String.format;

public class Demo {

    //TODO write tests
    public static void main(String[] args) {
        var cloudBank = new CloudBank();
        var cloudService = new CloudService();

        var fowler = new User("Martin", "Fowler", LocalDate.of(1970, 12, 25));
        var fowlerDebit = cloudBank.createBankCard(fowler, BankCardType.CREDIT);
        var fowlerCredit = cloudBank.createBankCard(fowler, BankCardType.DEBIT);
        cloudService.subscribe(fowlerDebit);
        cloudService.subscribe(fowlerCredit);

        var fusco = new User("Mario", "Fusco", LocalDate.of(1998, 6, 12));
        var fuscoCredit = cloudBank.createBankCard(fusco, BankCardType.CREDIT);
        cloudService.subscribe(fuscoCredit);

        var microft = new User("Alan", "Microft", LocalDate.of(1988, 11, 19));
        var microftCredit = cloudBank.createBankCard(microft, BankCardType.CREDIT);
        cloudService.subscribe(microftCredit);

        var lee = new User("Jogh", "Lee", LocalDate.of(1999, 11, 8));
        var leeCredit = cloudBank.createBankCard(lee, BankCardType.CREDIT);
        var leeSecondCredit = cloudBank.createBankCard(lee, BankCardType.CREDIT);
        cloudService.subscribe(leeCredit);
        cloudService.subscribe(leeSecondCredit);

        var satie = new User("Erique", "Satie", LocalDate.of(1997, 5, 5));
        var satieCredit = cloudBank.createBankCard(satie, BankCardType.CREDIT);
        var satieDebit = cloudBank.createBankCard(satie, BankCardType.DEBIT);
        var satieSecondDebit = cloudBank.createBankCard(satie, BankCardType.DEBIT);
        cloudService.subscribe(satieCredit);
        cloudService.subscribe(satieDebit);
        cloudService.subscribe(satieSecondDebit);

        var pirs = new User("Alice", "Pirs", LocalDate.of(2000, 1, 17));
        var pitsDebit = cloudBank.createBankCard(pirs, BankCardType.DEBIT);
        cloudService.subscribe(pitsDebit);




        System.out.println("USERS------");
        cloudService.getAllUsers().forEach(System.out::println);

        System.out.println("CARDS------");
        cloudService.getAllCards().forEach(System.out::println);


        var card = cloudService.getAllCards().get(0).getNumber();

        var cardFount = cloudService.getSubscriptionByBankCardNumber(card)
                .orElseThrow(() -> new NoSubscriptionForCardException(format("No Subscription`s for card %s", card)));
        System.out.println("Card Found: " + cardFount);
        System.out.printf("Average user age is: %s + \n", cloudService.getAverageUsersAge());
        System.out.printf("User is payable? --%s + \n", Service.isPayableUser(fowler));

        var subscriptionByPredicate = cloudService.getAllSubscriptionByCondition(
                subscription -> subscription.bankCard().startsWith("4"));

        System.out.println(subscriptionByPredicate);
    }
}
