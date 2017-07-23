package com.mors741.spittr.web;

import com.mors741.spittr.Spitter;
import com.mors741.spittr.data.SpitterRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

    @Test
    public void shouldProcessRegistration() throws Exception {
        Spitter spitter = new Spitter("John", "Snow", "bastard", "123");

        SpitterRepository repository = mock(SpitterRepository.class);
        when(repository.getByUsername("bastard")).thenReturn(spitter);

        SpitterController controller = new SpitterController(repository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/spitter/register")
                .param("firstName", "John")
                .param("lastName", "Snow")
                .param("username", "bastard")
                .param("password", "123"))
                .andExpect(redirectedUrl("/spitter/bastard"));

        verify(repository, atLeastOnce()).save(spitter);
    }

}