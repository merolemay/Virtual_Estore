package icesi.VirtualStore.controller;

import icesi.VirtualStore.api.LoginAPI;
import icesi.VirtualStore.constant.VirtualStoreErrorCode;
import icesi.VirtualStore.dto.LoginDTO;
import icesi.VirtualStore.dto.TokenDTO;
import icesi.VirtualStore.error.exception.VirtualStoreError;
import icesi.VirtualStore.error.exception.VirtualStoreException;
import icesi.VirtualStore.service.LoginService;
import icesi.VirtualStore.validation.EmailValidator;
import icesi.VirtualStore.validation.PhoneNumberValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class LoginController implements LoginAPI {

    private final LoginService loginService;


    @CrossOrigin(origins = "*")
    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        String s = loginDTO.getUsername();
        EmailValidator emailValidator = new EmailValidator();
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
        if (emailValidator.isValid(s, null))
            return loginService.loginByEmail(loginDTO);
        if (phoneNumberValidator.isValid(s, null))
            return loginService.loginByPhoneNumber(loginDTO);

        throw new VirtualStoreException(HttpStatus.BAD_REQUEST, new VirtualStoreError(VirtualStoreErrorCode.CODE_L_01, VirtualStoreErrorCode.CODE_L_01.getMessage()));
    }

}