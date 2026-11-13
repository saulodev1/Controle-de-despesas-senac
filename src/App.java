import java.util.ArrayList;  //importando a classe ArrayList
import java.util.Scanner;   //importando a classe Scanner

public class App {        //classe principal

    class dados {        //classe interna para armazenar os dados das despesas
        String despesa; //atributo para armazenar o nome da despesa
        int valor;     //atributo para armazenar o valor da despesa

         dados(String despesa, int valor) { //construtor da classe dados
            this.despesa = despesa;        //inicializando o atributo despesa com o valor passado como parâmetro
            this.valor = valor;           
        }
        @Override                                   //anotação para indicar que o método toString() está sendo sobrescrito
        public String toString(){                  //sobrescrevendo o método toString() da classe Object para exibir os dados da despesa de forma legível
            return despesa +"(R$ " + valor +")";  //retornando uma string com o nome da despesa e o valor formatado
        }
    }
    public static void main(String[] args) { //método principal
    
App app = new App();                        //criando uma instância da classe App para acessar a classe interna dados

        try (Scanner leitor = new Scanner(System.in)) { //criando um objeto Scanner para ler a entrada do usuário

        ArrayList<dados> lista = new ArrayList<>();            //criando uma lista para armazenar os objetos da classe dados
        lista.add (app.new dados("luz",100));  //adicionando objetos da classe dados à lista
        lista.add (app.new dados("água",50));
        lista.add (app.new dados("gás",30));
        lista.add (app.new dados("internet",80));
        lista.add (app.new dados("carro",200));

        System.out.println("===== CONTROLE DE DESPESAS ====");
        int opcao = 1;                                      //variável para armazenar a opção escolhida pelo usuário
        while(opcao >= 1) { 
        System.out.println("1 - Cadastrar despesas\n2 - Listar despesas\n3 - Ver total \n4 - Maior despesa \n5 - Remover despesa \n0 - Sair "); //exibindo o menu de opções
        System.out.print("Opção: "); //solicitando ao usuário que escolha uma opção
        opcao = leitor.nextInt(); //lendo a opção escolhida pelo usuário
        leitor.nextLine(); // Limpar o buffer do teclado
       switch (opcao) { //iniciando um bloco switch para tratar as opções escolhidas pelo usuário
            case 0:
                System.out.println("Saindo do programa..."); 

            case 1:
              
                System.out.print("Digite a despesa a ser cadastrada: "); 
                String novadespesa = leitor.nextLine();                    //lendo o nome da despesa a ser cadastrada
                System.out.println("Digite o valor da despesa: "); 
                int novovalor = leitor.nextInt();                         //lendo o valor da despesa a ser cadastrada
                lista.add(app.new dados(novadespesa, novovalor));        //adicionando a nova despesa à lista
                System.out.println("Despesa cadastrada com sucesso!");
              
                break;
               

            case 2:
                if (lista.isEmpty()){
                    System.out.println("Nenhuma despesa cadastrada.");
                }else {
                System.out.println("Lista de despesas:");
                for (int i=0; i <lista.size(); i++) {          //percorrendo a lista de despesas
                dados item = lista.get(i); //obtendo o objeto da classe dados na posição i da lista
                    
                    System.out.println("- "+ (i+1) +" "+ item.despesa + "    - R$" + item.valor); //exibindo o nome e o valor da despesa
                }}
                break;

            case 3:
                int total = 0; 
                for (dados item : lista) {  //percorrendo a lista de despesas
                    total += item.valor;    //somando o valor de cada despesa ao total
                }  
                System.out.println("Total de despesas: R$" + total);
                break;

            case 4: 
            if (!lista.isEmpty()){  //verificando se a lista não está vazia
                dados maiorDespesa = lista.get(0); //inicializando a variável maiorDespesa com o primeiro item da lista
                for (dados item: lista) {         //percorrendo a lista de despesas
                    if(item.valor > maiorDespesa.valor) { //verificando se o valor da despesa atual é maior que o valor da maior despesa encontrada até agora
                        maiorDespesa = item; //atualizando a variável maiorDespesa com o item atual, caso seja maior
                    }
                } 
                System.out.println("Maior despesa: "+ maiorDespesa.despesa + " - Valor:" + maiorDespesa.valor);
            } 
            break;

            case 5: 
            if (lista.isEmpty()){  //verificando se a lista está vazia
                System.out.println("A lista está vazia. Não há nenhum item para remover.");
                break;
            }
            System.out.println("Digite o número da despesa a ser deletada: "); 
            int remover = leitor.nextInt();             //lendo o número da despesa a ser removida
            if (remover >= 1 && remover <= lista.size()) {  //verificando se o número digitado está dentro do intervalo válido
                dados itemremovido = lista.remove(remover - 1);  //removendo o item da lista e armazenando o objeto removido na variável itemremovido
            System.out.println(itemremovido + " removida com sucesso!");
            
            break;
            }

            default:
                System.out.println("Opção inválida. Tente novamente."); //tratando a opção inválida escolhida pelo usuário
                break;
       
         } 
        }
      }
    }
  }
