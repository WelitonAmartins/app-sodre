package br.com.litosolucoes.appsodre.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.litosolucoes.appsodre.dto.PedidoBolcaoDTO;
import br.com.litosolucoes.appsodre.entity.PedidoBalcao;
import br.com.litosolucoes.appsodre.entity.Produto;
import br.com.litosolucoes.appsodre.repository.PedidoBalcaoRepository;

@Service
public class PedidoBalcaoService {
	
	@Autowired
	private PedidoBalcaoRepository pedidoBalcaoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private RelatorioService relatorioService;
	
	public PedidoBalcao salvarPedidoBalcao(PedidoBolcaoDTO param) throws Exception {
		
		List<Produto> listaProduto = new ArrayList<>();
			for (Integer produto : param.getCodProduto()) {
				Optional<Produto> idProduto = this.produtoService.bucarPorId(produto);
				
				if(idProduto.isPresent()) {
					listaProduto.add(idProduto.get());
			}
		}
		
		PedidoBalcao pb = new PedidoBalcao();
		
		pb.setNome(param.getNome());
		pb.setFlMesa(param.getFlMesa());
		pb.setDtPedido(LocalDateTime.now());
		pb.setListaProdutos(listaProduto);
		
		this.pedidoBalcaoRepository.save(pb);
		//this.relatorioService.carregarTemplateBalcao(pb.getCodigo());
		
		return pb;
		
		
		
	}
	
	
	public List<PedidoBalcao> listar() {
		return this.pedidoBalcaoRepository.findAll();
	}
	
	public Optional<PedidoBalcao> bucarPorId(Integer id) {
		return this.pedidoBalcaoRepository.findById(id);
	}


	public PedidoBalcao buscarRelatorioId(Integer codigo) throws Exception {
		Optional<PedidoBalcao> pbId = this.bucarPorId(codigo);
		if(!pbId.isPresent()) {
			throw new Exception("id nulo");
		}
		this.relatorioService.carregarTemplateBalcao(pbId.get().getCodigo());
		return pbId.get();
	}
	
	

}
