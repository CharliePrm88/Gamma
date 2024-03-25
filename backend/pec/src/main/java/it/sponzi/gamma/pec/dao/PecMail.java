package it.sponzi.gamma.pec.dao;

import it.sponzi.gamma.common.dao.BaseDao;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Table(name = "PEC_MAIL")
@Entity(name = "PecMail")
@Data
public class PecMail implements BaseDao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pecmail")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "pecmail_seq", sequenceName = "seq_pecmail")
    protected Long id;

    protected String name;

    @JoinColumn(name = "pec", referencedColumnName = "Id")
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Pec.class, orphanRemoval = true, fetch = FetchType.LAZY)
    protected Set<Pec> pecs;
}
