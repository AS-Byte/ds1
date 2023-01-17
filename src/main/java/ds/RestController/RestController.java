package ds.RestController;
import ds.DAO.Entities.Declaration;
import ds.DAO.Entities.Utilisateur;
import ds.Services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@org.springframework.web.bind.annotation.RestController

public class RestController {
    @Autowired
    IService is;

    @PostMapping("ajouterVictime")
    Utilisateur ajouterVictime(@RequestBody Utilisateur victime){
        return is.ajouterVictime(victime);
    }

    @PostMapping("ajouterPoliciers")
    String ajouterPoliciers(@RequestBody List<Utilisateur> policiers) {
        return is.ajouterPoliciers(policiers);
    }

    @PostMapping("ajouterDeclarationEtAffecterAVictime")
    public String ajouterDeclarationEtAffecterAVictime(@RequestBody Declaration declaration,
                                                       @RequestParam long telephone){
        return is.ajouterDeclarationEtAffecterAVictime(declaration,telephone);
    }
    @PutMapping("affecterPolicierADeclarataion")
    public void affecterPolicierADeclarataion(@RequestParam long idUtilisateur,
                                              @RequestParam long idDeclarataion){
        is.affecterPolicierADeclarataion(idUtilisateur,idDeclarataion);
    }
    @PutMapping("traiterDeclarationAutomatiquement")
    public void traiterDeclarationAutomatiquement(){
        is.traiterDeclarationAutomatiquement();
    }
    @GetMapping("afficherDeclarationsTraitees")
    public List<Utilisateur> afficherDeclarationsTraitees(){
       return is.afficherDeclarationsTraitees();
    }

}
