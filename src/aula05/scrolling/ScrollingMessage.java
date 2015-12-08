package aula05.scrolling;

/* Este applet exibe uma mensagem deslizando pela tela da direita para a esquerda */
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;

public class ScrollingMessage extends Applet 
implements Runnable { 

	Thread runner; // a thread respons�vel pela execu��o da anima��o. 
	
	private final 
	static int GO = 0, // Constantes que indicam o status da anima��o. 
	      SUSPEND = 1, 
	    TERMINATE = 2; 

	private volatile int status ; 
//	Esta vari�vel � usada para comunica��o entre
//	o applet e a thread. Seu valor � atribu�do
//	pelo applet para dizer � thread o que fazer. 

	String message = "Programa��o Gr�fica em Java  -" +
			         "  Ver�o 2007  -  IME  -  USP"; // mensagem a ser exibida
	
	int messagePosition = -1, delay = 30; 
	// Posi��o atual do extremo esquerdo da mensagem, dado como a
    // dist�ncia em pixels da borda esquerda do applet. 
	// A cada frame, � incrementada pela largura de um caracter 
	// at� que a mensagem termine de "passar" pela �rea de exibi��o do applet.
	// Ent�o � atribu�do o valor zero.   O valor inicial (-1) indica que a
	// anima��o ainda n�o come�ou. 

	Font messageFont; //	Fonte usada para exibir a mensagem.
	
	int messageHeight; // Informa��es sobre o tamanho da mensagem 
	int messageWidth;  
	int charWidth;     // e de cada caracter

	/* Vari�veis usadas para implementar double-buffering */ 
	
	Image image; 
	// A �rea para desenho off-screen  (criado e usado em update()). 

	int widthImage, heightImage; 
	// Largura e altura da �rea de desenho off-screen.
	// S�o comparadas �s dimens�es do applet para 
	// detectar qualquer mudan�a no tamanho do applet.
	// Se o tamanho do applet mudou, uma nova �rea de
	// desenho off-screen � criada. 

	public void init() { 
		setBackground(Color.white); 
		messageFont = new Font("Monospaced", Font.BOLD, 30); 
		FontMetrics fm = getFontMetrics(messageFont); 
		messageWidth = fm.stringWidth(message); 
		messageHeight = fm.getAscent(); 
		charWidth = fm.charWidth('H'); 
		
		setSize(790, 60);
	} 


	public void update(Graphics g) { 
		// Para implementar "buffer" duplo, o m�todo update() chama o
		// m�todo paint para desenhar o conte�do do applet em um canvas
		// fora da tela.   Ent�o, o canvas � copiado para tela.   Este
		// m�todo � respons�vel pela cria��o do canvas off-screen.  Ele
		// criar� um novo canvas off-screen caso o tamanho do applet mude.

		// Cria o canvas of-screen ou o renova caso o tamanho do applet mude.
		if (image == null || widthImage != getSize().width 
				          || heightImage != getSize().height) { 
 
			// (Se off-screen j� existir(mudan�a de tamanho), libera recursos de mem�ria)
			image = null; 

			image = createImage(getSize().width, getSize().height); 
			widthImage = getSize().width; 
			heightImage = getSize().height; 
		} 

		// Contexto gr�fico para desenhar fora da tela.
		Graphics graphics = image.getGraphics();  
		
		clear(graphics);
		paint(graphics);              // Desenha o conte�do em graphics 
		
		g.drawImage(image,0,0,this);  // Copia graphics para a tela 
	} 

	
	private void clear(Graphics graphics){
		graphics.setColor(getBackground()); 
		graphics.fillRect(0, 0, widthImage, heightImage); 
	}

	 public void paint(Graphics g) { // Desenha o frame atual. 	
		if (messagePosition > 0) {
			g.setColor(Color.red); 
			g.setFont(messageFont); 
			g.drawString(message, getSize().width -messagePosition, 
					         getSize().height/2 + messageHeight/2); 
		} 
	} 

	synchronized public void start() { 
		// Chamado quando o applet � iniciado (ou reiniciado).
		// Cria uma nova thread ou reinicia uma thread existente.
		status = GO; 
		
		if (runner == null || ! runner.isAlive()) { 
			// A thread ainda n�o foi criada ou foi destru�da por alguma raz�o 
			runner = new Thread(this); 
			runner.start(); } 
		else 
			notify(); 
	} 

	synchronized public void stop() { 
		// Chamado quando o applet est� parando
		// Suspende a thread 
		status = SUSPEND; 
		notify(); 
	} 

	synchronized public void destroy() { 
		// Chamado quando o applet vai ser permanetemente destru�do
		// P�ra a thread 
		status = TERMINATE; 
		notify(); 
	} 

	synchronized void nextFrame() { 
		// Calcula e exibe o pr�ximo frame da anima��o.   Chamado por run().

		messagePosition += 2;  // charWidth; 
		if (getSize().width - messagePosition+ messageWidth < 0) 
			messagePosition = 0;  // mensagem saiu da tela  
		
		repaint(); 
	}

	public void run() { 
		// O m�todo run() avan�a a imagem enquanto o valor do status for
		// GO e termina quando o valor do status se torna TERMINATE.  Se
		// o status for SUSPEND, a thread vai parar e aguardar at� que
		// o m�todo notify() seja chamado por outra thread

		while (status != TERMINATE) { 
			synchronized(this) { 

				while (status == SUSPEND) 
					waitDelay(); 
			} 
			if (status == GO){ 
				nextFrame();
				waitDelay(delay);
			}
		}
	} //	end run() 

	synchronized void waitDelay(int time) {
		// Faz uma pausa de time milisegundos ou at� que
		// o m�todo notify() seja chamado por outra thread 
		try { 
			wait(time); 
		} 
		catch (InterruptedException e) { } 
	} 

	synchronized void waitDelay() { 
		// Interrompe a thread at� que o metodo notify() 
		// seja chamado por outra thread. 
		try { 
			wait(); 
		} catch (InterruptedException e) { } 
	} 
} // fim ScrollingMessage.java 