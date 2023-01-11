package ds.DAO.Entities;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class a implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    /*
    @Temporal(TemporalType.DATE)
    Date dateCreation;

    @Enumerated(EnumType.STRING)
    Sexe sexe;

    @Column(unique = true)
    long cin;


    @JsonIgnore
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "clubR", fetch = FetchType.EAGER)
    List<Etudiant> responsables=new ArrayList<Etudiant>();

    @ManyToMany(mappedBy = "clubsA",cascade = CascadeType.ALL)
    List<Etudiant> adherants=new ArrayList<Etudiant>();

    @OneToMany (cascade = CascadeType.ALL)
    List<Activite> activites = new ArrayList<Activite>();
     */
}
