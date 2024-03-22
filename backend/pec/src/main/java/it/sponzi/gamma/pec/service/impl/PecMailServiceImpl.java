package it.sponzi.gamma.pec.service.impl;

import it.sponzi.gamma.common.service.BaseServiceImpl;
import it.sponzi.gamma.pec.dao.PecMail;
import it.sponzi.gamma.pec.dto.PecMailDto;
import it.sponzi.gamma.pec.repository.PecMailRepository;
import it.sponzi.gamma.pec.service.PecMailService;
import it.sponzi.gamma.pec.service.mapper.PecMailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PecMailServiceImpl extends BaseServiceImpl<PecMail, PecMailDto> implements PecMailService {

    @Autowired
    public PecMailServiceImpl(PecMailRepository repository, PecMailMapper mapper) {
        super(repository, mapper, PecMail.class);
    }

}
