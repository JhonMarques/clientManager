package com.vsm.clientManager.controller;

import com.vsm.clientManager.Service.ClienteService;
import com.vsm.clientManager.exception.ClienteNotFoundException;
import com.vsm.clientManager.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
//
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/novoCliente")
    public ResponseEntity<Cliente> create(@Valid @RequestParam(value = "cidades", defaultValue = "0")
                                            Integer cidade_id, @RequestBody Cliente obj){
        Cliente newObj = clienteService.create(cidade_id, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/livros/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/listarTodos")
    public List<Cliente> listAll() {
        return clienteService.findAll();
    }

    @GetMapping(value = "/atualizarCliente/{id}")
    public Cliente findById(@PathVariable Integer id) throws ClienteNotFoundException {
        return clienteService.findById(id);
    }

    @PutMapping(value = "/atualizarCliente/{id}")
    public Cliente updateById(@PathVariable Integer id, @RequestBody Cliente cliente) throws ClienteNotFoundException {
        return clienteService.updateById(id, cliente);
    }

    @PutMapping(value = "/desativarCliente/{id}")
    public Cliente disableCliente(@PathVariable Integer id, @RequestBody Cliente cliente) throws ClienteNotFoundException {
        return clienteService.disableCliente(id, cliente);
    }

}
