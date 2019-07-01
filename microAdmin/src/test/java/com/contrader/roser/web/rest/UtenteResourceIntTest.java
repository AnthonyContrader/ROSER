package com.contrader.roser.web.rest;

import com.contrader.roser.MicroAdminApp;

import com.contrader.roser.domain.Utente;
import com.contrader.roser.repository.UtenteRepository;
import com.contrader.roser.service.UtenteService;
import com.contrader.roser.service.dto.UtenteDTO;
import com.contrader.roser.service.mapper.UtenteMapper;
import com.contrader.roser.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static com.contrader.roser.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the UtenteResource REST controller.
 *
 * @see UtenteResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MicroAdminApp.class)
public class UtenteResourceIntTest {

    private static final String DEFAULT_NOME = "AAAAAAAAAA";
    private static final String UPDATED_NOME = "BBBBBBBBBB";

    private static final String DEFAULT_CONGOME = "AAAAAAAAAA";
    private static final String UPDATED_CONGOME = "BBBBBBBBBB";

    private static final String DEFAULT_USER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_USER_NAME = "BBBBBBBBBB";

    @Autowired
    private UtenteRepository utenteRepository;


    @Autowired
    private UtenteMapper utenteMapper;
    

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restUtenteMockMvc;

    private Utente utente;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final UtenteResource utenteResource = new UtenteResource(utenteService);
        this.restUtenteMockMvc = MockMvcBuilders.standaloneSetup(utenteResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Utente createEntity(EntityManager em) {
        Utente utente = new Utente()
            .nome(DEFAULT_NOME)
            .congome(DEFAULT_CONGOME)
            .userName(DEFAULT_USER_NAME);
        return utente;
    }

    @Before
    public void initTest() {
        utente = createEntity(em);
    }

    @Test
    @Transactional
    public void createUtente() throws Exception {
        int databaseSizeBeforeCreate = utenteRepository.findAll().size();

        // Create the Utente
        UtenteDTO utenteDTO = utenteMapper.toDto(utente);
        restUtenteMockMvc.perform(post("/api/utentes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(utenteDTO)))
            .andExpect(status().isCreated());

        // Validate the Utente in the database
        List<Utente> utenteList = utenteRepository.findAll();
        assertThat(utenteList).hasSize(databaseSizeBeforeCreate + 1);
        Utente testUtente = utenteList.get(utenteList.size() - 1);
        assertThat(testUtente.getNome()).isEqualTo(DEFAULT_NOME);
        assertThat(testUtente.getCongome()).isEqualTo(DEFAULT_CONGOME);
        assertThat(testUtente.getUserName()).isEqualTo(DEFAULT_USER_NAME);
    }

    @Test
    @Transactional
    public void createUtenteWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = utenteRepository.findAll().size();

        // Create the Utente with an existing ID
        utente.setId(1L);
        UtenteDTO utenteDTO = utenteMapper.toDto(utente);

        // An entity with an existing ID cannot be created, so this API call must fail
        restUtenteMockMvc.perform(post("/api/utentes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(utenteDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Utente in the database
        List<Utente> utenteList = utenteRepository.findAll();
        assertThat(utenteList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkNomeIsRequired() throws Exception {
        int databaseSizeBeforeTest = utenteRepository.findAll().size();
        // set the field null
        utente.setNome(null);

        // Create the Utente, which fails.
        UtenteDTO utenteDTO = utenteMapper.toDto(utente);

        restUtenteMockMvc.perform(post("/api/utentes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(utenteDTO)))
            .andExpect(status().isBadRequest());

        List<Utente> utenteList = utenteRepository.findAll();
        assertThat(utenteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkCongomeIsRequired() throws Exception {
        int databaseSizeBeforeTest = utenteRepository.findAll().size();
        // set the field null
        utente.setCongome(null);

        // Create the Utente, which fails.
        UtenteDTO utenteDTO = utenteMapper.toDto(utente);

        restUtenteMockMvc.perform(post("/api/utentes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(utenteDTO)))
            .andExpect(status().isBadRequest());

        List<Utente> utenteList = utenteRepository.findAll();
        assertThat(utenteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkUserNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = utenteRepository.findAll().size();
        // set the field null
        utente.setUserName(null);

        // Create the Utente, which fails.
        UtenteDTO utenteDTO = utenteMapper.toDto(utente);

        restUtenteMockMvc.perform(post("/api/utentes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(utenteDTO)))
            .andExpect(status().isBadRequest());

        List<Utente> utenteList = utenteRepository.findAll();
        assertThat(utenteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllUtentes() throws Exception {
        // Initialize the database
        utenteRepository.saveAndFlush(utente);

        // Get all the utenteList
        restUtenteMockMvc.perform(get("/api/utentes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(utente.getId().intValue())))
            .andExpect(jsonPath("$.[*].nome").value(hasItem(DEFAULT_NOME.toString())))
            .andExpect(jsonPath("$.[*].congome").value(hasItem(DEFAULT_CONGOME.toString())))
            .andExpect(jsonPath("$.[*].userName").value(hasItem(DEFAULT_USER_NAME.toString())));
    }
    

    @Test
    @Transactional
    public void getUtente() throws Exception {
        // Initialize the database
        utenteRepository.saveAndFlush(utente);

        // Get the utente
        restUtenteMockMvc.perform(get("/api/utentes/{id}", utente.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(utente.getId().intValue()))
            .andExpect(jsonPath("$.nome").value(DEFAULT_NOME.toString()))
            .andExpect(jsonPath("$.congome").value(DEFAULT_CONGOME.toString()))
            .andExpect(jsonPath("$.userName").value(DEFAULT_USER_NAME.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingUtente() throws Exception {
        // Get the utente
        restUtenteMockMvc.perform(get("/api/utentes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateUtente() throws Exception {
        // Initialize the database
        utenteRepository.saveAndFlush(utente);

        int databaseSizeBeforeUpdate = utenteRepository.findAll().size();

        // Update the utente
        Utente updatedUtente = utenteRepository.findById(utente.getId()).get();
        // Disconnect from session so that the updates on updatedUtente are not directly saved in db
        em.detach(updatedUtente);
        updatedUtente
            .nome(UPDATED_NOME)
            .congome(UPDATED_CONGOME)
            .userName(UPDATED_USER_NAME);
        UtenteDTO utenteDTO = utenteMapper.toDto(updatedUtente);

        restUtenteMockMvc.perform(put("/api/utentes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(utenteDTO)))
            .andExpect(status().isOk());

        // Validate the Utente in the database
        List<Utente> utenteList = utenteRepository.findAll();
        assertThat(utenteList).hasSize(databaseSizeBeforeUpdate);
        Utente testUtente = utenteList.get(utenteList.size() - 1);
        assertThat(testUtente.getNome()).isEqualTo(UPDATED_NOME);
        assertThat(testUtente.getCongome()).isEqualTo(UPDATED_CONGOME);
        assertThat(testUtente.getUserName()).isEqualTo(UPDATED_USER_NAME);
    }

    @Test
    @Transactional
    public void updateNonExistingUtente() throws Exception {
        int databaseSizeBeforeUpdate = utenteRepository.findAll().size();

        // Create the Utente
        UtenteDTO utenteDTO = utenteMapper.toDto(utente);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restUtenteMockMvc.perform(put("/api/utentes")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(utenteDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Utente in the database
        List<Utente> utenteList = utenteRepository.findAll();
        assertThat(utenteList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteUtente() throws Exception {
        // Initialize the database
        utenteRepository.saveAndFlush(utente);

        int databaseSizeBeforeDelete = utenteRepository.findAll().size();

        // Get the utente
        restUtenteMockMvc.perform(delete("/api/utentes/{id}", utente.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Utente> utenteList = utenteRepository.findAll();
        assertThat(utenteList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Utente.class);
        Utente utente1 = new Utente();
        utente1.setId(1L);
        Utente utente2 = new Utente();
        utente2.setId(utente1.getId());
        assertThat(utente1).isEqualTo(utente2);
        utente2.setId(2L);
        assertThat(utente1).isNotEqualTo(utente2);
        utente1.setId(null);
        assertThat(utente1).isNotEqualTo(utente2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(UtenteDTO.class);
        UtenteDTO utenteDTO1 = new UtenteDTO();
        utenteDTO1.setId(1L);
        UtenteDTO utenteDTO2 = new UtenteDTO();
        assertThat(utenteDTO1).isNotEqualTo(utenteDTO2);
        utenteDTO2.setId(utenteDTO1.getId());
        assertThat(utenteDTO1).isEqualTo(utenteDTO2);
        utenteDTO2.setId(2L);
        assertThat(utenteDTO1).isNotEqualTo(utenteDTO2);
        utenteDTO1.setId(null);
        assertThat(utenteDTO1).isNotEqualTo(utenteDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(utenteMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(utenteMapper.fromId(null)).isNull();
    }
}
