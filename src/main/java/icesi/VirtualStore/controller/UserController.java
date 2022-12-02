package icesi.VirtualStore.controller;


import icesi.VirtualStore.api.UserAPI;
import icesi.VirtualStore.dto.UserCreateDTO;
import icesi.VirtualStore.dto.UserDTO;
import icesi.VirtualStore.mapper.UserMapper;
import icesi.VirtualStore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor

public class UserController implements UserAPI {


    public final UserService userService;
    public final UserMapper userMapper;



    @Override
    public UserDTO getUser(UUID userId) {
        return userMapper.fromUser(userService.getUser(userId));
    }


    @CrossOrigin(origins = "*")
    @Override
    public UserDTO createUser(@Valid UserCreateDTO userDTO) {
        return userMapper.fromUser(userService.createUser(userMapper.fromDTO(userDTO), userDTO.getRoleName()));
    }

    @Override
    public List<UserDTO> getUsers() {
        return userService.getUsers().stream().map(userMapper::fromUser).collect(Collectors.toList());
    }

}
