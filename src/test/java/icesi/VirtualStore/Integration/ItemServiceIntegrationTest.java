package icesi.VirtualStore.Integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = { "spring.datasource.url=jdbc:h2:mem:testdb" }
)
@ActiveProfiles("test")
public class ItemServiceIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    private ObjectMapper objectMapper;

    @BeforeEach
    private void init() {
        objectMapper = new ObjectMapper();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }



}
