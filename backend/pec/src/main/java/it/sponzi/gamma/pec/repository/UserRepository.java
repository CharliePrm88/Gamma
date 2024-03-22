package it.sponzi.gamma.pec.repository;

import it.sponzi.gamma.common.repository.BaseRepository;
import it.sponzi.gamma.pec.dao.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {
}
