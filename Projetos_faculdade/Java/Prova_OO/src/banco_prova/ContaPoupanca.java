package banco_prova;

public class ContaPoupanca extends Conta {
	public double juros;

    public ContaPoupanca(int numero, Banco banco, Cliente cliente, double juros) {
        super(numero, banco, cliente);
        this.juros = juros;
    }

    public void setJuros(double juros) {
		this.juros = juros;
	}

	public double getJuros() {
        return juros;
    }

    public void renderJuros() {
        double saldo_atual = getSaldo();
        double jurosCalculados = saldo_atual * (juros / 100);
        depositar(jurosCalculados);
    }
}