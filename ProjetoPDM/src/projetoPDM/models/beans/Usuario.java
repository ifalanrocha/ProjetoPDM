package projetoPDM.models.beans;

public class Usuario {
    
    private int idusu;
    private String login;
    private String senha;
    private String status;
    private String tipo;

    
    public Usuario(int idusu) {
        this.idusu = idusu;
    }

    public Usuario(String login) {
        this.login = login;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String login, String senha, String status, String tipo) {
        this.login = login;
        this.senha = senha;
        this.status = status;
        this.tipo = tipo;
    }

    public Usuario(int idusu, String login, String senha, String status, String tipo) {
        this.idusu = idusu;
        this.login = login;
        this.senha = senha;
        this.status = status;
        this.tipo = tipo;
    }

    public Usuario() {
    
    }

    public int getIdusu() {
        return idusu;
    }

    public void setIdusu(int idusu) {
        this.idusu = idusu;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusu=" + idusu + ", login=" + login + ", senha=" + senha + ", status=" + status + ", tipo=" + tipo + '}';
    } 
}
