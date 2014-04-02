package mvc.controller;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import mvc.model.*;
import mvc.view.*;

public class TabuleiroController {

	private Tabuleiro jogo;
	private ConsoleView view;
	private Jogador jogador;

	String[][] matriz = new String[10][10];// cria a matriz do tabuleiro
	String[][] matrizMascara = new String[10][10];// cria a matriz que oculta o tabuleiro
	PortaAvioes[] vetorPortaAvioes = new PortaAvioes[1];
	Destroyer[] vetorDestroyers = new Destroyer[2];
	Fragata[] vetorFragatas = new Fragata[2];
	Torpedeiro[] vetorTorpedeiros = new Torpedeiro[3];
	Submarino[] vetorSubmarinos = new Submarino[5];

	/*
	private Object[] arrayCopy(Object[] original) {
		Class<?> arrayType = original.getClass().getComponentType();
		Object[] copy = (Object[])java.lang.reflect.Array.newInstance(arrayType, original.length);
		System.arraycopy(original, 0, copy, 0, original.length);
		return copy;
	}
	*/	
	@SuppressWarnings("unchecked")
	private <T> T[] arrayCopy(T[] original) {
		Class<?> arrayType = original.getClass().getComponentType();
		T[] copy = (T[])java.lang.reflect.Array.newInstance(arrayType, original.length);
		System.arraycopy(original, 0, copy, 0, original.length);
		return copy;
	}
	/*
	public static <T> T[] copyArray(T[] oldArray) {
	    if (oldArray.length == 0) {
	        throw new IllegalArgumentException("Array não deve ser vazio.");
	    }
	 
	    T[] newArray = (T[]) Array.newInstance(oldArray[0].getClass(), oldArray.length);
	 
	    for (int x = 0; x < oldArray.length; x++) {
	        newArray[x] = oldArray[x];
	    }
	 
	    return newArray;
	}
*/
	public static <T> T[] copyArray(final List<T> obj) {
	    if (obj == null || obj.isEmpty()) {
	        return null;
	    }
	    final T t = obj.get(0);
	    final T[] res = (T[]) Array.newInstance(t.getClass(), obj.size());
	    for (int i = 0; i < obj.size(); i++) {
	        res[i] = obj.get(i);
	    }
	    return res;
	}
	
	
	public void startGame() {
		jogo = new Tabuleiro();// cria o objeto do tipo Tabuleiro
		jogo.setColumns(10);// define a qtdade de colunas
		jogo.setRows(10);// define a qtdade de linhas
		view = new ConsoleView();// cria o objeto do tipo ConsoleView
		jogador = new Jogador();// cria o objeto do tipo Jogador

		fillMatrixes();// inicializa a matriz com os pontos
		assortShips();// distribui as embarcacoes
	}

	public void assortShips() {
		
		/*
		 * 1 porta-avioes com 5 unidades de tamanho.
		 * 2 destroyers com 4 unidades de tamanho.
		 * 2 fragatas com 3 unidades de tamanho.
		 * 3 torpedeiros com 2 unidades de tamanho.
		 * 5 submarinos, com 1 unidade de tamanho.
		 */

		insertAirCraftCarrier(vetorPortaAvioes,5);	
		//insertDestroyer(vetorDestroyers,4);
		//insertFrigate(vetorFragatas,3);
		//insertTorpedoBoat(vetorTorpedeiros,2);
		//insertSubmarine(vetorSubmarinos,1);
		
	}

	public void insertAirCraftCarrier(PortaAvioes[] vetor, int tamanho) {
		String orientacao;
		int x, y;
		
		for(int i=0;i<vetor.length;i++){
			vetor[i] = new PortaAvioes();
			// define o tamanho do submarino
			vetor[i].setTamanho(tamanho);
			
			// recebe a posicao xy e orientacao do metodo recognitionMission
			String localizacao = recognitionMission(vetor[i].getTamanho());
			
			// separa cada item de localizacao
			x = returnIntegerXY(localizacao, 'x');// separa a parte x
			y = returnIntegerXY(localizacao, 'y');// separa a parte y
			orientacao = localizacao.substring(2);// separa a parte v/h
			
			// define a orientacao da embarcacao
			vetor[i].setOrientacao(orientacao);

			// define a posicao da embarcacao
			vetor[i].setPosicaoPopa(x, y);

			// define o dano inicial da embarcacao
			vetor[i].setDano(0);
			
			// insere a embarcacao no tabuleiro
			insertShip( x,  y,  orientacao,  vetor[i].getTamanho());			
		}
		
	}//fim do metodo insertAirCraftCarrier
	
