package com.vsm.clientManager.service;


import com.vsm.clientManager.exception.ClienteNotFoundException;
import com.vsm.clientManager.model.Cliente;
import com.vsm.clientManager.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CidadeService cidadeService;

    public Cliente findById(Integer id) throws ClienteNotFoundException {
        Cliente cliente = verifyIfExists(id);
        return cliente;
    }

    public List<Cliente> findAll(){
            return clienteRepository.findAll();
        }

    public Cliente create(Cliente cliente) {
        cliente.setId(null);
        return clienteRepository.save(cliente);
    }

    public Cliente updateById(Integer id, Cliente cliente) throws ClienteNotFoundException {
        verifyIfExists(id);
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public Cliente disableCliente(Integer id, Cliente cliente) throws ClienteNotFoundException {
        verifyIfExists(id);
        cliente.setAtivo(false);
        return clienteRepository.save(cliente);
    }

    private Cliente verifyIfExists(Integer id) throws ClienteNotFoundException {
        return clienteRepository.findById(id)
            .orElseThrow(() -> new ClienteNotFoundException(id));
    }

    public List<Cliente> verifyAtivo(){

        List<Cliente> retorno = new ArrayList<>();
        List<Cliente> clientes = findAll();

       for (Cliente cliente : clientes){
           if(cliente.isAtivo()) {
               retorno.add(cliente);
           }
       }
       return retorno;
    }

    public List<Cliente> verifyInativo(){

        List<Cliente> retorno = new ArrayList<>();
        List<Cliente> clientes = findAll();

        for (Cliente cliente : clientes){
            if(!cliente.isAtivo()) {
                retorno.add(cliente);
            }
        }
        return retorno;
    }



}
