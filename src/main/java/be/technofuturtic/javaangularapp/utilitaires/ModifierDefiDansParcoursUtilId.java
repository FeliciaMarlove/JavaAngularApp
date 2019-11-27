package be.technofuturtic.javaangularapp.utilitaires;

public class ModifierDefiDansParcoursUtilId {
    private Integer idParcours;
    private Integer idDefiRemplace;
    private Integer idDefiRemplacant;

    public ModifierDefiDansParcoursUtilId(Integer idParcours, Integer idDefiRemplace, Integer idDefiRemplacant) {
        this.idParcours = idParcours;
        this.idDefiRemplace = idDefiRemplace;
        this.idDefiRemplacant = idDefiRemplacant;
    }

    public ModifierDefiDansParcoursUtilId() {
    }

    public Integer getIdParcours() {
        return idParcours;
    }

    public Integer getIdDefiRemplace() {
        return idDefiRemplace;
    }

    public Integer getIdDefiRemplacant() {
        return idDefiRemplacant;
    }
}
