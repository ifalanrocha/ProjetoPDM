package projetoPDM.models.beans;

public class Boletim {
  private int idbol, semestre, nmat, npor, ngeo;

    public Boletim(int nmat, int npor, int ngeo) {
        this.nmat = nmat;
        this.npor = npor;
        this.ngeo = ngeo;
    }

    public Boletim(int semestre, int nmat, int npor, int ngeo) {
        this.semestre = semestre;
        this.nmat = nmat;
        this.npor = npor;
        this.ngeo = ngeo;
    }

    public Boletim(int idbol) {
        this.idbol = idbol;
    }

    public Boletim(int idbol, int semestre, int nmat, int npor, int ngeo) {
        this.idbol = idbol;
        this.semestre = semestre;
        this.nmat = nmat;
        this.npor = npor;
        this.ngeo = ngeo;
    }

    public Boletim() {
    }

    public int getIdbol() {
        return idbol;
    }

    public void setIdbol(int idbol) {
        this.idbol = idbol;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getNmat() {
        return nmat;
    }

    public void setNmat(int nmat) {
        this.nmat = nmat;
    }

    public int getNpor() {
        return npor;
    }

    public void setNpor(int npor) {
        this.npor = npor;
    }

    public int getNgeo() {
        return ngeo;
    }

    public void setNgeo(int ngeo) {
        this.ngeo = ngeo;
    }
    public String toString() {
        return "Boletim{" + "idbol=" + idbol + ", semestre=" + semestre + ", nmat=" + nmat + ", npor=" + npor + ", ngeo=" + ngeo + '}';
    } 
}
