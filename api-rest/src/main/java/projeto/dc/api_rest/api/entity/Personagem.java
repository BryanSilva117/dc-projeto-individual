package projeto.dc.api_rest.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Personagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String origem;
    private Boolean ativo;
    @Column(length = 1000)
    private String foto;

    @ElementCollection
    @CollectionTable(name = "nomes_alternativos", joinColumns = @JoinColumn(name = "personagem_id"))
    @Column(name = "nome")
    private List<String> nomesAlternativos;
}
