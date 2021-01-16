package br.com.litosolucoes.appsodre.service;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.springframework.stereotype.Service;

import br.com.litosolucoes.appsodre.dto.BalcaoDTO;
import br.com.litosolucoes.appsodre.util.HibernateUtil;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

@Service
public class Auxiliar {
	
	public static Connection getConnectionX() throws SQLException{
		try {
		Class.forName("org.postgresql.Driver"); //driver para h2 db
		return DriverManager.getConnection("jdbc:postgresql://192.168.37.136:5432/postgres","postgres","unisenha"); //retorna conexao h2 db
		}catch (ClassNotFoundException e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
		throw new SQLException();
		}
	}
	
	public byte[] gerarLancamento() throws Exception {
	
		List<BalcaoDTO> dados = Arrays.asList(new BalcaoDTO("Pizza", "Mussarela",new BigDecimal(35.0)), new BalcaoDTO("Bebida", "Coca Cola",new BigDecimal(5.50)));
		
		InputStream input = this.getClass().getResourceAsStream("/relatorios/lancamento-balcao.jasper");
		final Map<String, Object> parametros = new HashMap<>();
//		parametros.put("REPORT_LOCALE", new Locale("pt", "BR"));
		
		
		//Connection conexao = getConnectionX();
//		final JasperPrint fillReport = JasperFillManager.fillReport(input, parametros, conexao);
		JasperPrint fillReport = JasperFillManager.fillReport(input, null, new JRBeanCollectionDataSource(dados));
		//JasperPrintManager.printReport(fillReport, true);
		JasperViewer.viewReport(fillReport, false);
//		JasperViewer.viewReport(fillReport, true);
	JasperPrintManager.printReport(fillReport, true);
		return JasperExportManager.exportReportToPdf(fillReport);
		
	}

	public void imprimir() throws Exception {

		try {
			
			InputStream jasperFile = getClass().getResourceAsStream("/reports/Cherry.jasper");
			//final String caminho = Faces.getRealPath("/reports/pedido_delivery.jasper");
			String string = jasperFile.toString();
			final Map<String, Object> parametros = new HashMap<>();
//			final Connection conexao = HibernateUtil.getConexao();
//			final JasperPrint fillReport = JasperFillManager.fillReport(string, parametros, conexao);
			 JasperReport report = JasperCompileManager.compileReport(loadTemplate());
			 final JasperPrint fillReport = JasperFillManager.fillReport(report, parametros, new JREmptyDataSource());
			JasperPrintManager.printReport(fillReport, true);
		} catch (final JRException e) {
			throw new Exception("");
		}
		
		
		
		
		
		

	}
	
	public void imprimir2() throws Exception {

		InputStream input = this.getClass().getResourceAsStream("/relatorios/teste.jasper");
		final Map<String, Object> parametros = new HashMap<>();
		Connection conexao = getConnectionX();
		JasperPrint fillReport = JasperFillManager.fillReport(input, parametros ,conexao);
		//JasperViewer.viewReport(fillReport, false);
		JasperPrintManager.printReport(fillReport, true);
		

	}
	
	public JasperDesign loadTemplate () throws Exception {
        try {
        	String path = "c:/opt/jetty/webapps/configs/yitoa/template/jasper/itens_sem_coleta_template.jrxml";
        	InputStream input = getClass().getResourceAsStream(path);
            return JRXmlLoader.load(input);
        } catch (JRException e) {
            throw new Exception("Ocorreu um erro ao carregar o template: " + " ::: " + e.getMessage());
        }
    }
}
