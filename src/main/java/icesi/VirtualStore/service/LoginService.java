package icesi.VirtualStore.service;


import icesi.VirtualStore.dto.LoginDTO;
import icesi.VirtualStore.dto.TokenDTO;

public interface LoginService {

    TokenDTO login(LoginDTO loginDTO);

}
