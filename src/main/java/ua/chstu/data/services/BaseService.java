package ua.chstu.data.services;

import java.util.List;

public interface BaseService {

    List<?> all();
    <T> void save(T t);
}
