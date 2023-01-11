package ds.DAO.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Declaration implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Temporal(TemporalType.DATE)
    Date dateDeclaration;

    Boolean estTraitee;

    @Temporal(TemporalType.DATE)
    Date dateTraitement;

    String description;

    //declaration est le parent
    @JsonIgnore
    @ManyToOne
    Utilisateur utilisateur;


    //declaration est le parent
    @OneToOne
    Propriete propriete;




}
