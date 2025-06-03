package PacotePrimario;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;	// Importa eventos de ações, como cliques de botões.
import java.awt.event.ActionListener;	// Interface para capturar eventos de ação.
import javax.swing.JButton;	// Importa a biblioteca Swing para criar a interface gráfica.
import javax.swing.JFrame;	// Importa a biblioteca Swing para criar a interface gráfica.
import javax.swing.JPanel;	// Importa a biblioteca Swing para criar a interface gráfica.
import javax.swing.JTextField;	// Importa a biblioteca Swing para criar a interface gráfica.

 

public class Calculadora extends JFrame implements ActionListener{

	// Componentes da interface grafica
	private JTextField tela; // Campo e texto nde os números e resultados são exibidos *************
	private JButton[] numeros = new JButton[10]; // Array de botôes para números (0-9)
	private JButton[] funcoes = new JButton[8];	// Array de botôes para as funões(+,-,*,/, etc)
	private JButton add,sub,mul,div,dec,igual,del,clr;	//botôes especificos para opeções de controles
	private JPanel painel;	// Painel para organ os botôes
	
	// Variaveis para armazenar números e o resultado das operações
	private double num1 = 0, num2 = 0, resultado = 0; // 'num1' e 'num 2' são os operandos : 'resultado' é o valor final.
	private char operador; // Variavel para armazenar o operador (+,-,*,/).
	
	// Construtor da classe (executa quando o objeto Calculadora é criado)
	public Calculadora() {
		setTitle("Calculadora"); // Define o titulo da janela
		setSize(420,550);	// Define o tamanho da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//fecha o programa quando a janela é fechada
		setLayout(null);	// Define o layout como nulo para posicionar componentes manualmente
		
		tela = new JTextField(); // Cria o campo de texto onde os números e resultados aparecerão
		tela.setBounds(50,25,300,50); // Define o tamanho e a posição da tela
		tela.setEditable(false);	// Impede que o usuario digite diretamente na tela 
		add(tela); //adiciona a tela a janela
		
		// Botôes de funções 
		add = new JButton("+");
		sub = new JButton("-");
		mul = new JButton("*");
		div = new JButton("/");
		dec = new JButton(".");
		igual = new JButton("=");
		del = new JButton("Del"); // Botão para deletar o ultimo digito
		clr = new JButton("Clear");	// Botão para limpara a tela
		
		// Funções
		funcoes[0] = add;
		funcoes[1] = sub;
		funcoes[2] = mul;
		funcoes[3] = div;
		funcoes[4] = dec;
		funcoes[5] = igual;
		funcoes[6] = del;
		funcoes[7] = clr;
		
		// Configura o estilo de cada batão de função
		for (int i = 0; i <8; i++) {
			funcoes[i].addActionListener(this);	// Define que os botôes responderão a cliques
			funcoes[i].setFont(new Font("Arial",Font.PLAIN,30));	//Define a fonte e o tamanho do texto nos botôes
			funcoes[i].setFocusable(false);	// Desativa o foco nos botôes (melhora a aparencia visual)
		}
		// Cria os botôes numéricos de 0 a 9
		for (int i = 0; i < 10; i++) { 
			numeros[i] = new JButton(String.valueOf(i)); // Cria um botão para cada número
			numeros[i].addActionListener(this);	// Define que os botôes responderão a cliques
			numeros[i].setFont(new Font("Arial", Font.PLAIN,30));	// Define a fonte e o tamanho do texto nos botôes
			numeros[i].setFocusable(false);	// Desativa o foco nos botôes
		}
		
		// Painel de controles
		painel = new JPanel();
		painel.setBounds(50,100,300,300);	// Define o tamanho e a posição do painel
		painel.setLayout(new GridLayout(4,4,10,10));	// Layout de grade com 4 linhas e espaçamento de 10px
		
		// adicionar botões ao painel
		painel.add(numeros[1]);
		painel.add(numeros[2]);
		painel.add(numeros[3]);
		painel.add(add);
		painel.add(numeros[4]);
		painel.add(numeros[5]);
		painel.add(numeros[6]);
		painel.add(sub);
		painel.add(numeros[7]);
		painel.add(numeros[8]);
		painel.add(numeros[9]);
		painel.add(mul);
		painel.add(dec);
		painel.add(numeros[0]);
		painel.add(igual);
		painel.add(div);
		
		add(painel); // Adiciona o painel à janela 
		
		// Configura os botôes "Del" (Deletar) e "Clear" (limpar).
		del.setBounds(50,430,145,50);
		clr.setBounds(205,430,145,50);
		add(del);
		add(clr);
		
		// Configura as ações para os botoes (deletar) e (limpar)
		del.addActionListener(this);
		clr.addActionListener(this);
		
		// torna a janela visivel 
		setVisible(true);
		
	}
	
	// Metódo que responde a cliques nos botôes (implementando da interface ActionListener)
	@Override
	public void actionPerformed(ActionEvent e) {
		// Lógica para quando um número é pressionando (0 - 9)
		for (int i = 0; i < 10; i++) {
			if(e.getSource() == numeros[i]) {
				tela.setText(tela.getText().concat(String.valueOf(i)));
			}
		}
		// Lógica para adicionar um ponto decimal
		if (e.getSource() == dec) {
			tela.setText(tela.getText().concat("."));
		}
		// Lógica para operações de soma
		if (e.getSource() == add) {
			num1 = Double.parseDouble(tela.getText());
			operador = '+';
			tela.setText("");
		}
		// Lógica para operações de subtração
		if (e.getSource() == sub) {
			num1 = Double.parseDouble(tela.getText());
			operador = '-';
			tela.setText("");
		}
		// Lógica para operações de multiplicação
		if (e.getSource() == mul) {
			num1 = Double.parseDouble(tela.getText());
			operador = '*';
			tela.setText("");
		}
		// Lógica para operações de divisão
		if (e.getSource() == div) {
			num1 = Double.parseDouble(tela.getText());
			operador = '/';
			tela.setText("");
		}
		// logica para calcular o resultado
		if (e.getSource() == igual) {
			num2 = Double.parseDouble(tela.getText());
			// Verifica o operador e realizada a operação apropriada
			switch (operador){
				case '+' -> resultado = num1 + num2;  
				case '-' -> resultado = num1 - num2;
				case '*' -> resultado = num1 * num2;
				case '/' -> resultado = num1 / num2;
				
			}
			tela.setText(String.valueOf(resultado)); // Exibe o resultado na tela
			num1 = resultado;	// Armazena o resultado para futuras operações
			
		}
		// lógica para limpar a tela
		if (e.getSource() == clr) {
			tela.setText(""); // Limpa a tela
		}
		
		// Lógica para deletar o último dígito
		if (e.getSource() == del) {
			String string = tela.getText(); // Pega o texto atual da tela
			tela.setText(""); // Limpa a tela
			for (int i = 0; i < string.length() - 1; i ++) {
				tela.setText(tela.getText() + string.charAt(i)); // remove o ultimo caractere
					
			}
		
		}
		
	}
	
	// Método Principal para rodar a aplicação 
	public static void main(String [] args) {
		new Calculadora(); // Cria uma instancia da classe Calculadora
	}
	
}
