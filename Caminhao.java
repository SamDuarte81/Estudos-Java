public class Caminhao extends Veiculo {
    double PesoCapacicade;

    public Caminhao (String modelo,Integer ano, String fabricante, double PesoCapacicade){
        super(modelo, ano, fabricante);
        this.PesoCapacicade = PesoCapacicade;
    }

    public double getCapacidade() {
        return PesoCapacicade;
    }    

    public void exibirInfo(){
        super.exibirInfo();
        System.out.println("Capacidade maxima de carga: " + PesoCapacicade + " Kg");        


    }
}
