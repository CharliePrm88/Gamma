package it.sponzi.gamma.pec.dto;

import it.sponzi.gamma.pec.dao.enumerated.UserRole;
import lombok.Data;

@Data
public class RoleDto {

    Long id;

    UserRole userRole;
}
