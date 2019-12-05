package be.technofuturtic.javaangularapp.utilitaires;

public class CategorieDto {
    private String nomCategorie;
    private String descCategorie;

    public CategorieDto(String nomCategorie, String descCategorie) {
        this.nomCategorie = nomCategorie;
        this.descCategorie = descCategorie;
    }

    public CategorieDto() {
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public String getDescCategorie() {
        return descCategorie;
    }
}


