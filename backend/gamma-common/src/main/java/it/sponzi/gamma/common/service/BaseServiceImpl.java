package it.sponzi.gamma.common.service;

import it.sponzi.gamma.common.dao.BaseDao;
import it.sponzi.gamma.common.dto.BaseDto;
import it.sponzi.gamma.common.repository.BaseRepository;
import it.sponzi.gamma.common.service.filter.QueryService;
import it.sponzi.gamma.common.service.filter.SearchCriteria;
import it.sponzi.gamma.common.service.mapper.BaseMapper;
import it.sponzi.gamma.common.util.ReflectionUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseServiceImpl<T extends BaseDao, M extends BaseDto> implements BaseService<T, M> {

    protected final BaseMapper<T, M> mapper;
    protected final BaseRepository<T> repository;
    protected final Class<T> daoClazz;

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
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>|<=|>=|=)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        if (matcher.find()) {
            QueryService<T> query = new QueryService<>();
            SearchCriteria criteria = new SearchCriteria(matcher.group(1), matcher.group(3), matcher.group(2));
            T entity = ReflectionUtils.getInstanceOf(daoClazz);
            return repository.findAll(query.getCriteriaBySearchCriteria(entity, criteria)).map(mapper::toDto);
        } else {
            return repository.findAll().map(mapper::toDto);
        }
    }

}
