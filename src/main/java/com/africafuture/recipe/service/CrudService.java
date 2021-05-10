package com.africafuture.recipe.service;

import com.africafuture.recipe.service.dto.EntityDto;
import com.africafuture.recipe.service.dto.EntitySummaryDto;

import java.util.Set;

public interface CrudService<T, D extends EntityDto, S extends EntitySummaryDto, ID> {

    Set<S> findAll();

    S findById(ID id);

    S save(D dto);

    void delete(ID id);

    void deleteById(ID id);

}
