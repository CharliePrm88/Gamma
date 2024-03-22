package it.sponzi.gamma.common.repository;

import it.sponzi.gamma.common.dao.BaseDao;
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BaseRepository<T extends BaseDao> extends ReactiveCrudRepository<T, Long>, ReactiveQuerydslPredicateExecutor<T> {
}
