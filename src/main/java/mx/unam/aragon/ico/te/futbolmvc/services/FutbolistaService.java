package mx.unam.aragon.ico.te.futbolmvc.services;

import mx.unam.aragon.ico.te.futbolmvc.models.Futbolista;
import mx.unam.aragon.ico.te.futbolmvc.repositories.FutbolistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FutbolistaService {

    @Autowired
    private FutbolistaRepository futbolistaRepository;

    public boolean guardarFutbolista(Futbolista futbolista) {
        Futbolista futresultado = futbolistaRepository.save(futbolista);
        return futresultado != null;
    }

    public Futbolista getFutbolista(Integer id) {
        return futbolistaRepository.getReferenceById(id);
    }

}
