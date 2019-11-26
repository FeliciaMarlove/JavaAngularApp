package be.technofuturtic.javaangularapp.utilitaires;

public class ModifierDefiDansParcoursUtil {
    private Integer idParcours;
    private Integer idDefi;
    private String nomDefi;
    private String descDefi;
    private String infobulleDefi;
    private Integer categorie;

    public ModifierDefiDansParcoursUtil() {
    }

    public ModifierDefiDansParcoursUtil(Integer idParcours, Integer idDefi, String nomDefi, String descDefi, String infobulleDefi, Integer categorie) {
        this.idParcours = idParcours;
        this.idDefi = idDefi;
        this.nomDefi = nomDefi;
        this.descDefi = descDefi;
        this.infobulleDefi = infobulleDefi;
        this.categorie = categorie;
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

    public Integer getCategorie() {
        return categorie;
    }
}
