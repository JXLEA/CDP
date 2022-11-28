module cloud.service.impl {
    requires redis.clients.jedis;
    requires transitive service.api;
    requires dto;

    exports com.jxlea.cloud.service;
}