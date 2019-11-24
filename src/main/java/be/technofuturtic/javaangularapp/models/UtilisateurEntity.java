package be.technofuturtic.javaangularapp.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Utilisateur", schema = "public", catalog = "javaangulardb")
public class UtilisateurEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id_utilisateur")
    private Long idUtilisateur;

    @Column(name = "nom", nullable = false)
    private String nomUtilisateur;

    @Column(name = "prenom", nullable = false)
    private String prenomUtilisateur;

    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaiss;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "motdepasse", nullable = false)
    private String motDePasse;

    @Column(name = "newsletter_optin", nullable = false)
    private boolean newsletterOptIn;

    @Column(name = "is_active", nullable = false)
    private boolean isActiveUtilisateur;

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public LocalDate getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(LocalDate dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public boolean isNewsletterOptIn() {
        return newsletterOptIn;
    }

    public void setNewsletterOptIn(boolean newsletterOptIn) {
        this.newsletterOptIn = newsletterOptIn;
    }

    public boolean isActiveUtilisateur() {
        return isActiveUtilisateur;
    }

    public void setActiveUtilisateur(boolean activeUtilisateur) {
        isActiveUtilisateur = activeUtilisateur;
    }

    @ManyToOne(targetEntity = RoleEntity.class)
    @JoinColumn(name = "id_role", referencedColumnName = "id_role", foreignKey = @ForeignKey(name = "FK_Utilisateur_Role"))
    private RoleEntity role;

    @ManyToOne(targetEntity = PaysEntity.class)
    @JoinColumn(name = "id_pays", referencedColumnName = "id_pays", foreignKey = @ForeignKey(name = "FK_Utilisateur_Pays"))
    private PaysEntity pays;

    @OneToMany(mappedBy = "utilisateur", targetEntity = ParcoursUtilisateurLiaison.class)
    private Set<ParcoursUtilisateurLiaison> listePUP;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilisateurEntity that = (UtilisateurEntity) o;
        return newsletterOptIn == that.newsletterOptIn &&
                isActiveUtilisateur == that.isActiveUtilisateur &&
                Objects.equals(idUtilisateur, that.idUtilisateur) &&
                Objects.equals(nomUtilisateur, that.nomUtilisateur) &&
                Objects.equals(prenomUtilisateur, that.prenomUtilisateur) &&
                Objects.equals(dateNaiss, that.dateNaiss) &&
                Objects.equals(email, that.email) &&
                Objects.equals(motDePasse, that.motDePasse) &&
                Objects.equals(role, that.role) &&
                Objects.equals(pays, that.pays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtilisateur, nomUtilisateur, prenomUtilisateur, dateNaiss, email, motDePasse, newsletterOptIn, isActiveUtilisateur, role, pays);
    }
}
