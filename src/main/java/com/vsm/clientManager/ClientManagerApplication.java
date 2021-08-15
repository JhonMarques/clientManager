package com.vsm.clientManager;

import com.vsm.clientManager.model.Cidade;

import com.vsm.clientManager.model.Cliente;
import com.vsm.clientManager.repositories.CidadeRepository;
import com.vsm.clientManager.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ClientManagerApplication implements CommandLineRunner {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public static void main(String[] args) {
        SpringApplication.run(ClientManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Cidade cidade1 = new Cidade(null, "Cândido Mota", "SP");
        Cidade cidade2 = new Cidade(null, "Assis", "SP");
        Cidade cidade3 = new Cidade(null, "Marília", "SP");


        //Cliente cliente1 = new Cliente(null,"Jhonatas Katayama Marques","41327208881","996801054","19885-012","Rua Gaspar Ricardo","83","Vila Pires","jhonatasK@gmail.com",true, cidade1);

        cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
       // clienteRepository.saveAll(Arrays.asList(cliente1));
    }
}
