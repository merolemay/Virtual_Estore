package icesi.VirtualStore.mapper;

import icesi.VirtualStore.dto.RoleDTO;
import icesi.VirtualStore.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role fromDTO(RoleDTO roleDTO);

    RoleDTO fromRole(Role role);

}
