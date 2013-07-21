package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.TextEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class AboutDialog extends JDialog{

	public AboutDialog(){
		super();
		this.setTitle("Sobre");
		this.setSize(300, 150);
		this.setResizable(false);
		this.setLayout(new FlowLayout());       
		this.setLocationRelativeTo(null);

		this.initTextArea();
	}

	private void initTextArea() {
		String about = 
				"Programa Desenvolvido na Disciplina\n" +
				"Introdução à Compiladores" +
				" (INE5622) do \n" +
				"Curso de Sistemas de Informação da \n" +
				"Universidade Federal de Santa Catarina.\n\n" +
				"Autores: Camila Maia e Maicon Lima.\n" +
				"Orientação: Olinto Furtado.";
		
		JTextArea textArea = new JTextArea(about);
		textArea.setSize(270,150);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		this.add(textArea);		
	}



}
