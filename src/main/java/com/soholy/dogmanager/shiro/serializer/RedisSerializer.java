package com.soholy.dogmanager.shiro.serializer;

import com.soholy.dogmanager.shiro.exception.SerializationException;

public interface RedisSerializer<T> {

    byte[] serialize(T t) throws SerializationException;

    T deserialize(byte[] bytes) throws SerializationException;
}
