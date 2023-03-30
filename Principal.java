import java.util.Scanner;
//importei a classe Scanner, para receber os dados do usuario.
//o usuario inicializa o array com o tamanho desejado


public class Principal
{
  public static void main (String args[]) { // classe main
      
      Scanner input = new Scanner(System.in);
      
      int tamanho;
      System.out.print("Quantas Universidades você deseja cadastrar? ");
      tamanho = input.nextInt();
      input.nextLine(); // limpeza de buffer
      
      Universidade [] arrayUniversidade = new Universidade[tamanho]; //instanciei o array com o valor indicado pelo usuario
      
      //inicializei as variavéis que necessito para os construtores com valores default
      int opcao, quantAlunos, quantProfessores;
      double valorMensalidade = 0;
      String nome;
      String estado = null;
      String cidade = null;
      
      // o laço for vai me apresentar as opções para cadastrar as universidades e os primeiros parametros esse cadastro
      
      for(int i = 0; i <arrayUniversidade.length; i++){
            System.out.println("\nQual Universidade você deseja cadastrar?");
            System.out.println("1 - Universidade Privada");
            System.out.println("2 - Universidade Pública");
            System.out.print("Digite a opção desejada: ");
            opcao = input.nextInt();
            input.nextLine(); // limpeza de buffer
            
            System.out.print("Digite o nome da Universidade: ");
            nome = input.nextLine();
            System.out.print("Digite a quantidade de alunos: ");
            quantAlunos = input.nextInt();
            System.out.print("Digite a quantidade de professores: ");
            quantProfessores = input.nextInt();
            input.nextLine(); // limpeza de buffer
            
            //o switch vai instanciar os objetos, conforme o usuario escolher, e inicializa as variaveis de cada opção;
            switch(opcao){
                case 1:
                    //public Universidade(String nome, int qA, int qP, double vM)
                    arrayUniversidade[i] = new Privada(nome, quantAlunos, quantProfessores,valorMensalidade);
                    System.out.print("Digite o valor da mensalidade: R$");
                    valorMensalidade = input.nextDouble();
                    input.nextLine(); // limpeza de buffer
                    ((Privada)arrayUniversidade[i]).setValorMensalidade(valorMensalidade); //downcasting - redefine o valor da mensalidade
                    break;
                    
                case 2:
                    arrayUniversidade[i] = new Publica(nome, quantAlunos, quantProfessores, cidade, estado);
                    System.out.print("Digite a cidade onde a Universidade se encontra: ");
                    cidade = input.nextLine();
                    ((Publica)arrayUniversidade[i]).setCidade(cidade); //downcasting
                    System.out.print("Digite o Estado (UF) onde a Universidade se encontra: ");
                    estado = input.nextLine();
                    ((Publica)arrayUniversidade[i]).setEstado(estado); //downcasting
                    break;
                    
                default:
                    System.out.println("Opção Inválida!");    
            }
      }
      
      
      //criei um objeto do tipo MEC
      Mec univ = new Mec(); // instancia um objeto do tipo MEC
      
      //o objeto mec, começa a chamar os metodos que estão na class mec
      System.out.println("\n ---- Relatório de Universidades Cadastradas ----\n");
      univ.imprimeInfoUniversidades(arrayUniversidade);
      System.out.println("");
      
      System.out.println(" ---- Universidade Mais Cara ----");
      univ.universidadeMaisCara(arrayUniversidade);
      System.out.println("");
      
      System.out.println(" \n----- Pesquisar Universidade por Região ----");
      System.out.print("Digite o nome do região que deseja pesquisar: ");
      estado = input.nextLine();
      univ.universidadeDoSul(arrayUniversidade, estado);
  }
}
