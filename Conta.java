import java.util.Scanner;

public class Conta {

    private Integer numconta;
    private double saldo;

    public Conta(Integer numconta) {
        this.saldo = 0;
        this.numconta = numconta;
    }

    public void depositar(double valorDeposito) {
        if (valorDeposito > 0) {
            saldo += valorDeposito;
        }
    }

    public void sacar(double sacarValor) {
        if (sacarValor >= 0 && sacarValor <= saldo) {
            saldo -= sacarValor;
        } else {
            System.out.println("Não é possível sacar esse valor.");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    private static int getIntInput(Scanner sc, String mensagem) {
        System.out.print(mensagem);
        while (!sc.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            sc.next();
        }
        return sc.nextInt();
    }

    private static double getDoubleInput(Scanner sc, String mensagem) {
        System.out.print(mensagem);
        while (!sc.hasNextDouble()) {
            System.out.println("Entrada inválida. Por favor, digite um número válido.");
            sc.next();
        }
        return sc.nextDouble();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Conta[] contas = new Conta[]{
                new Conta(1),
                new Conta(2)
        };

        boolean finalizar = false;

        while (!finalizar) {
            System.out.println("===================");
            System.out.println("1 - Sacar.");
            System.out.println("2 - Depositar.");
            System.out.println("3 - Transferir.");
            System.out.println("4 - Ver Saldo.");
            System.out.println("5 - Sair.");
            System.out.println("===================");

            int entrada = getIntInput(sc, "Opção desejada: ");
            sc.nextLine();

            switch (entrada) {
                case 1:
                    int conta = getIntInput(sc, "Digite o número da conta: ") - 1;
                    if (conta >= 0 && conta < contas.length) {
                        double valor = getDoubleInput(sc, "Digite o valor: ");
                        contas[conta].sacar(valor);
                        System.out.println("Saque realizado com sucesso.");
                    } else {
                        System.out.println("Conta inválida.");
                    }
                    break;

                case 2:
                    int conta2 = getIntInput(sc, "Digite o número da conta: ") - 1;
                    if (conta2 >= 0 && conta2 < contas.length) {
                        double valor2 = getDoubleInput(sc, "Digite o valor: ");
                        contas[conta2].depositar(valor2);
                        System.out.println("Depósito realizado com sucesso.");
                    } else {
                        System.out.println("Conta inválida.");
                    }
                    break;

                case 3:
                    int contaOrigem = getIntInput(sc, "Digite o número da sua conta: ") - 1;
                    int contaDestino = getIntInput(sc, "Digite o número da conta do destinatário: ") - 1;
                    if (contaOrigem >= 0 && contaOrigem < contas.length && contaDestino >= 0 && contaDestino < contas.length) {
                        double valor3 = getDoubleInput(sc, "Digite o valor da transferência: ");
                        if (contas[contaOrigem].getSaldo() >= valor3) {
                            contas[contaOrigem].sacar(valor3);
                            contas[contaDestino].depositar(valor3);
                            System.out.println("Transferência realizada com sucesso.");
                        } else {
                            System.out.println("Saldo insuficiente para a transferência.");
                        }
                    } else {
                        System.out.println("Conta inválida.");
                    }
                    break;

                case 4:
                    int contaSaldo = getIntInput(sc, "Digite o número da conta: ") - 1;
                    if (contaSaldo >= 0 && contaSaldo < contas.length) {
                        System.out.printf("Saldo da conta: R$%.2f%n", contas[contaSaldo].getSaldo());
                    } else {
                        System.out.println("Conta inválida.");
                    }
                    break;

                case 5:
                    finalizar = true;
                    System.out.println("Encerrando o sistema.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        sc.close();
    }
}
