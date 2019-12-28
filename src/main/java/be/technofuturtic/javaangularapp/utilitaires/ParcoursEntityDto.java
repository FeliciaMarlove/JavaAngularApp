package be.technofuturtic.javaangularapp.utilitaires;

public class ParcoursEntityDto {
    private String nomParcours;
    private String descParcours;
    private Integer categorieId;

    public ParcoursEntityDto() {
    }

    public ParcoursEntityDto(String nomParcours, String descParcours, Integer idCategorie) {
        this.nomParcours = nomParcours;
        this.descParcours = descParcours;
        this.categorieId = idCategorie;
    }

    public String getNomParcours() {
        return nomParcours;
    }

    public String getDescParcours() {
        return descParcours;
    }

    public Integer getCategorieId() {
        return categorieId;
    }
}
