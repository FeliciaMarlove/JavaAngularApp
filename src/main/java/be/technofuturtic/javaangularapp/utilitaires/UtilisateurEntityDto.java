package be.technofuturtic.javaangularapp.utilitaires;

public class UtilisateurEntityDto {
    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String dateNaiss;
    private String email;
    private String motDePasse;
    private Boolean newsletterOptIn;
    private Integer roleId;
    private Integer paysId;
    private Long idUtilisateur;
    private Boolean isBusy;

    public UtilisateurEntityDto(String nomUtilisateur, String prenomUtilisateur, String dateNaiss, String email, String motDePasse, Boolean newsletterOptIn, Integer roleId, Boolean isBusy) {
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.dateNaiss = dateNaiss;
        this.email = email;
        this.motDePasse = motDePasse;
        this.newsletterOptIn = newsletterOptIn;
        this.roleId = roleId;
        this.isBusy = isBusy;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public String getDateNaiss() {
        return dateNaiss;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return motDePasse;
    }

    public Boolean getNewsletterOptIn() {
        return newsletterOptIn;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public Integer getPaysId() {
        return paysId;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Boolean getBusy() {
        return isBusy;
    }

    public void setBusy(Boolean busy) {
        isBusy = busy;
    }
}
