package com.vsm.clientManager.controller;

import com.vsm.clientManager.service.CidadeService;
import com.vsm.clientManager.service.ClienteService;
import com.vsm.clientManager.exception.ClienteNotFoundException;
import com.vsm.clientManager.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CidadeService cidadeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/novoCliente")
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.create(cliente);
    }

    @GetMapping(value = "/listarTodos")
    public List<Cliente> listAll() {
        return clienteService.findAll();
    }

    @GetMapping(value = "/buscarCliente/{id}")
    public Cliente findById(@PathVariable Integer id) throws ClienteNotFoundException {
        return clienteService.findById(id);
    }


    @PutMapping(value = "/atualizarCliente/{id}")
    public Cliente updateById(@PathVariable Integer id, @RequestBody Cliente cliente) throws ClienteNotFoundException {
        return clienteService.updateById(id, cliente);
    }
//
    @PutMapping(value = "/desativarCliente/{id}")
    public Cliente disableCliente(@PathVariable Integer id, @RequestBody Cliente cliente) throws ClienteNotFoundException {
        return clienteService.disableCliente(id, cliente);
    }
    @GetMapping(value = "/lista")
    public List<Cliente> verifyAtivo(){
        return clienteService.verifyAtivo();
    }

}
