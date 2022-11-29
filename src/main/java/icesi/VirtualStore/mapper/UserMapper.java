package icesi.VirtualStore.mapper;

import icesi.VirtualStore.dto.UserCreateDTO;
import icesi.VirtualStore.dto.UserDTO;
import icesi.VirtualStore.model.User;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromDTO(UserDTO userDTO);

    UserDTO fromUser(User user);

    User fromDTO(UserCreateDTO userCreateDTO);

    default String fromUUID(UUID uuid) {
        return uuid.toString();
    }

    default UUID fromUUID(String uuid) {
        return UUID.fromString(uuid);
    }
}
