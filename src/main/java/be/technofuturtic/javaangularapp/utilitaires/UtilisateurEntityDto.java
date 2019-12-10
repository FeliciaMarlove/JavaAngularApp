package be.technofuturtic.javaangularapp.utilitaires;

public class UtilisateurEntityDto {
    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String dateNaiss;
    private String email;
    private String password;
    private Boolean newsletterOptIn;
    private Integer roleId;
    private Integer paysId;
    private Long idUtilisateur;

    public UtilisateurEntityDto(String nomUtilisateur, String prenomUtilisateur, String dateNaiss, String email, String password, Boolean newsletterOptIn, Integer roleId) {
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.dateNaiss = dateNaiss;
        this.email = email;
        this.password = password;
        this.newsletterOptIn = newsletterOptIn;
        this.roleId = roleId;
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
        return password;
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
}
