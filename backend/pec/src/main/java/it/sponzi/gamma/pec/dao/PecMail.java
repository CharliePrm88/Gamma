package it.sponzi.gamma.pec.dao;

import it.sponzi.gamma.common.dao.BaseDao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.NavigableSet;
import java.util.TreeSet;

@Table(name = "PECMAIL")
@Entity(name = "PecMail")
@Data
public class PecMail implements BaseDao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pecmail")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "pecmail_seq", sequenceName = "seq_pecmail")
    protected Long id;

    protected String name;

    protected NavigableSet<Pec> pecs;
}
