package be.technofuturtic.javaangularapp.utilitaires;

public class PaiementEntityDto {
    private String nomPaiement;
    private String descPaiement;

    public PaiementEntityDto(String nomPaiement, String descPaiement) {
        this.nomPaiement = nomPaiement;
        this.descPaiement = descPaiement;
    }

    public String getNomPaiement() {
        return nomPaiement;
    }

    public String getDescPaiement() {
        return descPaiement;
    }
}
