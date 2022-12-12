
module application {
    requires cloud.bank.impl;
    requires cloud.service.impl;
    requires dto;

    uses com.jxlea.service.Service;
    uses com.jxlea.bank.Bank;
}