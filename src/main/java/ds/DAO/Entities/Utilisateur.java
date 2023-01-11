package ds.DAO.Entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String nom;

    String prenom;

    String adresse;

    long telephone;

    @Enumerated(EnumType.STRING)
    Role role;

    //Utilisateur est le child
    @JsonIgnore
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "utilisateur", fetch = FetchType.EAGER)
    List<Declaration> declarations=new ArrayList<Declaration>();

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
