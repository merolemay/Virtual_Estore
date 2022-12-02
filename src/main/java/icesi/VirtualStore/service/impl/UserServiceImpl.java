package icesi.VirtualStore.service.impl;


import icesi.VirtualStore.constant.VirtualStoreErrorCode;
import icesi.VirtualStore.error.exception.VirtualStoreError;
import icesi.VirtualStore.error.exception.VirtualStoreException;
import icesi.VirtualStore.model.Permission;
import icesi.VirtualStore.model.Role;
import icesi.VirtualStore.model.User;
import icesi.VirtualStore.repository.PermissionRepository;
import icesi.VirtualStore.repository.RoleRepository;
import icesi.VirtualStore.repository.UserRepository;
import icesi.VirtualStore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;

    public final RoleRepository roleRepository;

    public final PermissionRepository permissionRepository;

    @Override
    public User getUser(UUID userId) {
        return userRepository.findById(userId).orElseThrow(()-> new VirtualStoreException(HttpStatus.NOT_FOUND, new VirtualStoreError(VirtualStoreErrorCode.CODE_U_01, VirtualStoreErrorCode.CODE_U_01.getMessage())));
    }

    @Override
    public User createUser(User userDTO, String roleName) {
        Role role = roleRepository.findByName(roleName).orElseThrow(()-> new VirtualStoreException(HttpStatus.NOT_FOUND, new VirtualStoreError(VirtualStoreErrorCode.CODE_L_04, VirtualStoreErrorCode.CODE_L_04.getMessage())));
        userDTO.setRole(role);
        List<Permission> permissions = StreamSupport.stream(permissionRepository.findAll().spliterator(), false).collect(Collectors.toList());
        return userRepository.save(userDTO);
    }

    @Override
    public List<User> getUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
