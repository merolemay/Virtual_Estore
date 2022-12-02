package icesi.VirtualStore.Integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import icesi.VirtualStore.dto.LoginDTO;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.context.WebApplicationContext;

import java.io.InputStreamReader;
import java.io.Reader;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = { "spring.datasource.url=jdbc:postgresql://localhost:49153/test" }
)
@ActiveProfiles("test")
public class LoginServiceIntegrationTest {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext wac;

    @BeforeEach
    private void init() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    @SneakyThrows
    public void testLogin() {
        LoginDTO loginDTO = baseLogin();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(loginDTO)))
                .andExpect(status().isOk())
                .andReturn();
        LoginDTO loginResponse = objectMapper.readValue(result.getResponse().getContentAsString(), LoginDTO.class);
        assertThat(loginResponse,hasProperty("pasword",is("askhda123")));
    }

    @SneakyThrows
    private LoginDTO baseLogin() {
    String json = parseResourceToString("JsonFiles/login.json");
    return objectMapper.readValue(json, LoginDTO.class);
    }
    @SneakyThrows
    private String parseResourceToString(String classPath) {
        Resource resource = new ClassPathResource(classPath);
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        }
    }
}
