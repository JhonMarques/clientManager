package com.vsm.clientManager.controller;

import com.vsm.clientManager.Service.CidadeService;
import com.vsm.clientManager.exception.CidadeNotFoundException;
import com.vsm.clientManager.exception.ClienteNotFoundException;
import com.vsm.clientManager.model.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/novo")
    public Cidade create(@RequestBody Cidade cidade) {
        return cidadeService.create(cidade);
    }

    @GetMapping(value = "/listarTodos")
    public List<Cidade> listAll() {
        return cidadeService.findAll();
    }

    @GetMapping(value = "/buscarCidade/{id}")
    public Cidade findById(@PathVariable Integer id) throws ClienteNotFoundException, CidadeNotFoundException {
        return cidadeService.findById(id);
    }

    @PutMapping(value = "/atualizarCidade/{id}")
    public Cidade updateById(@PathVariable Integer id, @RequestBody Cidade cidade) throws CidadeNotFoundException {
        return cidadeService.updateById(id, cidade);
    }

    @DeleteMapping(value = "/deletar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void DeleteById(@PathVariable Integer id) throws CidadeNotFoundException {
        cidadeService.delete(id);

    }

}
