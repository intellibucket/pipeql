package com.intellibucket.pipeql.domain.port.output.abstracts;

import java.util.List;

public interface AbstractAdapter <ID,E>{
    E findById(ID id);
    List<E> findAll();
    List<E> findAllById(List<ID> ids);
    E save(E entity);
    void deleteById(ID id);
    void deleteAll();
}
