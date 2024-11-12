public class Carro extends Veiculo{
    private int NumPortas;

    public Carro(String modelo, Integer ano, String fabricante, int NumPortas){
        super(modelo, ano, fabricante);
        this.NumPortas = NumPortas;
    }

    public int getNumPortas() {
        return NumPortas;
    }

    public void exibirInfo(){
        super.exibirInfo();
        System.out.println("Número portas: " + NumPortas);
    
    }
}