	public void insertDestroyer(Destroyer[] vetor, int tamanho) {
		String orientacao;
		int x, y;
		
		for(int i=0;i<vetor.length;i++){
			vetor[i] = new Destroyer();
			// define o tamanho do submarino
			vetor[i].setTamanho(tamanho);
			
			// recebe a posicao xy e orientacao do metodo recognitionMission
			String localizacao = recognitionMission(vetor[i].getTamanho());
			
			// separa cada item de localizacao
			x = returnIntegerXY(localizacao, 'x');// separa a parte x
			y = returnIntegerXY(localizacao, 'y');// separa a parte y
			orientacao = localizacao.substring(2);// separa a parte v/h
			
			// define a orientacao da embarcacao
			vetor[i].setOrientacao(orientacao);

			// define a posicao da embarcacao
			vetor[i].setPosicaoPopa(x, y);

			// define o dano inicial da embarcacao
			vetor[i].setDano(0);
			
			// insere a embarcacao no tabuleiro
			insertShip( x,  y,  orientacao,  vetor[i].getTamanho());			
		}
		
	}//fim do metodo insertDestroyer
	
	public void insertFrigate(Fragata[] vetor, int tamanho) {
		String orientacao;
		int x, y;
		
		for(int i=0;i<vetor.length;i++){
			vetor[i] = new Fragata();
			// define o tamanho do submarino
			vetor[i].setTamanho(tamanho);
			
			// recebe a posicao xy e orientacao do metodo recognitionMission
			String localizacao = recognitionMission(vetor[i].getTamanho());
			
			// separa cada item de localizacao
			x = returnIntegerXY(localizacao, 'x');// separa a parte x
			y = returnIntegerXY(localizacao, 'y');// separa a parte y
			orientacao = localizacao.substring(2);// separa a parte v/h
			
			// define a orientacao da embarcacao
			vetor[i].setOrientacao(orientacao);

			// define a posicao da embarcacao
			vetor[i].setPosicaoPopa(x, y);

			// define o dano inicial da embarcacao
			vetor[i].setDano(0);
			
			// insere a embarcacao no tabuleiro
			insertShip( x,  y,  orientacao,  vetor[i].getTamanho());			
		}
	}//fim do metodo insertFrigate

	public void insertTorpedoBoat(Torpedeiro[] vetor, int tamanho) {
		String orientacao;
		int x, y;
		
		for(int i=0;i<vetor.length;i++){
			vetor[i] = new Torpedeiro();
			// define o tamanho do submarino
			vetor[i].setTamanho(tamanho);
			
			// recebe a posicao xy e orientacao do metodo recognitionMission
			String localizacao = recognitionMission(vetor[i].getTamanho());
			
			// separa cada item de localizacao
			x = returnIntegerXY(localizacao, 'x');// separa a parte x
			y = returnIntegerXY(localizacao, 'y');// separa a parte y
			orientacao = localizacao.substring(2);// separa a parte v/h
			
			// define a orientacao da embarcacao
			vetor[i].setOrientacao(orientacao);

			// define a posicao da embarcacao
			vetor[i].setPosicaoPopa(x, y);

			// define o dano inicial da embarcacao
			vetor[i].setDano(0);
			
			// insere a embarcacao no tabuleiro
			insertShip( x,  y,  orientacao,  vetor[i].getTamanho());			
		}
	}//fim do metodo insertTorpedoBoat

	public void insertSubmarine(Submarino[] vetor, int tamanho) {
		String orientacao;
		int x, y;
		
		for(int i=0;i<vetor.length;i++){
			vetor[i] = new Submarino();
			// define o tamanho do submarino
			vetor[i].setTamanho(tamanho);
			
			// recebe a posicao xy e orientacao do metodo recognitionMission
			String localizacao = recognitionMission(vetor[i].getTamanho());
			
			// separa cada item de localizacao
			x = returnIntegerXY(localizacao, 'x');// separa a parte x
			y = returnIntegerXY(localizacao, 'y');// separa a parte y
			orientacao = localizacao.substring(2);// separa a parte v/h
			
			// define a orientacao da embarcacao
			vetor[i].setOrientacao(orientacao);

			// define a posicao da embarcacao
			vetor[i].setPosicaoPopa(x, y);

			// define o dano inicial da embarcacao
			vetor[i].setDano(0);
			
			// insere a embarcacao no tabuleiro
			insertShip( x,  y,  orientacao,  vetor[i].getTamanho());			
		}
		
	}//fim do metodo insertSubmarine

