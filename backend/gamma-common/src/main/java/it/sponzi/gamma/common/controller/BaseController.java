package it.sponzi.gamma.common.controller;

import it.sponzi.gamma.common.dao.BaseDao;
import it.sponzi.gamma.common.dto.BaseDto;
import it.sponzi.gamma.common.service.BaseService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BaseController<S extends BaseService<T, M>, T extends BaseDao, M extends BaseDto> implements BaseApi<M> {

    protected S service;

    public BaseController(S service) {
        this.service = service;
    }

    @Override
    @GetMapping(value = Urls.FIND_BY_ID, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<M> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @Override
    @GetMapping(value = Urls.FIND_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<M> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping(value = Urls.FIND_ALL + "{search}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<M> findAll(@PathVariable String search) {
        return service.findAll(search);
    }

    @Override
    @PostMapping(value = Urls.CREATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<M> create(@RequestBody M dtoToBeSaved) {
        return service.create(dtoToBeSaved);
    }

    @Override
    @PutMapping(value = Urls.UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<M> update(@RequestBody M dtoToBeSaved) {
        return service.update(dtoToBeSaved);
    }

    @Override
    @DeleteMapping(value = Urls.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Void> deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }
}
