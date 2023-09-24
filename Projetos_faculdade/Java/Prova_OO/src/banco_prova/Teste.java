package banco_prova;

import java.util.ArrayList;
import java.util.Scanner;

/*1) Fa�a um sistema que gerencie as contas e poupan�as de um banco. A classe conta possui:
n�mero, Banco (n�mero da ag�ncia e nome da ag�ncia), Cliente (nome e CPF) e o saldo. A
classe Poupan�a possui os mesmos dados da classe com mais o atributo juros e o m�todo.
render juros. Crie uma classe teste que forne�a as seguintes op��es:
1. Cadastrar Conta ou Poupan�a (Pergunte aos clientes o que ele quer cadastrar)
2. Realizar dep�sito (Buscar pelo CPF do cliente)
3. Render Juros (Buscar pelo CPF do cliente)
4. Consultar n�mero e nome da ag�ncia (Mostrar nome e o CPF do cliente)
5. Alterar o n�mero e nome da ag�ncia (Buscar pelo nome do cliente)
0. Sair
Obs.: O sistema deve permitir o cadastro de 10 (dez) clientes.
*/

public class Teste {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Conta> contas = new ArrayList<>();

        
        while (true) {
            System.out.println("1. Cadastrar Conta ou Poupan�a");
            System.out.println("2. Realizar dep�sito (buscar pelo CPF do cliente)");
            System.out.println("3. Render juros (buscar pelo CPF do cliente)");
            System.out.println("4. Consultar n�mero e nome da ag�ncia (mostrar nome e CPF do cliente)");
            System.out.println("5. Alterar o nome e n�mero da ag�ncia (buscar pelo nome do cliente)");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch(opcao) {
            case 1:
            	if(contas.size() >=10) {
            		System.out.println("Limite de contas atingido.");
            	}else {cadastrar(scanner, clientes, contas);
            		
            	}
            	break;
            case 2:
                depositar(scanner, clientes, contas);
                break;
            case 3:
                render_juros(scanner, clientes, contas);
                break;
                
            case 4:
            	consultar_agencia(scanner, clientes);
                break;    

            case 5:
            	alterarAgencia(scanner, clientes, contas);
            	break;
            case 0:
            	System.out.println("fechando programa.");
            	scanner.close();
            	break;
            default:
            	System.out.println("Op��o inv�lida.");
    }
	}
	

}public static void cadastrar(Scanner scanner, ArrayList<Cliente> clientes, ArrayList<Conta> contas) {
    System.out.print("Digite o nome do cliente: ");
    String nome_cliente = scanner.nextLine();
    System.out.print("Digite o CPF do cliente: ");
    String cpf_cliente = scanner.nextLine();
    System.out.print("� uma conta (C) ou poupan�a (P)? ");
    String tipo_conta = scanner.nextLine();

    if (tipo_conta.equalsIgnoreCase("C")) {
        System.out.print("Digite o n�mero da conta: ");
        int numero_conta = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o n�mero da ag�ncia: ");
        String numero_agencia = scanner.nextLine();
        System.out.print("Digite o nome da ag�ncia: ");
        String nome_agencia = scanner.nextLine();
        System.out.print("Digite o saldo inicial da conta: ");
        double saldo_inicio = scanner.nextDouble();
        scanner.nextLine();

        Banco banco = new Banco(numero_agencia, nome_agencia);
        Cliente cliente = new Cliente(nome_cliente, cpf_cliente);
        Conta conta = new Conta(numero_conta, banco, cliente);
        conta.depositar(saldo_inicio);

        clientes.add(cliente);
        contas.add(conta);
        

        cliente.setConta(conta);

        System.out.println("Conta cadastrada com sucesso!");
    } else if (tipo_conta.equalsIgnoreCase("P")) {
        System.out.print("Digite o n�mero da conta poupan�a: ");
        int numero_contap = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Digite o n�mero da ag�ncia da poupan�a: ");
        String numero_agenciap = scanner.nextLine();
        System.out.print("Digite o nome da ag�ncia da poupan�a: ");
        String nome_agenciap = scanner.nextLine();
        System.out.print("Digite o saldo inicial da poupan�a: ");
        double saldo_iniciop = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Digite a taxa de juros da poupan�a (%): ");
        double taxa_Juros = scanner.nextDouble();
        scanner.nextLine();

        Banco banco_p = new Banco(numero_agenciap, nome_agenciap);
        Cliente cliente_p = new Cliente(nome_cliente, cpf_cliente);
        ContaPoupanca conta_p = new ContaPoupanca(numero_contap, banco_p, cliente_p, taxa_Juros);
        conta_p.depositar(saldo_iniciop);

        clientes.add(cliente_p);
        contas.add(conta_p);

        cliente_p.setConta(conta_p);

        System.out.println("Poupan�a cadastrada com sucesso!");
    } else {
        System.out.println("Op��o inv�lida.");
    }
}


