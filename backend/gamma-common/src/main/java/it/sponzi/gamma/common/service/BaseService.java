package it.sponzi.gamma.common.service;

import it.sponzi.gamma.common.dao.BaseDao;
import it.sponzi.gamma.common.dto.BaseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BaseService<T extends BaseDao, M extends BaseDto> {
    Mono<M> findById(Long id);

    Flux<M> findAll();

    Mono<M> create(M dtoToBeSaved);

    Mono<M> update(M dtoToBeSaved);

    Mono<Void> deleteById(Long id);

    Flux<M> findAll(String search);
}
