package domain;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "autor_id")
@Entity
@ToString
@Table(name="autor")
public class Autor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "autor_id")
    private Long autorId;

    @Column(name = "autor_name",length = 30)
    private String autorName;

    @OneToMany(fetch = FetchType.EAGER,mappedBy ="autor")
    private Set<Book> books;

    @OneToMany(fetch = FetchType.EAGER,mappedBy ="autor")
    private Set<Car> cars;


}
