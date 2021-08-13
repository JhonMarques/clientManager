package com.vsm.clientManager.Service;


import com.vsm.clientManager.exception.CidadeNotFoundException;
import com.vsm.clientManager.exception.ClienteNotFoundException;
import com.vsm.clientManager.model.Cidade;
import com.vsm.clientManager.model.Cliente;
import com.vsm.clientManager.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Cliente create(Integer cidade_id, Cliente cliente) throws CidadeNotFoundException {
        cliente.setId(null);
        Cidade cidade = cidadeService.findById(cidade_id);
        cliente.setAtivo(true);
        cliente.setCidade(cidade);
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

}
