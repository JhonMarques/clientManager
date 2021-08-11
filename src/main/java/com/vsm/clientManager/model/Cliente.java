package com.vsm.clientManager.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Cliente  {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo NOME não pode ser vazio")
    private String nome;


    @NotEmpty(message = "Campo CPF não pode ser vazio")
    private String cpf;

    private Integer telefone;

    private String cep;

    private String endereco;

    private String numero;

    private String email;

    private Boolean ativo;


    @ManyToOne()
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

}
