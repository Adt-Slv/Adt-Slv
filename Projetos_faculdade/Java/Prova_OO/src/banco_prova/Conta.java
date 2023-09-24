package banco_prova;

public class Conta {
	public int numero;
    public Banco banco;
    public Cliente cliente;
    public double saldo;

    public Conta(int numero, Banco banco, Cliente cliente) {
        this.numero = numero;
        this.banco = banco;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return numero;
    }

    public Banco getBanco() {
        return banco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }
}

