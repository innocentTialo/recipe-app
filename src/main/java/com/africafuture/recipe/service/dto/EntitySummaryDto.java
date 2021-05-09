package com.africafuture.recipe.service.dto;

import com.africafuture.recipe.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * Base DTO which is used to display details of entity in the UI.
 * Note that only fields needed for display should be represented here and that the intent is not to have a one to one representation of the entity.
 * Purpose of this is to avoid pulling the complete entity graph from the UI.
 * An entity summary can be extended only for classes which inherits from {@link BaseEntity}.
 */
@Getter
@Setter
public abstract class EntitySummaryDto implements Serializable {

    private Long id;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

}
