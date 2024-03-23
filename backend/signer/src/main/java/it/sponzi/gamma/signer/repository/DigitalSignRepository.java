package it.sponzi.gamma.signer.repository;

import it.sponzi.gamma.common.repository.BaseRepository;
import it.sponzi.gamma.signer.dao.DigitalSign;
import org.springframework.stereotype.Repository;

@Repository
public interface DigitalSignRepository extends BaseRepository<DigitalSign> {

    DigitalSign findByUser(String name);
}
