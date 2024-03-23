package it.sponzi.gamma.common.repository;

import it.sponzi.gamma.common.dao.BaseDao;
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BaseRepository<T extends BaseDao> extends R2dbcRepository<T, Long> {
}
