package com.vsm.clientManager.Service;

import com.vsm.clientManager.exception.CidadeNotFoundException;
import com.vsm.clientManager.model.Cidade;
import com.vsm.clientManager.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    private List<Cidade> cidades = new ArrayList<>();

    public Cidade findById(Integer id) throws CidadeNotFoundException {
        Cidade cidade = verifyIfExists(id);
        return cidade;
    }

    public List<Cidade> findAll(){
        return cidadeRepository.findAll();
    }

    public Cidade create (Cidade cidade){
        cidade.setId(null);
        return cidadeRepository.save(cidade);
    }

    public void delete (Integer id) throws CidadeNotFoundException {
        verifyIfExists(id);
        cidadeRepository.deleteById(id);
    }


    private Cidade verifyIfExists(Integer id) throws CidadeNotFoundException {
        return cidadeRepository.findById(id)
            .orElseThrow(() -> new CidadeNotFoundException(id));
    }
}
