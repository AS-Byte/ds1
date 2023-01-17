package ds.DAO.Repositories;
import ds.DAO.Entities.Propriete;
import ds.DAO.Entities.TypePropriete;
import ds.DAO.Entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepUtilis extends CrudRepository<Utilisateur,Long> {
    Utilisateur findByTelephone(long telephone);
    List<Utilisateur> findByDeclarationsPolicierEstTraiteeAndDeclarationsPolicierProprieteTypePropriete
            (boolean traitee, TypePropriete typePropriete);
}
