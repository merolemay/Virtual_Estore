package icesi.VirtualStore.service;

import icesi.VirtualStore.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface UserService {


    public User getUser(@PathVariable UUID userId);

    public User createUser(@RequestBody User userDTO, UUID roleId);

    public List<User> getUsers();
}
