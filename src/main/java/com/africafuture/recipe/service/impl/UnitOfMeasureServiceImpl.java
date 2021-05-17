package com.africafuture.recipe.service.impl;

import com.africafuture.recipe.domain.UnitOfMeasure;
import com.africafuture.recipe.repository.UnitOfMeasureRepository;
import com.africafuture.recipe.service.AbstractService;
import com.africafuture.recipe.service.dto.UnitOfMeasureDto;
import com.africafuture.recipe.service.dto.UnitOfMeasureSummaryDto;
import com.africafuture.recipe.service.mapper.EntityMapper;
import com.africafuture.recipe.service.mapper.UnitOfMeasureMapper;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UnitOfMeasureServiceImpl extends AbstractService<UnitOfMeasure, UnitOfMeasureDto, UnitOfMeasureSummaryDto> {

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    private final UnitOfMeasureMapper unitOfMeasureMapper;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository, UnitOfMeasureMapper unitOfMeasureMapper) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureMapper = unitOfMeasureMapper;
    }

    @Override
    protected CrudRepository<UnitOfMeasure, Long> getRepository() {
        return unitOfMeasureRepository;
    }

    @Override
    protected EntityMapper<UnitOfMeasure, UnitOfMeasureDto, UnitOfMeasureSummaryDto> getEntityMapper() {
        return unitOfMeasureMapper;
    }
}
