package com.uxpsystems.assignment;

import com.uxpsystems.assignment.dao.UserDocument;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class MainControllerTest extends AbstractWebIntegrationTest {

    @Test
    public void request_to_get_user() throws Exception {

        mvc.perform(get("/assignment/user/123456")).
                andDo(MockMvcResultHandlers.print()).
                andExpect(status().isOk());
    }

    @Test
    public void request_to_post_user() throws Exception {

        mvc.perform(post("/assignment/user")
                .accept(MediaType.APPLICATION_JSON).content(createDocument())
                .contentType(MediaType.APPLICATION_JSON)).
                andDo(MockMvcResultHandlers.print()).
                andExpect(status().isOk());
    }

    @Test
    public void request_to_put_user() throws Exception {

        mvc.perform(put("/assignment/user")
                .accept(MediaType.APPLICATION_JSON).content(createDocument())
                .contentType(MediaType.APPLICATION_JSON)).
                andDo(MockMvcResultHandlers.print()).
                andExpect(status().isOk());
    }

    @Test
    public void request_to_delete_user() throws Exception {

        mvc.perform(delete("/assignment/user/123456")).
                andDo(MockMvcResultHandlers.print()).
                andExpect(status().isOk());
    }

    private String createDocument() {
        return "{ \"id\": 123456, \"username\": \"username\", \"password\": \"pwd\", \"status\":\"Activated\" }";
    }
}
