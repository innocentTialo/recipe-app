package com.africafuture.recipe.service.dto;

import com.africafuture.recipe.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Positive;
import java.io.Serializable;

/**
 * Base DTO which is used for creating or editing an entity which inherits from {@link BaseEntity}.
 * Only DTO for classes which inherits from {@link BaseEntity} should extends this.
 */
@Getter
@Setter
public abstract class EntityDto implements Serializable {

	@Positive
	private Long id;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

    @JsonIgnore
    public boolean isNew() {
		return id == null;
    }

}
