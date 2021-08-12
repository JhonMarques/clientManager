package com.vsm.clientManager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cidade  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo NOME não pode ser vazio")
    private String nome;

    @NotEmpty(message = "Campo UF não pode ser vazio")
    private String uf;


    @OneToMany (mappedBy = "cidade")
    private List<Cliente> clientes = new ArrayList<>();

}
