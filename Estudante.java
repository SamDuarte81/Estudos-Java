import java.util.Scanner;

// Classe para exceção de notas inválidas
class NotaInvalidaException extends Exception {
    public NotaInvalidaException(String message) {
        super(message);
    }
}

// Classe Estudante 
public class Estudante {
    private String nome;
    private int matricula;
    private double nota1, nota2, nota3;

    // Construtor
    public Estudante(String nome, int matricula, double nota1, double nota2, double nota3) throws NotaInvalidaException {
        this.nome = nome;
        this.matricula = matricula;
        setNotas(nota1, nota2, nota3);
    }

    // Método para definir as três notas
    public void setNotas(double nota1, double nota2, double nota3) throws NotaInvalidaException {
        if (nota1 < 0 || nota2 < 0 || nota3 < 0) {
            throw new NotaInvalidaException("Nota não pode ser negativa.");
        }
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    // Métodos getters para as notas
    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNota3() {
        return nota3;
    }

    // Método para calcular a média das notas
    public double getMedia() {
        return (nota1 + nota2 + nota3) / 3.0;
    }

    // Método para verificar aprovação
    public boolean isAprovado() {
        return getMedia() >= 70;
    }

    // Método para exibir as informações do estudante
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Média: " + getMedia());
        System.out.println("Aprovado: " + (isAprovado() ? "Sim" : "Não"));
    }

    // Método principal para inserir dados e testar a classe Estudante
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            // Solicita nome e matrícula
            System.out.print("Digite o nome do estudante: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a matrícula do estudante: ");
            int matricula = scanner.nextInt();

            // Solicita as três notas
            System.out.print("Digite a primeira nota: ");
            double nota1 = scanner.nextDouble();

            System.out.print("Digite a segunda nota: ");
            double nota2 = scanner.nextDouble();

            System.out.print("Digite a terceira nota: ");
            double nota3 = scanner.nextDouble();

            // Cria o objeto Estudante com os dados fornecidos
            Estudante estudante = new Estudante(nome, matricula, nota1, nota2, nota3);

            // Exibe as informações do estudante
            estudante.exibirInformacoes();
        } catch (NotaInvalidaException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

