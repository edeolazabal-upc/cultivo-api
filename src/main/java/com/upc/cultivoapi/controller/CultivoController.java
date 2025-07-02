package com.upc.cultivoapi.controller;

import com.upc.cultivoapi.model.Cultivo;
import com.upc.cultivoapi.service.CultivoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cultivos")
@CrossOrigin
public class CultivoController {
    final CultivoService cultivoService;

    public CultivoController(CultivoService cultivoService) {
        this.cultivoService = cultivoService;
    }
    @GetMapping
    public List<Cultivo> findAll() {
        return cultivoService.listar();
    }

    @GetMapping("{id}")
    public Optional<Cultivo> findById(@PathVariable Long id) {
        return cultivoService.getById(id);
    }
    @PostMapping
    public Cultivo save(@RequestBody Cultivo cultivo) {
        return cultivoService.registrar(cultivo);
    }
    @PutMapping("{id}")
    public Cultivo update(@PathVariable Long id, @RequestBody Cultivo cultivo) {
        return cultivoService.modificar(id, cultivo);
    }
    @GetMapping("/avg")
    public Long getAvg() {
        return cultivoService.obtienePromedio();
    }
    @DeleteMapping("{id}")
    public void eliminar(@PathVariable Long id) {
        cultivoService.eliminar(id);
    }
}
