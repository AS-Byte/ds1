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
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "victime", fetch = FetchType.EAGER)
    List<Declaration> declarationsVictime=new ArrayList<Declaration>();
    @JsonIgnore
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "policier", fetch = FetchType.EAGER)
    List<Declaration> declarationsPolicier=new ArrayList<Declaration>();

}