	public void insertShip(int x, int y, String orientacao, int tamanhoEmbarc){
		
		for(int i=0;i<tamanhoEmbarc;i++){
			if(orientacao.equals("h"))
			matriz[x][y+i] = "0";
			else
				matriz[x+i][y] = "0";
		}
	}
	
	public String recognitionMission(int tamanhoEmbarc) {
		String orientacao;
		String xyz;// linha, coluna, orientacao

		int x, y, orientacaoInt;
		int iFor;
		int limiteTabuleiro;// para evitar colocar embarcacoes para fora do tabuleiro
		boolean ocupado = true;

		do {
			// gera randomicamente a orientacao v/h
			orientacaoInt = generateRandomPosition();
			
			if (orientacaoInt > 0) {
				orientacao = "v";
			} else {
				orientacao = "h";
			}

			// gera randomicamente a possivel posicao
			x = generateRandomLocation();
			y = generateRandomLocation();

			// prepara os limites para uso do for
			if (orientacao.equals("v")) {
				iFor = x;// usa o valor da linha por se posicionar ao longo da mesma
				limiteTabuleiro = jogo.getRows();
			} else {
				iFor = y;// usa o valor da coluna por se posicionar ao longo da  mesma
				limiteTabuleiro = jogo.getColumns();
			}

			// se o limite menos a posicao for maior que o tamanho da
			// embarcacao, nao ha espaco suficiente
			if ((limiteTabuleiro - iFor) < tamanhoEmbarc) {
				ocupado = true;
				/*
				System.out.println("Nao cabia aqui!");
				System.out.println("Limite do tabuleiro: " + limiteTabuleiro);
				System.out.println("Orientacao: " + orientacao);
				System.out.println("iFor: " + iFor);
				System.out.println("Posicao XY: " + Integer.toString(x) +Integer.toString(y));
				System.out.println("Tamanho da embarcacao: " + tamanhoEmbarc);
				*/
			} else {
				//define ocupacao falsa, caso nao encontre ocupacao se mantem assim
				ocupado = false;
				// executa o for para testar posicoes ocupadas
				for (int i = iFor; i < tamanhoEmbarc; i++) {
					// verifica se a posicao esta ocupada
					if (matriz[x][y].equals("0")) {
						ocupado = true;
						i = tamanhoEmbarc;//forca a saida do for ao encontrar um espaco ocupado
					}
				}
			}//fim do else onde ha espaco suficiente
		} while (ocupado);
		
		xyz = Integer.toString(x) +Integer.toString(y) + orientacao;
		return xyz;
	}

	public int generateRandomPosition() {// randomiza a posicao 0=v , 1=h
		Random gerador = new Random();
		int posicao = gerador.nextInt(2);

		return posicao;
	}

	public int generateRandomLocation() {// randomiza as coordenadas xy
		Random gerador = new Random();
		int localizacao = gerador.nextInt(10);
		return localizacao;
	}

	public void fillMatrixes() {
		for (int x = 0; x < matriz.length; x++)
			for (int y = 0; y < matriz[x].length; y++){
				matriz[x][y] = ".";
				matrizMascara[x][y] = ".";
			}
	}

	public void printHeaders() {
		view.cabecalhoColunas(jogo.getColumns());
		view.cabecalhoLinhas(jogo.getRows(), jogo.getColumns());
	}

	public void printMatrix() {
		view.cabecalhoColunas(jogo.getColumns());
		// view.cabecalhoLinhas(jogo.getRows(),jogo.getColumns());//imprimir linha falsa, apenas para teste
		view.printMatrix(matriz, jogo.getRows(), jogo.getColumns());
	}
	
	public void printMaskMatrix() {
		view.cabecalhoColunas(jogo.getColumns());
		view.printMaskMatrix(matrizMascara, jogo.getRows(), jogo.getColumns());
	}
	
