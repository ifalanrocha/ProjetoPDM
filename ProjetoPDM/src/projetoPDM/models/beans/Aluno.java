package projetoPDM.models.beans;

public class Aluno {
    
    private int idalu;
    private String nome;
    private String ra;
    private String ano;
    private String idade;

    public Aluno(String nome, String ra) {
        this.nome = nome;
        this.ra = ra;
    }


    public Aluno(int idalu) {
        this.idalu = idalu;
    }

    public Aluno(String nome) {
        this.nome = nome;
    }

    public Aluno(String nome, String ra, String ano, String idade) {
        this.nome = nome;
        this.ra = ra;
        this.ano = ano;
        this.idade = idade;
    }

    public Aluno(int idalu, String nome, String ra, String ano, String idade) {
        this.idalu = idalu;
        this.nome = nome;
        this.ra = ra;
        this.ano = ano;
        this.idade = idade;
    }
    public int getIdalu() {
        return idalu;
    }

    public void setIdalu(int idalu) {
        this.idalu = idalu;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getIdade() {
        return idade;
    }


    public void setIdade(String idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Aluno{" + "idalu=" + idalu + ", nome=" + nome + ", ra=" + ra + ", ano=" + ano + ", idade=" + idade + '}';
    }
}