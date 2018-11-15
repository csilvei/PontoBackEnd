package com.app.ponto.tests.integrados;

import com.app.ponto.controllers.EmpresaController;
import com.app.ponto.tests.PontoApplicationTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

public class CargoControllerTests extends PontoApplicationTest{

    

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
    	DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }
    
    @Test
    public void criarCargoTest() throws Exception {
    	BigDecimal sal = new BigDecimal("500.22");
    	MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/cargo")
    											.contentType(MediaType.APPLICATION_JSON)
                     						    .content(createCargoInJson("chefe",1,sal));
    										    System.out.println(createCargoInJson("chefe",1,sal));
    										    this.mockMvc.perform(builder)
    										    .andExpect(MockMvcResultMatchers.status().isOk())
    										    .andDo(MockMvcResultHandlers.print());
    }
    
    @Test
    public void ListaCargoTest() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders.get("/cargo/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().string("[{\"id\":1,\"nome\":\"chefe\",\"empresa\":1,\"val\":500.00}]"));
    }
    
    @Test
    public void buscarCargoTest() throws Exception {


    	MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/cargo/busca")
    			.contentType(MediaType.APPLICATION_JSON)
    			.content("{" + "\"id\":\"" + "1" + "\"}");
    			this.mockMvc.perform(builder)
    			.andExpect(MockMvcResultMatchers.status().isOk())
    			.andDo(MockMvcResultHandlers.print());
    }
    
    private static String createCargoInJson (String nome, long emp, BigDecimal val) {
        return "{ \"nome\": \"" + nome + "\", " +
                            "\"empresa\":\"" + emp + "\"," +
                            "\"valor\":\"" + val + "\"}";
    }
}
