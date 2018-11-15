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

public class EmpresaControllerTests extends PontoApplicationTest{

    

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
    	DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }
    
    @Test
    public void criarEmpresaTest() throws Exception {
    	
    	MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/empresa/criar")
    											.contentType(MediaType.APPLICATION_JSON)
                     						    .content(createEmpresaInJson("empresteste","111111111111111","8"));
    										    this.mockMvc.perform(builder)
    										    .andExpect(MockMvcResultMatchers.status().isOk())
    										    .andDo(MockMvcResultHandlers.print());
    }
    
    @Test
    public void ListaEmpresasTest() throws Exception {


        mockMvc.perform(MockMvcRequestBuilders.get("/empresa/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().string("[{\"id\":1,\"nome\":\"empresteste\",\"cnpj\":111111111111111,\"regime\":8}]"));
    }
    
    @Test
    public void buscarEmpresasTest() throws Exception {


    	MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/empresa/busca")
    			.contentType(MediaType.APPLICATION_JSON)
    			.content("{" + "\"cnpj\":\"" + "111111111111111" + "\"}");
    			this.mockMvc.perform(builder)
    			.andExpect(MockMvcResultMatchers.status().isOk())
    			.andDo(MockMvcResultHandlers.print());
    }
    
    private static String createEmpresaInJson (String nome, String cnpj, String regime) {
        return "{ \"nome\": \"" + nome + "\", " +
                            "\"cnpj\":\"" + cnpj + "\"," +
                            "\"regime\":\"" + regime + "\"}";
    }
}
