package models;

public class Pessoas {
    private String Nome;
    private String Cpf;

    public Pessoas() {
    }

    public Pessoas(String Nome, String Cpf) {
        this.Nome = Nome;
        this.Cpf = Cpf;
    }

    public String getNome() {
        return Nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

}
