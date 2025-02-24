class ListaArrayString {
    private String[] array;
    private int tamanho;

    public ListaArrayString(int capacidade) {
        this.array = new String[capacidade];
        this.tamanho = 0;
    }

    public void adicionar(String elemento) {
        if (tamanho == array.length) {
            System.out.println("Erro: Lista cheia!");
            return;
        }
        array[tamanho++] = elemento;
    }

    public void remover(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Erro: Posição inválida!");
            return;
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            array[i] = array[i + 1];
        }
        tamanho--;
    }

    public void imprimirLista() {
        System.out.print("Lista de Nomes: ");
        for (int i = 0; i < tamanho; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
    public void buscar(String nome) {
    	for(int i = 0; i < array.length; i ++) {
    		if(array[i] == nome) {
    			System.out.println("Nome " + nome + " encontrado");
    			return;
    		}
    	}
    	System.out.println("Nome não encontrado");
    }
}

public class TesteListaString {
    public static void main(String[] args) {
        ListaArrayString lista = new ListaArrayString(4);
        lista.adicionar("Ana");
        lista.adicionar("Bruno");
        lista.adicionar("Carlos");
        lista.imprimirLista();
        lista.remover(1);
        lista.adicionar("Ruanzito");
        lista.buscar("Bernado");
        lista.buscar("Carlos");
        lista.imprimirLista();
    }
}
