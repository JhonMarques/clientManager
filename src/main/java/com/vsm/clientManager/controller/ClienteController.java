package com.vsm.clientManager.controller;

import com.vsm.clientManager.service.CidadeService;
import com.vsm.clientManager.service.ClienteService;
import com.vsm.clientManager.exception.ClienteNotFoundException;
import com.vsm.clientManager.model.Cliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value="API REST ClientManager")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private CidadeService cidadeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/novoCliente")
    @ApiOperation(value="Cadastra um novo cliente")
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.create(cliente);
    }

    @GetMapping(value = "/listarTodos")
    @ApiOperation(value="Lista todos os clientes")
    public List<Cliente> listAll() {
        return clienteService.findAll();
    }

    @GetMapping(value = "/buscarCliente/{id}")
    @ApiOperation(value="Busca um cliente por seu Id")
    public Cliente findById(@PathVariable Integer id) throws ClienteNotFoundException {
        return clienteService.findById(id);
    }

    @PutMapping(value = "/atualizarCliente/{id}")
    @ApiOperation(value="Atualiza um cliente")
    public Cliente updateById(@PathVariable Integer id, @RequestBody Cliente cliente) throws ClienteNotFoundException {
        return clienteService.updateById(id, cliente);
    }

    @PutMapping(value = "/desativarCliente/{id}")
    @ApiOperation(value="Faz a exclusão lógica de um cliente")
    public Cliente disableCliente(@PathVariable Integer id, @RequestBody Cliente cliente) throws ClienteNotFoundException {
        return clienteService.disableCliente(id, cliente);
    }

    @GetMapping(value = "/listarAtivos")
    @ApiOperation(value="Lista todos os clientes ativos no sistema")
    public List<Cliente> verifyAtivo(){
        return clienteService.verifyAtivo();
    }

    @GetMapping(value = "/listarInativos")
    @ApiOperation(value="Lista todos os clientes que foram excluídos por exclusão lógica")
    public List<Cliente> verifyInativo(){
        return clienteService.verifyInativo();
    }

    @GetMapping(value = "{cpf}")
    @ApiOperation(value="Busca os dados de um cliente por meio do CPF/CNPJ")
    public Cliente findByCpf(@PathVariable String cpf) throws ClienteNotFoundException{
        return clienteService.findByCpf(cpf);
    }



}
