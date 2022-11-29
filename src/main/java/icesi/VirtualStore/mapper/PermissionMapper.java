package icesi.VirtualStore.mapper;


import icesi.VirtualStore.dto.PermissionDTO;
import icesi.VirtualStore.model.Permission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    Permission fromDTO(PermissionDTO permissionDTO);

    PermissionDTO fromPermission(Permission permission);

    List<Permission> fromListDTO(List<PermissionDTO> permissionDTOList);

    List<PermissionDTO> fromListPermission(List<Permission> permissionList);

}
