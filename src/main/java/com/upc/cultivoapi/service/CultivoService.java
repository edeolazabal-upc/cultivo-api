package com.upc.cultivoapi.service;

import com.upc.cultivoapi.model.Cultivo;
import com.upc.cultivoapi.repository.CultivoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CultivoService {
    final CultivoRepository cultivoRepository;

    public CultivoService(CultivoRepository cultivoRepository) {
        this.cultivoRepository = cultivoRepository;
    }
    public List<Cultivo> listar() {
        return cultivoRepository.findAll();
    }
    public Optional<Cultivo> getById(Long id) {
        Optional cultivo = cultivoRepository.findById(id);
        return cultivo;
    }
    public Cultivo modificar(Long id, Cultivo cultivo) {
        Cultivo cultivoModificado = cultivoRepository.findById(id).get();
        cultivoModificado.setCantidad(cultivo.getCantidad());
        cultivoModificado.setCategoria(cultivo.getCategoria());
        cultivoModificado.setNombre(cultivo.getNombre());
        cultivoModificado.setFechaSiembra(cultivo.getFechaSiembra());

        return cultivoRepository.save(cultivoModificado);

    }
    public Cultivo registrar(Cultivo cultivo) {
        return cultivoRepository.save(cultivo);
    }
    public Long obtienePromedio() {
        return cultivoRepository.getAvg();
    }
    public void eliminar(Long id) {
        cultivoRepository.deleteById(id);
    }
}
