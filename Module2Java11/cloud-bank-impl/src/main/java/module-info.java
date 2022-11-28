module cloud.bank.impl {
    requires lombok;
    requires transitive dto;
    requires transitive bank.api;

    exports com.jxlea.cloud.bank;
}