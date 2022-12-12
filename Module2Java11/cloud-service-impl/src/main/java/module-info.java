module cloud.service.impl {
    requires redis.clients.jedis;
    requires transitive service.api;
    requires dto;

    provides com.jxlea.service.Service with com.jxlea.cloud.service.CloudService;
}