package it.sponzi.gamma.common.repository;

import it.sponzi.gamma.common.dao.BaseDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseRepository<T extends BaseDao> extends JpaRepository<T, Long> {
}
