package icesi.VirtualStore.controller;

import icesi.VirtualStore.api.LoginAPI;
import icesi.VirtualStore.dto.LoginDTO;
import icesi.VirtualStore.dto.TokenDTO;
import icesi.VirtualStore.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class LoginController implements LoginAPI {

    private final LoginService loginService;

    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        if (validateEmail(loginDTO.getUsername()))
            return loginService.login(loginDTO, true);
        if (validatePhoneNumber(loginDTO.getUsername()))
            return loginService.login(loginDTO, false);

        throw new RuntimeException();
    }

    private boolean validatePhoneNumber(String username) {
        String regex = "^\\+[1-9][1-9][\\s\\S]*";
        return username.matches(regex);
    }

    private boolean validateEmail(String username) {
        String regex = "[A-Za-z\\d]+@[A-Za-z\\d]+\\.[A-Za-z]+(.[A-Za-z]+)?";
        return username.matches(regex);
    }
}
