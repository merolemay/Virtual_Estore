package icesi.VirtualStore.Integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import icesi.VirtualStore.dto.ItemTypeDTO;
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

    @Test
    @SneakyThrows
    public void createItemSuccessfully() {
        ItemTypeDTO itemTypeDTO = createItemDTO();
        String body = objectMapper.writeValueAsString(itemTypeDTO);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isCreated())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        ItemTypeDTO responseDTO = objectMapper.readValue(response, ItemTypeDTO.class);
        assertThat(responseDTO, hasProperty("name", is(itemTypeDTO.getName())));
    }

    @Test
    @SneakyThrows
    public void createItemWithInvalidName() {
        ItemTypeDTO itemTypeDTO = createItemDTO();
        itemTypeDTO.setName("a");
        String body = objectMapper.writeValueAsString(itemTypeDTO);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isBadRequest())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        assertThat(response, is("Name must be between 2 and 50 characters"));
    }

    @Test
    @SneakyThrows
    public void createItemWithInvalidDescription() {
        ItemTypeDTO itemTypeDTO = createItemDTO();
        itemTypeDTO.setDescription("a");
        String body = objectMapper.writeValueAsString(itemTypeDTO);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isBadRequest())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        assertThat(response, is("Description must be between 2 and 50 characters"));
    }

    @Test
    @SneakyThrows
    public void updateItemSuccessfully() {
        ItemTypeDTO itemTypeDTO = createItemDTO();
        String body = objectMapper.writeValueAsString(itemTypeDTO);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isCreated())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        ItemTypeDTO responseDTO = objectMapper.readValue(response, ItemTypeDTO.class);
        assertThat(responseDTO, hasProperty("name", is(itemTypeDTO.getName())));
        itemTypeDTO.setName("New Name");
        body = objectMapper.writeValueAsString(itemTypeDTO);
        result = mockMvc.perform(MockMvcRequestBuilders.put("/items/" + responseDTO.getItemTypeId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk())
                .andReturn();
        response = result.getResponse().getContentAsString();
        responseDTO = objectMapper.readValue(response, ItemTypeDTO.class);
        assertThat(responseDTO, hasProperty("name", is(itemTypeDTO.getName())));
    }

    @Test
    @SneakyThrows
    public void addItemToCartSuccessfully() {
        ItemTypeDTO itemTypeDTO = createItemDTO();
        String body = objectMapper.writeValueAsString(itemTypeDTO);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isCreated())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        ItemTypeDTO responseDTO = objectMapper.readValue(response, ItemTypeDTO.class);
        assertThat(responseDTO, hasProperty("name", is(itemTypeDTO.getName())));
        result = mockMvc.perform(MockMvcRequestBuilders.post("/items/" + responseDTO.getItemTypeId() + "/cart")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isOk())
                .andReturn();
        response = result.getResponse().getContentAsString();
        responseDTO = objectMapper.readValue(response, ItemTypeDTO.class);
        assertThat(responseDTO, hasProperty("name", is(itemTypeDTO.getName())));
    }

    @Test
    @SneakyThrows
    public void createItemWithInvalidPrice() {
        ItemTypeDTO itemTypeDTO = createItemDTO();
        itemTypeDTO.setPrice(-1);
        String body = objectMapper.writeValueAsString(itemTypeDTO);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isBadRequest())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        assertThat(response, is("Price must be greater than 0"));
    }

    @Test
    @SneakyThrows
    public void getItemSuccessfully() {
        ItemTypeDTO itemTypeDTO = createItemDTO();
        String body = objectMapper.writeValueAsString(itemTypeDTO);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isCreated())
                .andReturn();
        String response = result.getResponse().getContentAsString();
        ItemTypeDTO responseDTO = objectMapper.readValue(response, ItemTypeDTO.class);
        MvcResult getResult = mockMvc.perform(MockMvcRequestBuilders.get("/items/" + responseDTO.getItemTypeId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        String getResponse = getResult.getResponse().getContentAsString();
        ItemTypeDTO getResponseDTO = objectMapper.readValue(getResponse, ItemTypeDTO.class);
        assertThat(getResponseDTO, hasProperty("name", is(itemTypeDTO.getName())));
    }

    @SneakyThrows
    private ItemTypeDTO createItemDTO() {
    String body = parseResourceToString("JsonFiles/createItem.json");
    return objectMapper.readValue(body, ItemTypeDTO.class);
    }
    @SneakyThrows
    private String parseResourceToString(String classPath) {
        Resource resource = new ClassPathResource(classPath);
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        }
    }

}
