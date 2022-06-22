package sv.gob.cajamined.siplan.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sv.gob.cajamined.siplan.entities.Indicador;
import sv.gob.cajamined.siplan.repositories.IndicadorRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class IndicadorController {

    @Autowired
    private IndicadorRepo indicadorRepo;

    @GetMapping(value = "indicadores")
    private List<Indicador> getAllIndicadores() {
        return indicadorRepo.findByOrderByIdIndicadorAsc();
    }

    @GetMapping(value = "indicadores/{idIndicador}")
    private Optional<Indicador> getIndicadorById(@PathVariable Long idIndicador) {
        return indicadorRepo.findById(idIndicador);
    }

    @PostMapping(value = "indicadores")
    public Indicador createIndicador(@RequestBody Indicador indicador) {
        return indicadorRepo.save(indicador);
    }

    @DeleteMapping(value = "indicadores")
    public void deleteIndicador(@RequestBody Indicador indicador) {
        indicadorRepo.delete(indicador);
    }
}
