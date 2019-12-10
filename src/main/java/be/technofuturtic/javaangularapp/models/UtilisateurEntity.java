package be.technofuturtic.javaangularapp.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

    public PaysEntity getPays() {
        return pays;
    }

    public void setPays(PaysEntity pays) {
        this.pays = pays;
    }

    @ManyToOne(targetEntity = RoleEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_role", referencedColumnName = "id_role", foreignKey = @ForeignKey(name = "FK_Utilisateur_Role"))
    private RoleEntity role;

    @ManyToOne(targetEntity = PaysEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pays", referencedColumnName = "id_pays", foreignKey = @ForeignKey(name = "FK_Utilisateur_Pays"))
    private PaysEntity pays;

    @OneToMany(mappedBy = "utilisateur", targetEntity = ParcoursUtilisateurLiaison.class, fetch = FetchType.LAZY)
    @JsonBackReference //avoids infiite recursion (works with @JsonManagedReference on the ManyToOne side)
    private List<ParcoursUtilisateurLiaison> listeParcoursUtilisateurs;

    public void ajouterRelationParcours(ParcoursUtilisateurLiaison a) {
        listeParcoursUtilisateurs.add(a);
    }

    public void retirerRelationParcours(ParcoursUtilisateurLiaison a) {
        listeParcoursUtilisateurs.remove(a);
    }

    public List<ParcoursUtilisateurLiaison> getListeParcoursUtilisateurs() {
        return listeParcoursUtilisateurs;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public RoleEntity getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilisateurEntity that = (UtilisateurEntity) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtilisateur, nomUtilisateur, prenomUtilisateur, dateNaiss, email, motDePasse, newsletterOptIn, isActiveUtilisateur, role, pays);
    }

    public UtilisateurEntity(String nomUtilisateur, String prenomUtilisateur, LocalDate dateNaiss, String email, String motDePasse, boolean newsletterOptIn, PaysEntity pays) {
        this();
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.dateNaiss = dateNaiss;
        this.email = email;
        this.motDePasse = motDePasse;
        this.newsletterOptIn = newsletterOptIn;
        this.pays = pays;
        this.setActiveUtilisateur(true);
    }

    public UtilisateurEntity() {
        this.listeParcoursUtilisateurs = new ArrayList<>();
        this.isActiveUtilisateur = true;
    }

    @Override
    public String toString() {
        return "UTILISATEUR \n\tUtilisateurEntity{" +
                "idUtilisateur=" + idUtilisateur +
                ", nomUtilisateur='" + nomUtilisateur + '\'' +
                ", prenomUtilisateur='" + prenomUtilisateur + '\'' +
                ", dateNaiss=" + dateNaiss +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", newsletterOptIn=" + newsletterOptIn +
                ", isActiveUtilisateur=" + isActiveUtilisateur +
                ", pays=" + pays +
                '}' + "\nFIN UTILISATEUR-------------\n";
    }
}