	public boolean damageConfirmation(int x, int y){
		boolean confirmed=false;	
		
		if (matriz[x][y].equals("0")) 
				confirmed = true;
		
		return confirmed;
		}


	public void damageReport(int x, int y){
		// buscar entre as embarcacoes alguma que esteja na posicao xy
				
		int contaVetores=5;// tipos de embarcacoes
		int tamanhoVetor;// quantidade de embarcacoes do tipo
		int tamanhoEmbarcacao;// tamanho dasa embarcacoes do tipo
		int posX, posY;//, intX=0, intY=0;;// 
		
		String orientacao;// orientacao V/H
	
		System.out.println("Engine Room, damage report!");
		
		for(int i=1;i<contaVetores;i++){// para cada i percorre um tipo de vetor
		
			
			if(Integer.compare(i, 1) == 0){// se e do tipo PortaAvioes
				tamanhoVetor = vetorPortaAvioes.length;	// recebe a quantidade de embarcacoes do tipo
				PortaAvioes[] vetor;// cria o atributo vetor do tipo da embarcacao testada
				vetor = new PortaAvioes[1];// instancia o vetor a receber as copias para testar
				vetor[i] = vetorPortaAvioes[i];// copia o conteudo do vetor
				System.out.println("Oba, acertei um Porta Avioes!!!"); // mensagem para teste
		/*	}else
			if(Integer.compare(i, 2) == 0){// se e do tipo Destroyer
				tamanhoVetor = vetorDestroyers.length;
				Destroyer[] vetor;
				vetor = new Destroyer[1];
				vetor[i] = vetorDestroyers[i];
				System.out.println("Oba, acertei um Destroyer!!!");
			}
			*/
			
			for(int j=0;j<tamanhoVetor;j++){// percorre todo o vetor do tipo
				if(vetorPortaAvioes[j].getDano()==vetorPortaAvioes[j].getTamanho())// se ja foi afundado
					
					//System.out.println("Esse já foi pra conta!");
					
					j=tamanhoVetor;// faz sair da leitura desta instancia da embarcacao 
				else{
					System.out.println("Ainda nao foi afundado!");
				// recebe a orientacao e tamanho pra calcular as partes da embarcacao
				orientacao = vetorPortaAvioes[j].getOrientacao();
				tamanhoEmbarcacao =  vetorPortaAvioes[j].getTamanho();
				
				//recebe separadamente as coordenada X e Y
				posX = vetorPortaAvioes[j].getPosicaoPopa()[0];
				posY = vetorPortaAvioes[j].getPosicaoPopa()[1];
				
				for(int k=0; k<tamanhoEmbarcacao; k++){// testa cada uma das partes
					//intX e intY sao as coordenadas do tiro recebido
					if(orientacao.equals("v")){// se esta na vertical
						// somado k na posicao X para percorrer as casas na vertical
						if( (posX+k==x) && (posY==y) ){
							vetorPortaAvioes[j].setDano(vetorPortaAvioes[j].getDano()+1);//incrementa o dano
							k=tamanhoEmbarcacao;// faz sair do teste das partes
							//return algo; //caso seja um metodo com retorno
						}// fim do teste se tiro acertou
					}//fim do if teste vertical
					
					else{// senao a embarcacao esta na horizontal
						
						// somado k na posicao Y para percorrer as casas na horizontal
						if( (posX==x) && (posY+k==y) ){
							vetorPortaAvioes[j].setDano(vetorPortaAvioes[j].getDano()+1);//incrementa o dano
							k=tamanhoEmbarcacao;// faz sair do teste das partes
							//return algo; //caso seja um metodo com retorno
					}// fim do teste se tiro acertou
				}//fim do else horizontal
			}//fim do teste das partes
				//verifica se apos computar dano a embarcacao foi afundada acrescenta + 2 pontos ao jogador
				if(vetorPortaAvioes[j].getDano()==vetorPortaAvioes[j].getTamanho())
				jogador.setPontos(jogador.getPontos()+2);
		}//fim do else de embarcacao ainda nao afundada
	}// fim do percorredor de vetor por tipo	
	
			}//fim do testador vetor tipo 1 - portaAvioes
		}//fim do testador de todos os vetores		

		// devolve a posicao, insere o dano ou chama algum metodo que insira
	}
	
