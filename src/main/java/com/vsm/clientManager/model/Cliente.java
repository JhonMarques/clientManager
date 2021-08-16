package com.vsm.clientManager.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo NOME não pode ser vazio")
    private String nome;


    @NotEmpty(message = "Campo CPF não pode ser vazio")
    @Length(min = 11, max = 14, message = "O campo CPF/CNPJ deve ter entre 11 e 14 caracteres")
    private String cpf;

    private Integer telefone;

    private String cep;

    private String endereco;

    private String numero;

    private String bairro;

    private String email;

    private boolean ativo = true;

    private String cidade;

//    @ManyToOne  (cascade=CascadeType.MERGE)
//    @JoinColumn(name = "cidade_id")
//    private Cidade cidade;

}
