import java.util.ArrayList;

public class Lista_compras {
public static void main(String[] args) {
ArrayList<String> compras = new ArrayList<>();
compras.add("Arroz"); // add: coloca no final da lista
compras.add("Feijão");
compras.add("Café");
compras.add("Leite");
System.out.println("Itens na lista: " + compras.size()); // size: tamanho
System.out.println("Primeiro item: " + compras.get(0)); // get: pega pela posição
System.out.println("--- Minha lista ---");
for (String item : compras) { // for-each: "para cada item da lista"
System.out.println("- " + item);
}
System.out.println("Lista inteira: " + compras);
}
}

