package com.mors741.spittr.web;

import com.mors741.spittr.Spittle;
import com.mors741.spittr.data.SpittleRepository;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpittleControllerTest {

    @Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> spittleList = createSpittleList();

        SpittleRepository repository = mock(SpittleRepository.class);
        when(repository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(spittleList);

        SpittleController controller = new SpittleController(repository);

        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(
                        new InternalResourceView("/WEB-INF/views/spittles.jsp")
                ).build();

        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(spittleList.toArray())));
    }

    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> spittleList = createSpittleList();

        SpittleRepository repository = mock(SpittleRepository.class);
        when(repository.findSpittles(238900, 10)).thenReturn(spittleList);

        SpittleController controller = new SpittleController(repository);

        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(
                        new InternalResourceView("/WEB-INF/views/spittles.jsp")
                ).build();

        mockMvc.perform(get("/spittles?max=238900&count=10"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(spittleList.toArray())));
    }

    private List<Spittle> createSpittleList() {
        return Arrays.asList(
                new Spittle("Message1", new Date()),
                new Spittle("Message2", new Date()),
                new Spittle("Message3", new Date(), 12.34, 43.21),
                new Spittle("Message4", new Date(), 56.78, 87.65)
        );
    }

}