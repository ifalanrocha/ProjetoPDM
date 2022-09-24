package projetoPDM.models.beans;


public class Logradouro {
    
    private int idLog;
    private int idUsupes;
    private String rua;
    private int numero;
    private String cep;
    private String uf;

    public Logradouro(int idLog, int idUsupes) {
        this.idLog = idLog;
        this.idUsupes = idUsupes;
    }

    public Logradouro(int idLog) {
        this.idLog = idLog;
    }

    public Logradouro(int idLog, int idUsupes, String rua, int numero, String cep, String uf) {
        this.idLog = idLog;
        this.idUsupes = idUsupes;
        this.rua = rua;
        this.numero = numero;
        this.cep = cep;
        this.uf = uf;
    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public int getIdUsupes() {
        return idUsupes;
    }

    public void setIdUsupes(int idUsupes) {
        this.idUsupes = idUsupes;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
