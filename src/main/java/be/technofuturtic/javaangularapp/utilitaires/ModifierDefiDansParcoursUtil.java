package be.technofuturtic.javaangularapp.utilitaires;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import be.technofuturtic.javaangularapp.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ModifierDefiDansParcoursUtil {
    private Integer idParcours;
    private Integer idDefi;
    private String nomDefi;
    private String descDefi;
    private String infobulleDefi;
    private Integer categorieId;
    private CategorieEntity categorie;
    private Integer defiRmv;

    @Autowired
    private CategorieRepository rep;

    public ModifierDefiDansParcoursUtil() {
    }

    //utilisé dans modifierDefiDansParcours (ServiceImp) > @PostMapping("/modifier/{idparcours}")
    public ModifierDefiDansParcoursUtil(Integer idDefiRemove, String nomDefi, String descDefi, String infobulleDefi, Integer categorieId) {
        this.defiRmv = idDefiRemove;
        this.nomDefi = nomDefi;
        this.descDefi = descDefi;
        this.infobulleDefi = infobulleDefi;
        this.categorieId = categorieId;
    }

    public ModifierDefiDansParcoursUtil(Integer idParcours, Integer idDefiRemove, String nomDefi, String descDefi, String infobulleDefi, CategorieEntity categorie) {
        this.idParcours = idParcours;
        this.defiRmv = idDefiRemove;
        this.nomDefi = nomDefi;
        this.descDefi = descDefi;
        this.infobulleDefi = infobulleDefi;
        this.categorie = categorie;
    }

    public ModifierDefiDansParcoursUtil(Integer idParcours, String nomDefi, String descDefi, String infobulleDefi, CategorieEntity categorie) {
        this.idParcours = idParcours;
        this.idDefi = idDefi;
        this.nomDefi = nomDefi;
        this.descDefi = descDefi;
        this.infobulleDefi = infobulleDefi;
        this.categorie = categorie;
    }

    public ModifierDefiDansParcoursUtil(Integer idDefiRemove) {
        this.defiRmv = idDefiRemove;
    }

    public Integer getIdParcours() {
        return idParcours;
    }

    public Integer getIdDefi() {
        return idDefi;
    }

    public String getNomDefi() {
        return nomDefi;
    }

    public String getDescDefi() {
        return descDefi;
    }

    public String getInfobulleDefi() {
        return infobulleDefi;
    }

    public Integer getCategorieId() {
        return categorieId;
    }

    public CategorieEntity getCategorie() {

        return categorie;
    }

    public Integer getDefiRmv() {
        return defiRmv;
    }
}
