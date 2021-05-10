package com.africafuture.recipe.service.mapper;

import com.africafuture.recipe.domain.Note;
import com.africafuture.recipe.service.dto.NoteDto;
import com.africafuture.recipe.service.dto.NoteSummaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {
        NoteMapper.NoteFactory.class})
public abstract class NoteMapper implements EntityMapper<Note, NoteDto, NoteSummaryDto> {

    @Autowired
    EntityFinder entityFinder;

    @Component
    class NoteFactory {
        @ObjectFactory
        public Note fromDto(NoteDto dto) {
            if (dto.getId() != null) {
                return entityFinder.findNoteById(dto.getId());
            }

            return new Note();
        }

    }
}
