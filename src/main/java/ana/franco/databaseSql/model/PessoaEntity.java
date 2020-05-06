package ana.franco.databaseSql.model;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString

// JPA - Java Persistence API
@Entity
@Table(name= "pessoa")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "idade")
    private double idade;

    @Column(name = "telefone")
    private double telefone;

    @Column(name = "valor")
    private double valor;


}//fim
