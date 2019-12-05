package be.technofuturtic.javaangularapp.utilitaires;

public class ParcoursEntityDto {
    private String nomParcours;
    private String descParcours;
    private Double prix;
    private Integer categorie;

    public ParcoursEntityDto() {
    }

    public ParcoursEntityDto(String nomParcours, String descParcours, Double prix, Integer idCategorie) {
        this.nomParcours = nomParcours;
        this.descParcours = descParcours;
        this.prix = prix;
        this.categorie = idCategorie;
    }

    public String getNomParcours() {
        return nomParcours;
    }

    public String getDescParcours() {
        return descParcours;
    }

    public Double getPrix() {
        return prix;
    }

    public Integer getCategorie() {
        return categorie;
    }
}
