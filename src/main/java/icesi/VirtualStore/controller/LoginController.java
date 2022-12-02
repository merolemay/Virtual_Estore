package icesi.VirtualStore.controller;

import icesi.VirtualStore.api.LoginAPI;
import icesi.VirtualStore.dto.LoginDTO;
import icesi.VirtualStore.dto.TokenDTO;
import icesi.VirtualStore.service.LoginService;
import icesi.VirtualStore.validation.EmailValidator;
import icesi.VirtualStore.validation.PhoneNumberValidator;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class LoginController implements LoginAPI {

    private final LoginService loginService;

    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        String s = loginDTO.getUsername();
        EmailValidator emailValidator = new EmailValidator();
        PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidator();
        if (emailValidator.isValid(s, null))
            return loginService.login(loginDTO, true);
        if (phoneNumberValidator.isValid(s, null))
            return loginService.login(loginDTO, false);

        throw new RuntimeException();
    }

}