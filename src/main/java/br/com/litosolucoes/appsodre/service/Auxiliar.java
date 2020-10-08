package br.com.litosolucoes.appsodre.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.litosolucoes.appsodre.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;

@Service
public class Auxiliar {

	public void imprimir() throws Exception {

		try {

			final Map<String, Object> parametros = new HashMap<>();
			final String caminho = ";";
			final Connection conexao = HibernateUtil.getConexao();
			final JasperPrint fillReport = JasperFillManager.fillReport(caminho, parametros, conexao);

			JasperPrintManager.printReport(fillReport, true);
		} catch (final JRException e) {
			throw new Exception("");
		}

	}
}
