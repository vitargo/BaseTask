package com.github.gui.crud.repository.impl;

import com.github.gui.crud.entity.Person;
import com.github.gui.crud.repository.IPeopleRepo;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PeopleRedisRepo implements IPeopleRepo {

    private static final String KEY = "person";
    private final RedissonClient client;

    public PeopleRedisRepo(RedissonClient client) {
        this.client = client;
    }

    @Override
    public Person save(Person p) {
        RMap<String, Person> map = client.getMap(KEY);
        return map.put(String.valueOf(p.getId()), p);
    }

    @Override
    public List<Person> findAll() {
        RMap<String, Person> map = client.getMap(KEY);
        return map.values().stream()
                .sorted(Comparator.comparingLong(Person::getId))
                .collect(Collectors.toList());
    }

    @Override
    public void update(long id, Person p) {
        RMap<String, Person> map = client.getMap(KEY);
        map.put(String.valueOf(id), p);
    }

    @Override
    public void remove(long id) {
        RMap<String, Person> map = client.getMap(KEY);
        map.remove(String.valueOf(id));
    }
}
