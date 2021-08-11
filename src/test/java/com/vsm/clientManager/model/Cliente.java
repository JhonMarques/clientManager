package com.vsm.clientManager.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.lang.Nullable;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Campo NOME não pode ser vazio")
    private String nome;


    @NotEmpty(message = "Campo CPF não pode ser vazio")
    private Integer cpf;

    private Integer cep;

    private Integer telefone;

    private String endereco;

    private String numero;

    private String email;

    private Boolean ativo;

    @ManyToOne()
    @JoinColumn(name = "cidade_id")
    private List<Cidade> cidades = new ArrayList<>();

}
