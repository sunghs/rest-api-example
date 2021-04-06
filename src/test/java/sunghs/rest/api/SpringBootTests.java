package sunghs.rest.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestConstructor.AutowireMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sunghs.rest.api.model.UserInfo;
import sunghs.rest.api.service.UserService;

@AutoConfigureMockMvc
@TestConstructor(autowireMode = AutowireMode.ALL)
@SpringBootTest
@RequiredArgsConstructor
public class SpringBootTests {

    private final UserService userService;

    private final MockMvc mockMvc;

    private final ObjectMapper objectMapper;

    @Test
    @WithMockUser
    public void getTest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user/get/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN)
            .characterEncoding(StandardCharsets.UTF_8.displayName());

        MockHttpServletResponse response = mockMvc.perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();
    }

    @Test
    @WithMockUser
    public void postTest() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("sunghs");
        userInfo.setUserPassword("qwert12345!@#$");
        userInfo.setUserAddress1("earth");

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/set")
            .content(objectMapper.writeValueAsString(userInfo))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN)
            .characterEncoding(StandardCharsets.UTF_8.displayName());

        mockMvc.perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.content().string(HttpStatus.OK.toString()))
            .andReturn()
            .getResponse();
    }

    @Test
    public void injectionTest() {
        userService.get("test");
    }
}
