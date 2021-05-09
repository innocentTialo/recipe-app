package com.africafuture.recipe.service.mapper;

import com.africafuture.recipe.domain.BaseEntity;
import com.africafuture.recipe.service.dto.EntityDto;
import com.africafuture.recipe.service.dto.EntitySummaryDto;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D> - Dto type parameter.
 * @param <E> - Entity type parameter.
 */
@Component
public interface EntityMapper<E extends BaseEntity, D extends EntityDto, S extends EntitySummaryDto> {

    E toEntity(D dto);

    @Named("toDto")
    D toDto(E entity);

    @Named("toSummary")
    S toSummaryDto(E entity);

}
