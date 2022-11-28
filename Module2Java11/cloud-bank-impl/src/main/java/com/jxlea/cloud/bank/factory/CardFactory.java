package com.jxlea.cloud.bank.factory;

import com.jxlea.dto.bank.card.BankCard;
import com.jxlea.dto.bank.card.impl.CreditBankCard;
import com.jxlea.dto.bank.card.impl.DebitBankCard;
import com.jxlea.dto.user.User;

public class CardFactory {

    public static BankCard createDebit(User user) {
        return new DebitBankCard(user);
    }

    public static BankCard createCredit(User user) {
        return new CreditBankCard(user);
    }
}
