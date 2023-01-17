package ds.Services;
import ds.DAO.Entities.Declaration;
import ds.DAO.Entities.Utilisateur;
import java.util.List;
public interface IService {
    Utilisateur ajouterVictime(Utilisateur victime) ;
    String ajouterPoliciers(List<Utilisateur> policiers) ;
    String ajouterDeclarationEtAffecterAVictime(Declaration declaration,
                                                long telephone) ;
    void affecterPolicierADeclarataion(long idUtilisateur,
                                       long idDeclarataion);
    void traiterDeclarationAutomatiquement();
    List<Utilisateur> afficherDeclarationsTraitees();
}