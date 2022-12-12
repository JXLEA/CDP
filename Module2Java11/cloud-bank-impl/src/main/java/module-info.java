module cloud.bank.impl {
    requires lombok;
    requires transitive dto;
    requires transitive bank.api;

    provides com.jxlea.bank.Bank with com.jxlea.cloud.bank.CloudBank;
}