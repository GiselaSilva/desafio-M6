
public class Privada extends Universidade {
    private double valorMensalidade;

    public Privada(String n, int qA, int qP, double vM) {
        super(n, qA, qP);
        this.valorMensalidade = vM;
    }

    public double getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(double vM) {
        valorMensalidade = vM;
    }
    
    public void imprimeInfo(){
        super.imprimeInfo();
        System.out.printf("Valor da mensalidade: R$%.2f", valorMensalidade);
        System.out.printf("");
    }
    
}
