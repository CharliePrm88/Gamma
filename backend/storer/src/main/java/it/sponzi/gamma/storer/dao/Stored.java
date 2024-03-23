package it.sponzi.gamma.storer.dao;

import it.sponzi.gamma.common.dao.BaseDao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "STORED")
@Entity(name = "Stored")
@Data
public class Stored implements BaseDao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_stored")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "stored_seq", sequenceName = "seq_stored")
    protected Long id;

    protected byte[] file;

}
