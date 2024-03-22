package it.sponzi.gamma.pec.dao;

import it.sponzi.gamma.pec.dao.enumerated.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "ROLE")
@Entity(name = "Role")
@Data
public class Role {

    @Id
    Long id;

    @Enumerated(EnumType.STRING)
    UserRole userRole;
}
