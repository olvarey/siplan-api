package sv.gob.cajamined.siplan;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sv.gob.cajamined.siplan.controllers.OrganizacionController;
import sv.gob.cajamined.siplan.entities.Organizacion;
import sv.gob.cajamined.siplan.repositories.OrganizacionRepo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class OrganizacionControllerTest {

  @Mock
  private OrganizacionRepo organizacionRepo;

  @InjectMocks
  private OrganizacionController organizacionController;

  private MockMvc mockMvc;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(organizacionController).build();
  }

  @Test
  public void testGetAllOrganizacionesEndpoint() throws Exception {
    // Mock the repository to return a list of Organizacion objects
    List<Organizacion> organizaciones = Arrays.asList(new Organizacion(), new Organizacion());
    when(organizacionRepo.findByOrderByIdOrganizacionAsc()).thenReturn(organizaciones);

    mockMvc.perform(MockMvcRequestBuilders.get("/api-siplan/v1/organizaciones")
        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2));
  }

  @Test
  public void testGetOrganizacionByIdEndpoint() throws Exception {
    // Mock the repository to return an Optional with an Organizacion object
    Organizacion organizacion = new Organizacion();
    when(organizacionRepo.findById(1L)).thenReturn(Optional.of(organizacion));

    mockMvc.perform(MockMvcRequestBuilders.get("/api-siplan/v1/organizaciones/1")
      .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
  }

  @Test
  public void testCreateOrganizacionEndpoint() throws Exception {
    Organizacion organizacion = new Organizacion();
    when(organizacionRepo.save(any(Organizacion.class))).thenReturn(organizacion);

    mockMvc.perform(MockMvcRequestBuilders.post("/api-siplan/v1/organizaciones")
        .content(asJsonString(organizacion)).contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());
  }

  @Test
  public void testDeleteOrganizacionEndpoint() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.delete("/api-siplan/v1/organizaciones")
        .content(asJsonString(new Organizacion())).contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());
  }

  // Helper method to convert object to JSON string
  private static String asJsonString(final Object obj) {
    try {
      final ObjectMapper mapper = new ObjectMapper();
      return mapper.writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
