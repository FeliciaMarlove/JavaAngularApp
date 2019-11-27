package be.technofuturtic.javaangularapp.utilitaires;

import be.technofuturtic.javaangularapp.models.CategorieEntity;
import be.technofuturtic.javaangularapp.repositories.CategorieRepository;

import java.util.Optional;

public class DefiEntityDto {
    private String nomDefi;
    private String descDefi;
    private String infobulleDefi;
    private Optional<CategorieEntity> categorie;
    private CategorieRepository catRep;

    public DefiEntityDto(String nomDefi, String descDefi, String infobulleDefi, Integer idCat) {
        this.nomDefi = nomDefi;
        this.descDefi = descDefi;
        this.infobulleDefi = infobulleDefi;
        this.categorie = catRep.findById(idCat);
    }

    public DefiEntityDto() {
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

    public Optional<CategorieEntity> getCategorie() {
        return categorie;
    }

    public CategorieRepository getCatRep() {
        return catRep;
    }

    public Integer getCategorieId() {
        return getCategorie().get().getIdCategorie();
    }
}
