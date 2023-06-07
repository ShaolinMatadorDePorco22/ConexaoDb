package unipar.exemplo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {

    private Integer id;
    private String nome;
    private String cnpj;
    private String telefone;
    private String email;
    private String situacao;
    private String cidade;
    private String estado;
    private Double credito;


}
