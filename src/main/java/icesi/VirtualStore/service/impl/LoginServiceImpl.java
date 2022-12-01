package icesi.VirtualStore.service.impl;


import icesi.VirtualStore.dto.LoginDTO;
import icesi.VirtualStore.dto.TokenDTO;
import icesi.VirtualStore.model.User;
import icesi.VirtualStore.repository.UserRepository;
import icesi.VirtualStore.service.LoginService;
import icesi.VirtualStore.utils.JWTParser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    public final UserRepository userRepository;

    @Override
    public TokenDTO login(LoginDTO loginDTO, boolean isEmail) {

        User user = StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .filter(user1 -> user1.getEmail().equals(loginDTO.getUsername()))
                .findFirst()
                .orElseThrow();
        if(user.getPassword().equals(loginDTO.getPassword())) {
            Map<String, String> claims = new HashMap<>();
            claims.put("userId", user.getId().toString());
            return new TokenDTO(JWTParser.createJWT(user.getId().toString(),user.getEmail(), user.getEmail(), claims,100000L));
        }
        throw new InvalidParameterException();

    }

}
