package it.sponzi.gamma.storer.service.impl;

import it.sponzi.gamma.common.service.BaseServiceImpl;
import it.sponzi.gamma.storer.dao.Stored;
import it.sponzi.gamma.storer.dto.StoredDto;
import it.sponzi.gamma.storer.repository.StoredRepository;
import it.sponzi.gamma.storer.service.StoredService;
import it.sponzi.gamma.storer.service.mapper.StoredMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoredServiceImpl extends BaseServiceImpl<Stored, StoredDto> implements StoredService {
    @Autowired
    public StoredServiceImpl(StoredRepository repository, StoredMapper mapper) {
        super(repository, mapper, Stored.class);
    }
}