	public void updateMaskMatrix(int x, int y, boolean acerto){
		
		if(acerto)		
			matrizMascara[x][y]="O";
		else
			matrizMascara[x][y]="-";
	}
	
	/*
	 * Metodo returnIntegerXY:		Retorna, em formato inteiro a coordenada X ou Y.
	 * 
	 * @param	parXy	uma string contendo o par de coordenadas
	 * @param	parte	um char com dois valores possiveis(x/y)
	 * @return	int		retorna a coordenada (x/y) em formato inteiro  
	 */
	
	public int returnIntegerXY(String parXY, char parte){
		int inicio, coordenada;
		
		if(parte=='x' )
			inicio=0;
		else
			inicio = 1;
		
		coordenada = Integer.parseInt(parXY.substring(inicio,inicio+1));
		return coordenada;
	}
	
	/*
	 * Metodo returnStringXY:		Retorna, em formato String a coordenada X ou Y.
	 * 
	 * @param	parXy	uma string contendo o par de coordenadas
	 * @param	parte	um char com dois valores possiveis(x/y)
	 * @return	int		retorna a coordenada (x/y) em formato String  
	 */
	public String returnStringXY(String parXY, char parte){
		int inicio;
		String coordenada;
		
		if(parte=='x' )
			inicio=0;
		else
			inicio = 1;
		
		coordenada = parXY.substring(inicio,inicio+1);
		return coordenada;
	}
	
