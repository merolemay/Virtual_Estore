package icesi.VirtualStore.Integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import icesi.VirtualStore.dto.OrderDTO;
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
public class OrderServiceIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    private ObjectMapper objectMapper;

    private static final String ORDER_UUID = "5631cbd3-cf53-415f-bd06-4e995ee3c322";

    @BeforeEach
    private void init() {
        objectMapper = new ObjectMapper();
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    @SneakyThrows
    public void getOrdersSuccessfully()  {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/orders/" + ORDER_UUID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        OrderDTO orderResult = objectMapper.readValue(result.getResponse().getContentAsString(), OrderDTO.class);

        assertThat(orderResult, hasProperty("status", is("CREATED")));
    }

    @Test
    @SneakyThrows
    public void createOrderSuccessfully()  {
        OrderDTO baseOrderDTO =  baseOrder();
        String body = objectMapper.writeValueAsString(baseOrderDTO);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)).andExpect(status().isOk())
                .andReturn();

        OrderDTO orderResult = objectMapper.readValue(result.getResponse().getContentAsString(), OrderDTO.class);
        assertThat(orderResult, hasProperty("firstName", is("Juan")));

    }

    @SneakyThrows
    private OrderDTO baseOrder(){
        String body = parseResourceToString("createOrder.json.json");
        return objectMapper.readValue(body, OrderDTO.class);
    }
    @SneakyThrows
    private String parseResourceToString(String classPath) {
        Resource resource = new ClassPathResource(classPath);
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        }
    }

}
