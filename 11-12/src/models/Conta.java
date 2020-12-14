package models;

public class Conta extends Pessoas
{
	private int    NumeroConta;
	private float  Saldo;
	private float  Limite;
	private String TipoConta;
	
	public Conta()
	{
		
	}
	
	public Conta(String nomeCliente, String cpf, String tipoConta)
	{
		super();
		setNomeCliente(nomeCliente);
		setCpf(cpf);
		TipoConta = tipoConta;
		Saldo = 0;
		Limite();
	}
	
	public int getNumeroConta()
	{
		return NumeroConta;
	}
	
	public void setNumeroConta(int numeroConta)
	{
		NumeroConta = numeroConta;
	}
	
	public String getNomeCliente()
	{
		return super.getNomeCliente();
	}
	
	public void setNomeCliente(String nomeCliente)
	{
		super.setNomeCliente(nomeCliente);
	}
	
	public String getCpf()
	{
		return super.getCpf();
	}
	
	public void setCpf(String cpf)
	{
		super.setCpf(cpf);
	}
	
	public float getSaldo()
	{
		return Saldo;
	}
	
	public void setSaldo(float saldo)
	{
		Saldo = saldo;
	}
	
	public float getLimite()
	{
		return Limite;
	}
	
	public void setLimite(float limite)
	{
		Limite = limite;
	}
	
	public String getTipoConta()
	{
		return TipoConta;
	}
	
	public void setTipoConta(String tipoConta)
	{
		TipoConta = tipoConta;
	}
	
	public float Limite()
	{
		if (Saldo > 500)
		{
			Limite = 300;
		} else
		{
			Limite = 100;
		}
		return Limite;
	}
	
	public void Saque(float valor)
	{
		if (valor > Limite)
		{
			Saldo -= valor;
			
		}
		
	}
	
	public void Deposito(float valor)
	{
		Saldo += valor;
		Limite();
	}
}
