package models;

public class Conta extends Pessoas {
    private int NumeroConta;
    private String TipoConta;
    private float Saldo;
    private float Limite;

    public Conta(int NumeroConta, String TipoConta, float Saldo, String nome, String cpf) {
        this.NumeroConta = NumeroConta;
        this.TipoConta = TipoConta;
        this.Saldo = Saldo;
        this.Limite = Limite();
        super.setCpf(cpf);
        super.setNome(nome);
    }

    public Conta(String nome, String cpf, String tipoConta) {
        TipoConta = tipoConta;
        this.Limite = Limite();
        super.setCpf(cpf);
        super.setNome(nome);
    }

    public int getNumeroConta() {
        return this.NumeroConta;
    }

    public void setNumeroConta(int NumeroConta) {
        this.NumeroConta = NumeroConta;
    }

    public String getTipoConta() {
        return this.TipoConta;
    }

    public void setTipoConta(String TipoConta) {
        this.TipoConta = TipoConta;
    }

    public float getSaldo() {
        return this.Saldo;
    }

    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
    }

    public float getLimite() {
        return this.Limite;
    }

    public void setLimite(float Limite) {
        this.Limite = Limite;
    }

    public float Limite() {
        if (Saldo > 500) {
            Limite = 300;
        } else {
            Limite = 100;
        }
        return Limite;
    }

    public void Saque(float valor) {
        if (valor > Limite) {
            Saldo -= valor;
            Limite();
        }

    }

    public void Deposito(float valor) {
        Saldo += valor;
        Limite();
    }

    @Override
    public String toString() {
        return "Nome= " + super.getNome() + ", CPF= " + super.getCpf() + ", NumeroConta= " + getNumeroConta()
                + ", TipoConta= " + getTipoConta() + ", Saldo= " + getSaldo() + ", Limite= " + getLimite() + "\n";
    }

}
