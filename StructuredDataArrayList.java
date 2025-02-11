public class ListArrayClass {
	
	// Constantes - Sempre definidas com todas as letras maiúsculas. 
	//              Ao  invés de usar uma literal (valor) no código, 
	//              devemos usar uma constante.
	
	final public static int TAMANHO_INICIAL = 3;
	final public static int FATOR_CRESCIMENTO = 5;
	final public static int  NAO_ESTA_PRESENTE = -1;
	
	// Atributos
	
	private Object[] arrayInterno;
	private int numElementos;
	
	// Métodos
	
	public ListArrayClass() {
		this.numElementos = 0; // -- Não precisaria, já que é a inicialização default
		this.arrayInterno = new Object[TAMANHO_INICIAL];
	}
	
	/** 
	 * Verifica a necessidade de crescimento do array interno. Este método é privado,
	 * pois só deve ser visível internamente à classe.
	 */
	private void verificarNecessidadeDeCrescimento() {
		// Obtendo o tamanho do array referenciado por this.arrayInterno
		int tamanho = this.arrayInterno.length;
		// Se o tamanho é igual ao número de elementos, é porque o arrayInterno está cheio
		// Então precisamos de um novo array
		if(tamanho == this.numElementos) {
			// Criação de um array maior
			Object[] novoArray = new Object[tamanho + FATOR_CRESCIMENTO];
			for(int i = 0; i < tamanho; i++) {
				novoArray[i] = this.arrayInterno[i];
			}
			this.arrayInterno = novoArray;
		}
	}
	/**
	 * Adiciona a referência para um onovo elemento na posição indicada
	 * @param elemento - referência para o objeto a ser adicionado na ListaArray
	 * @return true: Se a posição for plausível; false: Se a posição for inválida
	 */
	public boolean adicionar(Object elemento, int posicao) {
		if(posicao < 0 || posicao > this.numElementos) {
			return false;
		}
		this.verificarNecessidadeDeCrescimento();
		
		for(int i = this.numElementos; i > posicao; i--) {
			this.arrayInterno[i] = this.arrayInterno[i-1];
		}
		this.arrayInterno[posicao] = elemento;
		return true;
	}
	
	/*
	 * Retorna a referência para o elemento presente na posição indicada
	 * @param posicao - índice para recuperação do elemento
	 * @return referência para o elemento dda posição ou null se a posição for inválida
	 */
	public Object obter(int posicao) {
		if(posicao < 0 || posicao >= this.numElementos) {
			return null;
		}
		return this.arrayInterno[posicao];
	}
	
	/**
	 * Retorna a referência em que um elemento ja está presente
	 * @param elemento referência para o elemento procurado
	 * @return posição onde está o elemento ou NÃO_ESTA_PRESENTE se não for encontrado
	 */
	public int posicaoDe(Object elemento) {
		for(int i = 0; i < this.numElementos; i++) {
			if(this.arrayInterno[i] == elemento){
				return i;
			}
		}
		return NAO_ESTA_PRESENTE;
	}
	/**
	 * Remove o elemento da posição indicada. Precisará agrupar os elementos
	 * para não deixar null ('buraco') no arrayInterno
	 * @param posicao
	 * @return
	 */
	public boolean remover(int posicao){
		if(posicao < 0 || posicao >= this.numElementos) {
			return false;
		}
		for (int i = posicao; i < this.numElementos; i++) {
			this.arrayInterno[i] = this.arrayInterno[i+1];
		}
		this.arrayInterno[this.numElementos - 1] = null;
		this.numElementos--;
		return true;
	}
	/**
	 * Remove o elemento da lista caso esteja presente
	 * @param elemento - referência para o objeto a ser removido
	 * @return true se o elemento estiver presente na lista; false caso contrário
	 */
	public boolean remover(Object elemento) {
		int posicao = this.posicaoDe(elemento);
		if(posicao == NAO_ESTA_PRESENTE) {
			return false;
		}
		return this.remover(posicao);
	}
	
	/**
	 * Retorna o número de elementos presentes na lista
	 * @return número de elementos
	 */
	
	public int obterNumElementos() {
		return this.numElementos;
	}
	
}
