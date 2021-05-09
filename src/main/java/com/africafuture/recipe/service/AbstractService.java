package com.africafuture.recipe.service;


import com.africafuture.recipe.domain.BaseEntity;
import com.africafuture.recipe.service.dto.EntityDto;
import com.africafuture.recipe.service.dto.EntitySummaryDto;
import com.africafuture.recipe.service.mapper.EntityMapper;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractService<T extends BaseEntity, D extends EntityDto, S extends EntitySummaryDto, ID extends Long> implements CrudService<T, D, S, ID> {
    @Override
    public Set<S> findAll() {
        Iterable<T> all = getRepository().findAll();
        Set<S> response = new HashSet<>();
        all.iterator().forEachRemaining(t -> response.add(getEntityMapper().toSummaryDto(t)));
        return response;
    }

    @Override
    public S findById(ID id) {
        return getEntityMapper().toSummaryDto(getRepository().findById(id).orElseThrow(EntityNotFoundException::new));
    }

    @Override
    public S save(T object) {
        onCreateBeforeSave(object);
        return getEntityMapper().toSummaryDto(getRepository().save(object));
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

    protected abstract EntityMapper<T, D, S> getEntityMapper();
}
