package com.africafuture.recipe.service.mapper;

import com.africafuture.recipe.domain.UnitOfMeasure;
import com.africafuture.recipe.service.dto.UnitOfMeasureDto;
import com.africafuture.recipe.service.dto.UnitOfMeasureSummaryDto;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {
        UnitOfMeasureMapper.UnitOfMeasureFactory.class})
public abstract class UnitOfMeasureMapper implements EntityMapper<UnitOfMeasure, UnitOfMeasureDto, UnitOfMeasureSummaryDto> {

    @Autowired
    EntityFinder entityFinder;

    @Component
    class UnitOfMeasureFactory {

        public UnitOfMeasure fromDto(UnitOfMeasureDto dto) {
            if (dto.getId() != null) {
                return entityFinder.findUnitOfMeasureById(dto.getId());
            }

            return new UnitOfMeasure();
        }

    }
}
