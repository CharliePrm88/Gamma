package it.sponzi.gamma.common.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.PathBuilder;
import it.sponzi.gamma.common.dao.BaseDao;
import it.sponzi.gamma.common.dto.BaseDto;
import it.sponzi.gamma.common.repository.BaseRepository;
import it.sponzi.gamma.common.service.filter.BasePredicateBuilder;
import it.sponzi.gamma.common.service.mapper.BaseMapper;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseServiceImpl<T extends BaseDao, M extends BaseDto> implements BaseService<T, M> {

    private final BaseMapper<T, M> mapper;
    private final BaseRepository<T> repository;

    private final Class<T> daoClazz;

    public BaseServiceImpl(BaseRepository<T> repository, BaseMapper<T, M> mapper, Class<T> daoClazz) {
        this.repository = repository;
        this.mapper = mapper;
        this.daoClazz = daoClazz;
    }

    @Override
    public Mono<M> findById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Override
    public Flux<M> findAll() {
        return repository.findAll().map(mapper::toDto);
    }

    @Override
    public Mono<M> create(M dtoToBeSaved) {
        Mono<T> daoCreated = repository.save(mapper.toDao(dtoToBeSaved));
        return daoCreated.map(mapper::toDto);
    }

    @Override
    public Mono<M> update(M dtoToBeSaved) {
        return create(dtoToBeSaved);
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return repository.deleteById(id);
    }

    @Override
    public Flux<M> findAll(String search) {
        BasePredicateBuilder<T> builder = new BasePredicateBuilder<>();
        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>|<=|>=|=)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                builder.with(matcher.group(1), matcher.group(3), matcher.group(2));
            }
        }
        BooleanExpression exp = builder.build(new PathBuilder<>(daoClazz, "base"));
        return repository.findAll(exp).map(mapper::toDto);
    }

}
