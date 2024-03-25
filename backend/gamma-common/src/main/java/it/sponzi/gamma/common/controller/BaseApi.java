package it.sponzi.gamma.common.controller;

import io.swagger.v3.oas.annotations.Operation;
import it.sponzi.gamma.common.dto.BaseDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BaseApi<M extends BaseDto> {

    @Operation(summary = "", operationId = "findById", description = "Find an element by Id")
    Mono<M> findById(@NotNull Long id);

    @Operation(summary = "", operationId = "findAll", description = "Find All")
    Flux<M> findAll();

    @Operation(summary = "", operationId = "findAll", description = "Find All by CSV Search String")
    Flux<M> findAll(String search);

    @Operation(summary = "", operationId = "create", description = "Create an element")
    Mono<M> create(@NotNull @Valid M dtoToBeSaved);

    @Operation(summary = "", operationId = "update", description = "Update an element")
    Mono<M> update(@NotNull @Valid M dtoToBeSaved);

    @Operation(summary = "", operationId = "deleteById", description = "Delete an element by Id")
    Mono<Void> deleteById(@NotNull Long id);

}
