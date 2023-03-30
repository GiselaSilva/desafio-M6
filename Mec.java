
public class Mec
{
    // primeiro método - Vai imprimir em tela as informações das universidades
    //o método recebe por parâmetro um array de objetos da superclasse Universidade
    // o for vai percorrer o array
    // o if/ else if - estruturas condicionais que vão diferenciar as univ. publicas e privadas
    //e imprimir os dados conforme a instanciação dos objetos.
    public void imprimeInfoUniversidades(Universidade [] arrayUniversidade){
        for(int i=0; i <arrayUniversidade.length; i++) {
           if(arrayUniversidade[i] instanceof Privada) {
               System.out.println(" ------- Dados da Universidade Privada -------");
               arrayUniversidade[i].imprimeInfo();
               System.out.println("");
            } else if (arrayUniversidade[i] instanceof Publica) {
                System.out.println(" ");
                System.out.println(" ------- Dados da Universidade Pública -------");
                arrayUniversidade[i].imprimeInfo(); 
                System.out.println("");
            }
        }
    }
    
    //segundo metodo - Vai imprimir em tela a univ. mais cara
    // método recebe por parâmetro um array de objetos da superclasse Universidade
    //temos a declaração de 3 variáveis que vão ajudar no metodo
    //o for vai percorrer o array
    //o primeiro if vai verificar se a univ. é privada, caso seja
    //o segundo if vai acessar o valor da mensalidade no indice i e verificar se ela é maior 
    //que o valor dentro da variavel valorMensalidade. Caso seja maior, ela passa a ter 
    //esse valor armazenado
    //ao final, é mostrado em tela o valor da mensalidade mais cara e os dados da univ
    public void universidadeMaisCara(Universidade [] arrayUniversidade){
        double valorMensalidade = 0;
        int indice = 0;
        int x = 0;
        for(int i = 0; i <arrayUniversidade.length; i++) {
                if(arrayUniversidade[i] instanceof Privada){
                    if(((Privada)arrayUniversidade[i]).getValorMensalidade() > valorMensalidade && ((Privada)arrayUniversidade[i]).getValorMensalidade() != 0){
                    valorMensalidade = ((Privada)arrayUniversidade[i]).getValorMensalidade();
                    indice = i;
                    x = 1;
                    } 
            }
        }
        
        System.out.printf("A mensalidade mais cara é de R$%.2f e pertence a Universidade:\n", valorMensalidade);
        arrayUniversidade[indice].imprimeInfo();
        
        if (x ==0)
            System.out.println("Todas as univesidades cadastradas são Públicas");
    }   
    
    //3 método - Pesquisa as univ.Publicas no Sul do país
    //declarei uma variavel que vai me ajudar no metodo
    //o for vai percorrer o array
    //o primeiro if vai verificar se a univ. é publica, caso seja
    //o segundo if vai acessar a região ou estados e ver se é igual ao solicitado por parametro, caso seja
    //imprimi as informações da univ. e a variável passa a valer 1 e encerra o laço. Caso a univ. não seja Publica, sai do laço e 
    //e vai para o if fora do for.
    public void universidadeDoSul(Universidade [] arrayUniversidade, String estado){
        int x = 0;
        for(int i = 0; i <arrayUniversidade.length; i++) {
            if(arrayUniversidade[i] instanceof Publica)
                if((((Publica)arrayUniversidade[i]).getEstado()).equalsIgnoreCase("Sul") ||
                (((Publica)arrayUniversidade[i]).getEstado()).equalsIgnoreCase("PR") || 
                (((Publica)arrayUniversidade[i]).getEstado()).equalsIgnoreCase("SC") || 
                (((Publica)arrayUniversidade[i]).getEstado()).equalsIgnoreCase("RS")) {
                    arrayUniversidade[i].imprimeInfo();
                    x = 1;
                }
        }
        
        if (x == 0)
            System.out.println("Nenhuma Universidade foi encontrada para o Região: " +estado);
    }
}
