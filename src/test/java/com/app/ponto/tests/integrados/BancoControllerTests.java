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

public class BancoControllerTests extends PontoApplicationTest{

    

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
    	DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }
    
    @Test
    public void criarBancoTest() throws Exception {
    	
    	MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/Banco")
    											.contentType(MediaType.APPLICATION_JSON)
                     						    .content(createBancoInJson("1","1","100","50","50"));
    											System.out.println(createBancoInJson("1","1","100","50","50"));
    										    this.mockMvc.perform(builder)
    										    .andExpect(MockMvcResultMatchers.status().isOk())
    										    .andDo(MockMvcResultHandlers.print());
    }
    
    
    @Test
    public void buscarBancoTest() throws Exception {


    	MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/Banco/busca/{cpf}/{empresa}","1111111","222222");
    			this.mockMvc.perform(builder)
    			.andExpect(MockMvcResultMatchers.status().isOk())
    			.andDo(MockMvcResultHandlers.print());
    }
    
    private static String createBancoInJson (String iduser, String idempresa, String pos,String neg,String total) {
        return "{ \"user\": \"" + iduser + "\"," +
                 "\"empresa\":\"" + idempresa + "\"," +
                 "\"pos\":\"" + pos + "\"," +
                 "\"total\":\"" + total + "\"," +
                 "\"neg\":\"" + neg + "\"}";
    }
}
