package com.yz.sophia.stargaze.controller;

import com.alibaba.fastjson.TypeReference;
import com.yz.sophia.bsf.redis.RedisProvider;
import com.yz.sophia.bsf.redis.annotation.RedisCache;
import com.yz.sophia.stargaze.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Huang Zhaoping
 * @date 2019/6/20
 */
public class RedisController {

    @Autowired
    private RedisProvider redisProvider;

    @GetMapping("/get")
    public String get(String key) {
        return redisProvider.get(key);
    }

    @GetMapping("/set")
    public void set(String key, String value, int timeout) {
        redisProvider.set(key, value, timeout);
    }

    @GetMapping("/call")
    @RedisCache(timeout = 60)
    public String call() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    @GetMapping("/callVoid")
    @RedisCache(timeout = 60)
    public void callVoid() {
        System.out.println("call");
    }

    @GetMapping("/callList")
    @RedisCache(timeout = 60)
    public List<String> callList() {
        return Arrays.asList("1", "2", String.valueOf(Math.random()));
    }

    @GetMapping("/callArray")
    @RedisCache(timeout = 60)
    public String[] callArray(int length) {
        System.out.println("call");
        if (length != 10) {
            throw new IllegalArgumentException("length != 10");
        }
        return new String[length];
    }

    @GetMapping("/callComplex")
    @RedisCache(key = "'user-'+#userId", timeout = 60)
    public User callComplex(long userId) {
        return new User(userId, "hello: " + System.currentTimeMillis(), Arrays.asList(new User.Job(userId + "001", "haha")));
    }

    @GetMapping("/callComplexList")
    @RedisCache(key = "'list-user-'+#userId", timeout = 60)
    public List<User> callComplexList(long userId) {
        return Arrays.asList(new User(userId, "hello: " + System.currentTimeMillis(), Arrays.asList(new User.Job(userId + "001", "haha"))));
    }

    @GetMapping("/callComplexMap")
    @RedisCache(key = "'map-user-'+#userId", timeout = 60)
    public Map<Integer, User> callComplexMap(long userId) {
        Map<Integer, User> values = new HashMap<>();
        values.put((int) userId, new User(userId, "hello: " + userId, Arrays.asList(new User.Job(userId + "001", "haha"))));
        return values;
    }

    @GetMapping("/callback")
    public List<User> callback(long userId) {
        List<User> list = redisProvider.cache("user-" + userId, 60, () -> Arrays.asList(new User(userId, "hello: " + userId, Arrays.asList(new User.Job(userId + "001", "haha")))), new TypeReference<List<User>>() {
        }.getType());
        System.out.println(list);
        return list;
    }

    @GetMapping("/callbackMap")
    public Map<Integer, User> callbackMap(long userId) {
        Map<Integer, User> map = redisProvider.cache("user-" + userId, 60, () -> {
            Map<Integer, User> values = new HashMap<>();
            values.put((int) userId, new User(userId, "hello: " + userId, Arrays.asList(new User.Job(userId + "001", "haha"))));
            return values;
        }, new TypeReference<Map<Integer, User>>() {
        }.getType());
        return map;
    }

}
