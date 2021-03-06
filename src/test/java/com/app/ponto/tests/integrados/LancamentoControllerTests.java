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

public class LancamentoControllerTests extends PontoApplicationTest{

    

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
    	DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }
    
    @Test
    public void criarLancTest() throws Exception {
    	
    	MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/lancamento")
    											.contentType(MediaType.APPLICATION_JSON)
                     						    .content(createLancInJson("1","1","01","11","2018","8.2","1.2"));
    											System.out.println(createLancInJson("1","1","01","11","2018","8.2","1.2"));
    										    this.mockMvc.perform(builder)
    										    .andExpect(MockMvcResultMatchers.status().isOk())
    										    .andDo(MockMvcResultHandlers.print());
    }
    
    
    @Test
    public void buscarLancTest() throws Exception {
    	
    	

    	MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/lancamento/busca/{cod}/{emp}/{dia}/{mes}/{ano}","1","1","3","10","2018");
    			this.mockMvc.perform(builder)
    			.andExpect(MockMvcResultMatchers.status().isOk())
    			.andDo(MockMvcResultHandlers.print());
    }
    
    @Test
    public void buscarLancEspecificoTest() throws Exception {
    	
    	MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/lancamento")
				.contentType(MediaType.APPLICATION_JSON)
				    .content(createLancInJson("1","1","01","11","2018","8.2","1.2"));
				System.out.println(createLancInJson("1","1","01","11","2018","8.2","1.2"));
			    this.mockMvc.perform(builder)
			    .andExpect(MockMvcResultMatchers.status().isOk())
			    .andDo(MockMvcResultHandlers.print());

    	builder = MockMvcRequestBuilders.get("/lancamento/all/{cod}/{emp}","1","1");
    			this.mockMvc.perform(builder)
    			.andExpect(MockMvcResultMatchers.status().isOk())
    			.andDo(MockMvcResultHandlers.print());
    }
    
    private static String createLancInJson (String iduser, String idempresa, String dia, String mes, String ano,String horaspos,String horasneg) {
        return "{" + "\"empresa\":\"" + idempresa + "\","
        		   + "\"empregado\":\"" + iduser + "\"," 
        		   + "\"dia\":\"" + dia + "\"," +
        		   "\"mes\":\"" + mes  + "\"," +
        		   "\"ano\":\"" + ano  + "\"," +
        		   	 "\"neg\":\"" + horasneg  + "\"," +
                     "\"pos\":\"" + horaspos +  "\"}";
    }
}
