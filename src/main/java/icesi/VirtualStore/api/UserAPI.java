package icesi.VirtualStore.api;

import icesi.VirtualStore.dto.UserCreateDTO;
import icesi.VirtualStore.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/users")
public interface UserAPI {

    @GetMapping("/{userId}")
    UserDTO getUser(@PathVariable UUID userId);

    @PostMapping()
    UserDTO createUser(@RequestBody UserCreateDTO userDTO);

    @GetMapping
    List<UserDTO> getUsers();

}
