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

import java.time.Instant;
import java.util.Set;

@Table(name = "USERS")
@Entity(name = "Users")
@Data
public class Users implements BaseDao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "user_seq", sequenceName = "seq_user")
    protected Long id;

    protected String name;

    protected String surname;

    protected Instant bornDate;

    @JoinColumn(name = "role", referencedColumnName = "Id")
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Role.class, orphanRemoval = true, fetch = FetchType.LAZY)
    protected Set<Role> roles;

    @JoinColumn(name = "pecmail", referencedColumnName = "Id")
    @OneToMany(cascade = CascadeType.ALL, targetEntity = PecMail.class, orphanRemoval = true, fetch = FetchType.LAZY)
    protected Set<PecMail> pecMails;
}
