package com.jxlea.data.source;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDataSource implements DataSource{

    private JedisPool pool;

    public RedisDataSource() {
        init();
    }

    @Override
    public void init() {
        pool = new JedisPool("localhost", 6379);
    }

    public Jedis connect() {
        return pool.getResource();
    }

    public void close() {
        pool.getResource().close();
    }
}
