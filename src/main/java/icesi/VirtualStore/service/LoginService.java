package icesi.VirtualStore.service;


import icesi.VirtualStore.dto.LoginDTO;
import icesi.VirtualStore.dto.TokenDTO;

public interface LoginService {

    TokenDTO loginByEmail(LoginDTO loginDTO);

    TokenDTO loginByPhoneNumber(LoginDTO loginDTO);

}
