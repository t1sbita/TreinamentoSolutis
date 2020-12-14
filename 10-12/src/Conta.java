
public class Conta
{
	private int    NumeroConta;
	private String NomeCliente;
	private String Cpf;
	private float  Saldo;
	private float  Limite;
	private String TipoConta;
	
	public Conta(String nomeCliente, String cpf, String tipoConta)
	{
		super();
		NomeCliente = nomeCliente;
		Cpf = cpf;
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
		return NomeCliente;
	}
	
	public void setNomeCliente(String nomeCliente)
	{
		NomeCliente = nomeCliente;
	}
	
	public String getCpf()
	{
		return Cpf;
	}
	
	public void setCpf(String cpf)
	{
		Cpf = cpf;
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
		if (valor > Limite())
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
