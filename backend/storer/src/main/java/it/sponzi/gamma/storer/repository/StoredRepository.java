package it.sponzi.gamma.storer.repository;

import it.sponzi.gamma.common.repository.BaseRepository;
import it.sponzi.gamma.storer.dao.StoredData;
import org.springframework.stereotype.Repository;

@Repository
public interface StoredRepository extends BaseRepository<StoredData> {
}
