package ds.Services;

import ds.DAO.Entities.Declaration;
import ds.DAO.Entities.Role;
import ds.DAO.Entities.Utilisateur;
import ds.DAO.Repositories.RepDec;
import ds.DAO.Repositories.RepProp;
import ds.DAO.Repositories.RepUtilis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Slf4j
@org.springframework.stereotype.Service

public class Service implements IService {
    @Autowired
    RepDec repDec;
    @Autowired
    RepProp repProp;
    @Autowired
    RepUtilis repUtilis;


    @Override
    public Utilisateur ajouterVictime(Utilisateur victime) {
        if (victime.getRole().equals(Role.POLICIER)){
            victime=new Utilisateur();

        } else if (victime.getRole().equals(Role.VICTIME)) {
            repUtilis.save(victime);
        }
        return victime;
    }

    @Override
    public String ajouterPoliciers(List<Utilisateur> policiers) {
        int nbpoliciers=0;
        for (Utilisateur policier:policiers
             ) {

            if (policier.getRole().equals(Role.POLICIER)){
                repUtilis.save(policier);
                nbpoliciers++;
            }
        }
        String msg= nbpoliciers + "policiers sont ajoutés avec\n" +
                "succès ! »";
        return msg;
    }

    @Override
    public String ajouterDeclarationEtAffecterAVictime(Declaration declaration, long telephone) {
        Utilisateur user= repUtilis.findByTelephone(telephone);
        declaration.setUtilisateur(user);
        repDec.save(declaration);

        String msg="declaration ajoutée";

        return  msg;
    }

    @Override
    public void affecterPolicierADeclarataion(long idUtilisateur, long idDeclarataion) {
        Utilisateur uaf= repUtilis.findById(idUtilisateur).get();
        Declaration daf=repDec.findById(idDeclarataion).get();
        daf.setUtilisateur(uaf);
        repDec.save(daf);
    }

    @Override
    public void traiterDeclarationAutomatiquement() {

        List<Declaration> decs = (List<Declaration>) repDec.findAll();


        for (Declaration dec:decs
        ) {
            if ((dec.getDateDeclaration().getMonth() - new Date().getMonth())>= 1){
                dec.setEstTraitee(Boolean.TRUE);
                dec.setDateTraitement(new Date());
                repDec.save(dec);
            }
        }
    }

    @Override
    public List<Utilisateur> afficherDeclarationsTraitees() {
        return null;
    }
}
