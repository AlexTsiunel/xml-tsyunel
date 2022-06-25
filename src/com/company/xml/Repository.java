package com.company.xml;

import java.util.List;

public interface Repository<T> {
    T getById(Long id);

    List<T> getAll();
}
