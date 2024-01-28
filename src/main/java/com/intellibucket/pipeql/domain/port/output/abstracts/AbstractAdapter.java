package com.intellibucket.pipeql.domain.port.output.abstracts;

import com.intellibucket.pipeql.dao.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AbstractAdapter <ID,E>{
    Optional<E> findById(ID id) throws DataNotFoundException;
    List<E> findAll();
    List<E> findAllById(List<ID> ids);
    E save(E entity);
    void deleteById(ID id);
    void deleteAll();
}
