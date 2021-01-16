package br.com.litosolucoes.appsodre;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppSodreApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSodreApplication.class, args);
		System.setProperty("java.awt.headless", "false");
		SwingUtilities.invokeLater(() -> {
		    JFrame f = new JFrame("myframe");
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   // f.setVisible(true);
		});
	}

}
