package com.jxlea.cloud.bank.factory;

import com.jxlea.dto.bank.card.BankCard;
import com.jxlea.dto.bank.card.impl.CreditBankCard;
import com.jxlea.dto.bank.card.impl.DebitBankCard;

public class CardFactory {

    public static BankCard createDebit() {
        return new DebitBankCard();
    }

    public static BankCard createCredit() {
        return new CreditBankCard();
    }
}
