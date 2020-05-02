package be.technofuturtic.javaangularapp.utilitaires;

import be.technofuturtic.javaangularapp.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DefiEntityDto {
    private String nomDefi;
    private String descDefi;
    private String infobulleDefi;
    private Integer categorieId;
    private String nomCategorie;

    public DefiEntityDto(String nomDefi, String descDefi, String infobulleDefi, Integer categorieId) {
        this.nomDefi = nomDefi;
        this.descDefi = descDefi;
        this.infobulleDefi = infobulleDefi;
        this.categorieId = categorieId;
    }

    public DefiEntityDto(String nomDefi, String descDefi, String infobulleDefi, String nomCategorie) {
        this.nomDefi = nomDefi;
        this.descDefi = descDefi;
        this.infobulleDefi = infobulleDefi;
        this.nomCategorie = nomCategorie;
    }

    public DefiEntityDto(String nomDefi, String descDefi, String infobulleDefi, String nomCategorie, Integer categorieId) {
        this.nomDefi = nomDefi;
        this.descDefi = descDefi;
        this.infobulleDefi = infobulleDefi;
        this.nomCategorie = nomCategorie;
        this.categorieId = categorieId;
    }

    public DefiEntityDto() {
    }

    public String getNomCategorie() {
        return nomCategorie;
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

    @Override
    public String toString() {
        return "DefiEntityDto{" +
                "nomDefi='" + nomDefi + '\'' +
                ", descDefi='" + descDefi + '\'' +
                ", infobulleDefi='" + infobulleDefi + '\'' +
                ", categorieId=" + categorieId +
                ", nomCategorie='" + nomCategorie + '\'' +
                '}';
    }
}
