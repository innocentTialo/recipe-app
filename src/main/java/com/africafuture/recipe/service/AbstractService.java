package com.africafuture.recipe.service;


import com.africafuture.recipe.domain.BaseEntity;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {
    @Override
    public Set<T> findAll() {
        Iterable<T> all = getRepository().findAll();
        Set<T> response = new HashSet<>();
        all.iterator().forEachRemaining(response::add);
        return response;
    }

    @Override
    public T findById(ID id) {
        return getRepository().findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public T save(T object) {
        onCreateBeforeSave(object);
        return getRepository().save(object);
    }

    @Override
    public void delete(T object) {
        getRepository().delete(object);
    }

    @Override
    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }

    protected void onCreateBeforeSave(T t) {}

    protected abstract CrudRepository<T, ID> getRepository();
}
