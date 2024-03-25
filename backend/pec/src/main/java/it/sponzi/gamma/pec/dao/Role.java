package it.sponzi.gamma.pec.dao;

import it.sponzi.gamma.pec.dao.enumerated.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "ROLE")
@Entity(name = "Role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "role_seq", sequenceName = "seq_role")
    Long id;

    @Enumerated(EnumType.STRING)
    UserRole userRole;
}
