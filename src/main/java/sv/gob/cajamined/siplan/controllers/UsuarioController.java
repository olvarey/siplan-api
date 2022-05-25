package sv.gob.cajamined.siplan.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api-siplan/v1/")
public class UsuarioController {

    @GetMapping(value = "hello")
    public String hello() {
        return "Hello World!";
    }
}
