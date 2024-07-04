package projeto.dc.api_rest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String sobrenome;
    private String biografia;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private String genero;
    private Boolean ativo;

    @ManyToOne
    private Personagem personagem;

}
