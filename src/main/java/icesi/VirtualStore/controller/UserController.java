package icesi.VirtualStore.controller;


import icesi.VirtualStore.api.UserAPI;
import icesi.VirtualStore.constant.VirtualStoreErrorCode;
import icesi.VirtualStore.dto.UserCreateDTO;
import icesi.VirtualStore.dto.UserDTO;
import icesi.VirtualStore.error.exception.VirtualStoreError;
import icesi.VirtualStore.error.exception.VirtualStoreException;
import icesi.VirtualStore.mapper.UserMapper;
import icesi.VirtualStore.service.UserService;
import icesi.VirtualStore.validation.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class UserController implements UserAPI {


    public final UserService userService;
    public final UserMapper userMapper;



    @Override
    public UserDTO getUser(UUID userId) {
        return userMapper.fromUser(userService.getUser(userId));
    }

    @Override
    public UserDTO createUser(@Valid UserCreateDTO userDTO) {

        validateMandatoryField(
                userMapper.fromDTO(userDTO).getEmail(),
                userMapper.fromDTO(userDTO).getPhoneNumber()
        );


        return userMapper.fromUser(userService.createUser(userMapper.fromDTO(userDTO), userDTO.getRoleName()));
    }

    @Override
    public List<UserDTO> getUsers() {
        return userService.getUsers().stream().map(userMapper::fromUser).collect(Collectors.toList());
    }

    private void validateMandatoryField(String email, String phoneNumber) {
        if (email == null && phoneNumber == null) {
            throw new VirtualStoreException(HttpStatus.BAD_REQUEST,new VirtualStoreError(VirtualStoreErrorCode.CODE_U_02, VirtualStoreErrorCode.CODE_U_02.getMessage()));
        }

        EmailValidator emailValidator = new EmailValidator();
        if (email != null&& !emailValidator.isValid(email,null)) {
            throw new VirtualStoreException(HttpStatus.BAD_REQUEST,new VirtualStoreError(VirtualStoreErrorCode.CODE_U_03, VirtualStoreErrorCode.CODE_U_03.getMessage()));
        }

        if (email != null&& !emailValidator.isValid(email,null)) {
            throw new VirtualStoreException(HttpStatus.BAD_REQUEST,new VirtualStoreError(VirtualStoreErrorCode.CODE_U_04, VirtualStoreErrorCode.CODE_U_04.getMessage()));
        }
    }

}
