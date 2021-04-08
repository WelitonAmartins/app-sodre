package br.com.litosolucoes.appsodre.service;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JasperViewer;

@Slf4j
@Service
public class RelatorioService {
	
	@Value("${banco-driver}")
	private String driver;
	
	@Value("${banco.url}")
	private static String url;
	
	@Value("${banco.login}")
	private static String login;
	
	@Value("${banco.senha}")
	private static String senha;
	
	public static Connection getConnectionX() throws SQLException{
		try {
		Class.forName("org.postgresql.Driver"); 
		return DriverManager.getConnection("jdbc:postgresql://18.212.14.212:5432/postgres","postgres","unisenha");
//		return DriverManager.getConnection("jdbc:postgresql://192.168.37.136/postgres","postgres","unisenha"); 
		}catch (ClassNotFoundException e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
		throw new SQLException();
		}

	}
	
	
	public void carregarTemplateBalcao(Integer codBalcao) throws Exception {
		InputStream input = this.getClass().getResourceAsStream("/relatorios/balcao.jasper");
		final Map<String, Object> parametros = new HashMap<>(); 
		this.imprimirRelatorio(input, parametros);
	}
	
	public void carregarTemplateDelivery(Integer codDelivery) throws Exception {
		InputStream input = this.getClass().getResourceAsStream("/relatorios/delivery.jasper");
		final Map<String, Object> parametros = new HashMap<>(); 
		parametros.put("FILTRO_DELIVERY", codDelivery);
		this.imprimirRelatorio(input, parametros);
	}
	
	public void imprimirRelatorio(InputStream input, Map<String, Object> parametros) throws Exception {
		log.info("iniciando relatorio");
		Connection conexao = getConnectionX();
		JasperPrint fillReport = JasperFillManager.fillReport(input, parametros ,conexao);
		log.info("view");
		JasperViewer.viewReport(fillReport, false);
		
		log.info("print");
		JasperPrintManager.printReport(fillReport, true);
		log.info("relatorio finalizado");
		
		

	}
}
