package be.technofuturtic.javaangularapp.utilitaires;

public class ParcoursEntityDto {
    private String nomParcours;
    private String descParcours;
    private double prix;
    private Integer idCategorie;

    public ParcoursEntityDto() {
    }

    public ParcoursEntityDto(Integer idParcours, String nomParcours, String descParcours, double prix, Integer idCategorie) {
        this.nomParcours = nomParcours;
        this.descParcours = descParcours;
        this.prix = prix;
        this.idCategorie = idCategorie;
    }

    public String getNomParcours() {
        return nomParcours;
    }

    public String getDescParcours() {
        return descParcours;
    }

    public double getPrix() {
        return prix;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }
}