	public void play() {
		String jogada,x,y;
		int intX=0, intY=0;
		boolean acertou;
		
		if(jogador.getNome().equals("johnDoe"))
		jogador.setNome(view.read("Nome"));
		
		jogada = view.read("Jogada (linha/coluna) ");
		
		// embuxa jogada para evitar vazio
		if (jogada.equals(""))
			jogada="00";
		
		// x recebe a posicao X da jogada recebida
		x = returnStringXY(jogada,'x');
		
		// y recebe a posicao Y do metodo getJogada
		y = returnStringXY(jogada,'y');
		
		if((Integer.parseInt(x)<=jogo.getRows()) && y.matches("[a-jA-J]")  ){
		
		// recebe o valor inteiro da posicao X da jogada
		intX = returnIntegerXY(jogada,'x');
		// recebe a letra (posicao Y) da jogada, busca o indice numerico da mesma
		intY = view.getIndex(y);
		
		// recebe a posicao Y numerica e transforma em string para passar pro metodo damageConfirmation
		y = Integer.toString(intY);
		
		//fazer um array qualquer para armazenar as jogadas e caso nao tenha sido feita segue para a verificacao
		//isso evita pontuar uma área já atingida
		char[] jogadas = new char[100];
		int pontoDoTabuleiro =  Integer.parseInt(x.concat(y));
		if (jogadas[pontoDoTabuleiro].equals("x")){
			System.out.println("Essa jogada já foi feita!");
		}else{
		
		//armazena a situacao do tiro e faz atualizacoes
		acertou = damageConfirmation(intX, intY);
		if (acertou){
			/*
			 * modificar aqui para:
			 * 1 - informar que acertou
			 * 2 - chamar um metodo que verifique que embarcacao se encontra naquela posicao
			 * 3 - inserir o dano para aquela embarcacao
			 * 4 - verificar se a embarcacao foi destruida (dano=tamanho)
			 * 5 - armazenar pontos do jogador
			 * 6 - informar pontos do jogador
			 * 7 - atualizar a matrizMascara
			 */
			
			// 1 - informa que acertou
			System.out.println("Tiro acertou uma embarcacao!");
			
			// 2 - chamar um metodo que verifique que embarcacao se encontra naquela posicao	
			// 3 - insere o dano na embarcacao
			// 4 - verificar se a embarcacao foi destruida (dano=tamanho)
			damageReport(intX, intY);
	
			System.out.println("Danos na embarcacao: " + vetorPortaAvioes[0].getDano());
			
			// armazena os pontos (por enquanto nao computa destruicao - 5 pontos
			jogador.setPontos(jogador.getPontos()+3);
			
			// informa os pontos do jogador
			System.out.println("Pontos do jogador " + jogador.getNome() + ": " + jogador.getPontos());
			
			// insere o dano na matrizMascara
			updateMaskMatrix(intX,intY, acertou);
			
		}//fim do "se acertou"
		else{
			System.out.println("Tiro acertou apenas agua!");
			//decrementa os pontos (por enquanto nao computa destruicao - 5 pontos
			jogador.setPontos(jogador.getPontos()-1);
			//informa os pontos do jogador
			System.out.println("Pontos do jogador " + jogador.getNome() + ": " + jogador.getPontos());
			//insere o erro na matrizMascara
			updateMaskMatrix(intX,intY, acertou);
		}
		
	}else{
		System.out.println("Jogada invalida! formato aceito: numero(linha)/letra(coluna), Ex.: 1a ");
	}
		//fim do if de validacao da jogada
		
	}//fim do metodo play
	
	/*
	public void damageReport(int x, int y){
		// buscar entre as embarcacoes alguma que esteja na posicao xy
				
		int contaVetores=5;// tipos de embarcacoes
		int tamanhoVetor;// quantidade de embarcacoes do tipo
		int tamanhoEmbarcacao;// tamanho dasa embarcacoes do tipo
		int posX, posY;//, intX=0, intY=0;;// 
		
		String orientacao;// orientacao V/H
	
		System.out.println("Engine Room, damage report!");
		
		for(int i=0;i<contaVetores;i++){
			
			PortaAvioes[] vetor;
			
			if(Integer.compare(i, 1) == 0){// se e do tipo portaAvioes
				tamanhoVetor = vetorPortaAvioes.length;	
				vetor = new PortaAvioes[1];
				vetor[i] = vetorPortaAvioes[i];
				System.out.println("Oba, carquei um Porta Avioes!!!");
				
			for(int j=0;j<tamanhoVetor;j++){// percorre todo o vetor do tipo
				if(vetorPortaAvioes[j].getDano()==vetorPortaAvioes[j].getTamanho())// se ja foi afundado
					
					//System.out.println("Esse já foi pra conta!");
					
					j=tamanhoVetor;// faz sair da leitura desta instancia da embarcacao 
				else{
					System.out.println("Ainda nao foi afundado!");
				// recebe a orientacao e tamanho pra calcular as partes da embarcacao
				orientacao = vetorPortaAvioes[j].getOrientacao();
				tamanhoEmbarcacao =  vetorPortaAvioes[j].getTamanho();
				
				//recebe separadamente as coordenada X e Y
				posX = vetorPortaAvioes[j].getPosicaoPopa()[0];
				posY = vetorPortaAvioes[j].getPosicaoPopa()[1];
				
				for(int k=0; k<tamanhoEmbarcacao; k++){// testa cada uma das partes
					//intX e intY sao as coordenadas do tiro recebido
					if(orientacao.equals("v")){// se esta na vertical
						// somado k na posicao X para percorrer as casas na vertical
						if( (posX+k==x) && (posY==y) ){
							vetorPortaAvioes[j].setDano(vetorPortaAvioes[j].getDano()+1);//incrementa o dano
							k=tamanhoEmbarcacao;// faz sair do teste das partes
							//return algo; //caso seja um metodo com retorno
						}// fim do teste se tiro acertou
					}//fim do if teste vertical
					
					else{// senao a embarcacao esta na horizontal
						
						// somado k na posicao Y para percorrer as casas na horizontal
						if( (posX==x) && (posY+k==y) ){
							vetorPortaAvioes[j].setDano(vetorPortaAvioes[j].getDano()+1);//incrementa o dano
							k=tamanhoEmbarcacao;// faz sair do teste das partes
							//return algo; //caso seja um metodo com retorno
					}// fim do teste se tiro acertou
				}//fim do else horizontal
			}//fim do teste das partes
				//verifica se apos computar dano a embarcacao foi afundada acrescenta + 2 pontos ao jogador
				if(vetorPortaAvioes[j].getDano()==vetorPortaAvioes[j].getTamanho())
				jogador.setPontos(jogador.getPontos()+2);
		}//fim do else de embarcacao ainda nao afundada
	}// fim do percorredor de vetor por tipo	
	
			}//fim do testador vetor tipo 1 - portaAvioes
		}//fim do testador de todos os vetores		

		// devolve a posicao, insere o dano ou chama algum metodo que insira
	}
	*/
	
}//fim da classe TabuleiroController
