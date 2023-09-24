package banco_prova;

public class Banco {
	public String numeroAgencia;
    public String nomeAgencia;

    public Banco(String numeroAgencia, String nomeAgencia) {
        this.numeroAgencia = numeroAgencia;
        this.nomeAgencia = nomeAgencia;
    }

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getNomeAgencia() {
		return nomeAgencia;
	}

	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}

}
