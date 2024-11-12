public class Main {

    public static void main(String[] args) {
        Carro carro = new Carro("Uno", 2009, "Fiat", 2);
        Caminhao caminhao = new Caminhao("Carreta", 2024, "Mercedes", 1100.00);

        System.out.println("Informações do Carro:");
        carro.exibirInfo();

        System.out.println("\nInformações do Caminhão:");
        caminhao.exibirInfo();  
    }
}
