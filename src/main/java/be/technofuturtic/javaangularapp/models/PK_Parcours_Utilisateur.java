package be.technofuturtic.javaangularapp.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class PK_Parcours_Utilisateur implements Serializable {

    @Column(name = "id_utilisateur")
    private Long idUtil;

    @Column(name = "id_parcours")
    private Integer idParc;

    @Column(name = "date_parc_util")
    private LocalDate dateParcUtil;

    public PK_Parcours_Utilisateur() {
    }

    public PK_Parcours_Utilisateur(Long idUtil, Integer idParc, LocalDate date) {
        this.idUtil = idUtil;
        this.idParc = idParc;
        this.dateParcUtil = date;
    }

    public Long getIdUtil() {
        return idUtil;
    }

    public Integer getIdParc() {
        return idParc;
    }

    public LocalDate getDateParcUtil() {
        return dateParcUtil;
    }

    public void setIdUtil(Long idUtil) {
        this.idUtil = idUtil;
    }

    public void setIdParc(Integer idParc) {
        this.idParc = idParc;
    }

    public void setDateParcUtil(LocalDate dateParcUtil) {
        this.dateParcUtil = dateParcUtil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PK_Parcours_Utilisateur that = (PK_Parcours_Utilisateur) o;
        return Objects.equals(idUtil, that.idUtil) &&
                Objects.equals(idParc, that.idParc) &&
                Objects.equals(dateParcUtil, that.dateParcUtil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtil, idParc, dateParcUtil);
    }
}
