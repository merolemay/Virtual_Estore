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
        return loginService.login(loginDTO);
    }
}
