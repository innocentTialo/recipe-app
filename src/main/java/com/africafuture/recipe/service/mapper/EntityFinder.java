package com.africafuture.recipe.service.mapper;

import com.africafuture.recipe.domain.BaseEntity;
import com.africafuture.recipe.domain.Category;
import com.africafuture.recipe.domain.Ingredient;
import com.africafuture.recipe.domain.Note;
import com.africafuture.recipe.domain.Recipe;
import com.africafuture.recipe.domain.UnitOfMeasure;
import com.africafuture.recipe.exception.BaseEndPointException;
import com.africafuture.recipe.exception.CommonExceptionErrorKeys;
import com.africafuture.recipe.exception.EntityNotFoundException;
import com.africafuture.recipe.repository.CategoryRepository;
import com.africafuture.recipe.repository.IngredientRepository;
import com.africafuture.recipe.repository.NoteRepository;
import com.africafuture.recipe.repository.RecipeRepository;
import com.africafuture.recipe.repository.UnitOfMeasureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EntityFinder {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private NoteRepository noteRepository;


    /**
     * Find an entity by a given id and finding function
     *
     * @param lookupId          The id of the entity to find
     * @param lookupFn          The function to call for finding the entity using the id
     * @param exceptionSupplier a supplier of a EntityNotFoundException to throw in case of an non existing entity
     * @param <T>               The type of the entity to find
     * @param <X>               The type of the supplier of EntityNotFoundException
     * @return The entity found or null if the lookupId is null
     */
    protected <T, X extends Supplier<BaseEndPointException>> T unwrapOptional(Long lookupId, Function<Long, Optional<T>> lookupFn, X exceptionSupplier) {
        return Optional.ofNullable(lookupId) //
                .map(id -> lookupFn.apply(id).orElseThrow(exceptionSupplier)) //
                .orElse(null);// ;
    }

    protected <T, X extends Supplier<BaseEndPointException>> T unwrapOptional(Long lookupId, Function<Long, Optional<T>> lookupFn, X exceptionSupplier, Supplier<T> entitySupplier) {
        return Optional.ofNullable(lookupId) //
                .map(id -> lookupFn.apply(id).orElseThrow(exceptionSupplier)) //
                .orElse(entitySupplier.get());// ;
    }

    private <T> T unwrapOptional(Long lookupId, Function<Long, Optional<T>> lookupFn) {
        return Optional.ofNullable(lookupId) //
                .map(id -> lookupFn.apply(id).orElseThrow()) //
                .orElse(null);// ;
    }

    /**
     * Get the EntityNotFoundException for a given entity class and id
     *
     * @param entityClass The class of the entity to find
     * @param id          The id of the entity to find
     * @param <E>         The type of the entity to find
     * @return a Supplier of EntityNotFoundException
     */
    protected <E extends BaseEntity> Supplier<BaseEndPointException> getException(Class<E> entityClass, Long id) {
        return () -> new EntityNotFoundException(CommonExceptionErrorKeys.ENTITY_WITH_ID_NOT_FOUND, "No entity of type " + entityClass.getSimpleName() + " with id: " + id + " found", entityClass.getSimpleName(), id );
    }

    /**
     * Find the Set of entities corresponding to the set of Long taken as parameter using for each one the entityFinder
     *
     * @param ids
     * @param entityFinder
     * @param <E>
     * @return
     */
    public <E extends BaseEntity> Set<E> findByListOfIds(Set<Long> ids, Function<Long, E> entityFinder) {
        return Optional.ofNullable(ids)
                .orElse(Collections.emptySet())
                .stream()
                .map(entityFinder)
                .collect(Collectors.toSet());
    }

    public Category findCategoryById(Long id) {
        return unwrapOptional(id, categoryRepository::findById, getException(Category.class, id));
    }

    public Recipe findRecipeById(Long id) {
        return unwrapOptional(id, recipeRepository::findById, getException(Recipe.class, id));
    }

    public UnitOfMeasure findUnitOfMeasureById(Long id) {
        return unwrapOptional(id, unitOfMeasureRepository::findById, getException(UnitOfMeasure.class, id));
    }

    public Ingredient findIngredientById(Long id) {
        return unwrapOptional(id, ingredientRepository::findById, getException(Ingredient.class, id));
    }

    public Note findNoteById(Long id) {
        return unwrapOptional(id, noteRepository::findById, getException(Note.class, id));
    }

}
