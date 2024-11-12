public class Veiculo{
    private String modelo;
    private  String fabricante;
    private Integer ano;



    public Veiculo(String modelo, Integer ano, String fabricante){
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void exibirInfo(){
        System.out.println("Modelo: " + modelo +" Ano: " + ano + " fabricante: " + fabricante);
    }
    

}