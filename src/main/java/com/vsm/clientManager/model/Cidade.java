package com.vsm.clientManager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Cidade implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo NOME não pode ser vazio")
    private String nome;

    @NotEmpty(message = "Campo UF não pode ser vazio")
    private String uf;

//   @OneToMany (mappedBy = "cidade")
//    private List<Cliente> clientes = new ArrayList<>();

}
