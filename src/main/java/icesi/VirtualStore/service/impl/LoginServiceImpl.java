package icesi.VirtualStore.service.impl;


import icesi.VirtualStore.constant.VirtualStoreErrorCode;
import icesi.VirtualStore.dto.LoginDTO;
import icesi.VirtualStore.dto.TokenDTO;
import icesi.VirtualStore.error.exception.VirtualStoreError;
import icesi.VirtualStore.error.exception.VirtualStoreException;
import icesi.VirtualStore.model.Permission;
import icesi.VirtualStore.model.Role;
import icesi.VirtualStore.model.User;
import icesi.VirtualStore.repository.RoleRepository;
import icesi.VirtualStore.repository.UserRepository;
import icesi.VirtualStore.service.LoginService;
import icesi.VirtualStore.utils.JWTParser;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    public final UserRepository userRepository;

    public final RoleRepository roleRepository;

    @Override
    public TokenDTO loginByEmail(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getUsername()).orElseThrow(()->new VirtualStoreException(HttpStatus.NOT_FOUND, new VirtualStoreError(VirtualStoreErrorCode.CODE_U_01, VirtualStoreErrorCode.CODE_U_01.getMessage())));
        validatePassword(user.getPassword(), loginDTO.getPassword());
        return createTokenDTO(user);
    }

    @Override
    public TokenDTO loginByPhoneNumber(LoginDTO loginDTO) {
        User user = userRepository.findByPhoneNumber(loginDTO.getUsername()).orElseThrow(()->new VirtualStoreException(HttpStatus.NOT_FOUND, new VirtualStoreError(VirtualStoreErrorCode.CODE_U_01, VirtualStoreErrorCode.CODE_U_01.getMessage())));
        validatePassword(user.getPassword(), loginDTO.getPassword());
        return createTokenDTO(user);
    }

    @Override
    public List<Permission> getPermissionsByRoleId(UUID roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow(()->new VirtualStoreException(HttpStatus.NOT_FOUND, new VirtualStoreError(VirtualStoreErrorCode.CODE_L_04, VirtualStoreErrorCode.CODE_L_04.getMessage())));
        return role.getRolePermissions();
    }

    private TokenDTO createTokenDTO(User user) {
        Map<String, String> claims = new HashMap<>();
        claims.put("userId", user.getUserId().toString());
        claims.put("roleId", user.getRole().getRoleId().toString());
        return new TokenDTO(JWTParser.createJWT(user.getUserId().toString(), user.getEmail(), user.getEmail(), claims, 10000000L), user.getRole().getName(), user.getUserId().toString());
    }

    private void validatePassword(String userPassword, String loginDTOPassword) {
        if (!userPassword.equals(loginDTOPassword))
            throw new VirtualStoreException(HttpStatus.BAD_REQUEST, new VirtualStoreError(VirtualStoreErrorCode.CODE_L_02, VirtualStoreErrorCode.CODE_L_02.getMessage()));
    }

}
