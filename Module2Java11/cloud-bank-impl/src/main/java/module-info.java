module cloud.bank.impl {
    requires lombok;
    requires dto;
    requires transitive bank.api;
    exports com.jxlea.cloud.bank to
            application;
}