public static void depositar(Scanner scanner, ArrayList<Cliente> clientes, ArrayList<Conta> contas) {
    System.out.print("Digite o CPF do cliente: ");
    String cpf_b = scanner.nextLine();

    for (Cliente cliente : clientes) {
        if (cliente.getCpf().equals(cpf_b)) {
            Conta conta = cliente.getConta();
            if (conta != null) {
                System.out.print("Digite o valor do dep�sito: ");
                double valor_deposito = scanner.nextDouble();
                scanner.nextLine(); 
                conta.depositar(valor_deposito);
                System.out.println("Dep�sito realizado com sucesso!");
            } else {
                System.out.println("Cliente n�o possui conta.");
            }
            return;
        }
    }
    System.out.println("Cliente n�o encontrado.");
}
public static void render_juros(Scanner scanner, ArrayList<Cliente> clientes, ArrayList<Conta> contas) {
    System.out.print("Digite o CPF do cliente: ");
    String cpf_b = scanner.nextLine();

    for (Conta conta : contas) {
        if (conta.getCliente().getCpf().equals(cpf_b) && conta instanceof ContaPoupanca) {
            ContaPoupanca poupanca = (ContaPoupanca) conta;
            poupanca.renderJuros();
            System.out.println("Juros rendidos com sucesso!");
            return;
        }
    }
    System.out.println("Cliente n�o tem poupan�a.");
}

public static void consultar_agencia(Scanner scanner, ArrayList<Cliente> clientes) {
    System.out.println("Digite o n�mero da ag�ncia: ");
    String numero_agenciab = scanner.nextLine();

    System.out.println("Digite o nome da ag�ncia: ");
    String nome_agenciab = scanner.nextLine();

    System.out.println("Clientes na ag�ncia " + numero_agenciab + " (" + nome_agenciab + "):");
    for (Cliente cliente : clientes) {
        Conta conta = cliente.getConta();
        if (conta != null) {
            Banco banco = conta.getBanco();
            if (banco.getNumeroAgencia().equals(numero_agenciab) && banco.getNomeAgencia().equalsIgnoreCase(nome_agenciab)) {
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("CPF: " + cliente.getCpf());
            }
        }
    }
}

public static void alterarAgencia(Scanner scanner, ArrayList<Cliente> clientes, ArrayList<Conta> contas) {
    System.out.print("Digite o nome do cliente: ");
    String nomeBusca = scanner.nextLine();

    for (Cliente cliente : clientes) {
        if (cliente.getNome().equalsIgnoreCase(nomeBusca)) {
            System.out.print("Digite o novo n�mero da ag�ncia: ");
            String novoNumeroAgencia = scanner.nextLine();
            System.out.print("Digite o novo nome da ag�ncia: ");
            String novoNomeAgencia = scanner.nextLine();

            Banco banco = cliente.getConta().getBanco();
            banco = new Banco(novoNumeroAgencia, novoNomeAgencia);
            cliente.getConta().getBanco();

            System.out.println("Ag�ncia alterada com sucesso!");
            return;
        }
    }
    System.out.println("Cliente n�o encontrado.");
}

}
