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
    public S save(D dto) {
        T entity = getEntityMapper().toEntity(dto);
        onCreateBeforeSave(dto, entity);
        return getEntityMapper().toSummaryDto(getRepository().save(entity));
    }

    @Override
    public void delete(ID id) {
        T t = getRepository().findById(id).orElse(null);
        if (t == null){
            return;
        }
        getRepository().delete(t);
    }

    @Override
    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }

    protected void onCreateBeforeSave(D dto, T entity) {}

    protected abstract CrudRepository<T, ID> getRepository();

    protected abstract EntityMapper<T, D, S> getEntityMapper();
}
