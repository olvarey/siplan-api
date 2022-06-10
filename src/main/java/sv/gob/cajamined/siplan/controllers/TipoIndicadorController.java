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

import sv.gob.cajamined.siplan.entities.TipoIndicador;
import sv.gob.cajamined.siplan.repositories.TipoIndicadorRepo;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
@CrossOrigin(value = "*")
public class TipoIndicadorController {

    @Autowired
    private TipoIndicadorRepo tipoIndicadorRepo;

    @GetMapping(value = "tipos-indicador")
    private List<TipoIndicador> getAllTiposObjetivos() {
        return tipoIndicadorRepo.findByOrderByIdTipoIndicadorAsc();
    }

    @GetMapping(value = "tipos-indicador/{idTipoIndicador}")
    private Optional<TipoIndicador> getTipoIndicadorById(@PathVariable Long idTipoIndicador) {
        return tipoIndicadorRepo.findById(idTipoIndicador);
    }

    @PostMapping(value = "tipos-indicador")
    public TipoIndicador createTipoIndicador(@RequestBody TipoIndicador tipoIndicador) {
        return tipoIndicadorRepo.save(tipoIndicador);
    }

    @DeleteMapping(value = "tipos-indicador")
    public void deleteTipoIndicador(@RequestBody TipoIndicador tipoIndicador) {
        tipoIndicadorRepo.delete(tipoIndicador);
    }
}
