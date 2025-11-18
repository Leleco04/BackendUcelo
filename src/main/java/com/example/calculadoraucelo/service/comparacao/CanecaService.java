package com.example.calculadoraucelo.service.comparacao;

import com.example.calculadoraucelo.model.Caneca;
import com.example.calculadoraucelo.repository.CanecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// service de canecas
@Service
public class CanecaService {

    // injeta o repository de caneca
    @Autowired
    private CanecaRepository canecaRepository;

    // retorna a lista completa de canecas salvas
    public List<Caneca> buscarCanecas() {
        return canecaRepository.findAll();
    }

}
