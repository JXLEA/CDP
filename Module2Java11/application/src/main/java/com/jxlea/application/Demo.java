package com.jxlea.application;

import com.jxlea.cloud.bank.CloudBank;
import com.jxlea.cloud.service.CloudService;
import com.jxlea.dto.bank.card.type.BankCardType;
import com.jxlea.dto.user.User;
import com.jxlea.service.Service;
import java.time.LocalDate;

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

        cloudService.getAllUsers().forEach(System.out::println);
        System.out.println("-------");
        cloudService.getAllCards().forEach(System.out::println);
        var card = cloudService.getAllCards().get(0);

        var cardFount = cloudService.getSubscriptionByBankCardNumber(card.getNumber()).orElseThrow();
        System.out.println("---" + cardFount);

        System.out.printf("Average user age is: %s", cloudService.getAverageUsersAge());
        System.out.println();
        System.out.printf("User is payable? --%s", Service.isPayableUser(fowler));
    }
}
