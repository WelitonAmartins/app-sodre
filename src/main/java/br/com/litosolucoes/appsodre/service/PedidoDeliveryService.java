package br.com.litosolucoes.appsodre.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.litosolucoes.appsodre.dto.PedidoDeliveryDTO;
import br.com.litosolucoes.appsodre.dto.ProdutoDTO;
import br.com.litosolucoes.appsodre.dto.RetornoPedidoDeliveryDTO;
import br.com.litosolucoes.appsodre.entity.Endereco;
import br.com.litosolucoes.appsodre.entity.PedidoBalcao;
import br.com.litosolucoes.appsodre.entity.PedidoDelivery;
import br.com.litosolucoes.appsodre.entity.Produto;
import br.com.litosolucoes.appsodre.repository.EnderecoRepository;
import br.com.litosolucoes.appsodre.repository.PedidoDeliveryRepository;

@Service
public class PedidoDeliveryService {

	@Autowired
	private PedidoDeliveryRepository pedidoDeliveryRepository;

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private RelatorioService relatorioService;

	public List<PedidoDelivery> listar() {
		return this.pedidoDeliveryRepository.findAll();
	}

	public Optional<PedidoDelivery> bucarPorId(Integer id) {
		return this.pedidoDeliveryRepository.findById(id);
	}

	public RetornoPedidoDeliveryDTO salvarPedidoDelivery(PedidoDeliveryDTO param) throws Exception {
		List<Produto> listaProduto = new ArrayList<>();
		for (Integer produto : param.getCodProduto()) {
			Optional<Produto> idProduto = this.produtoService.bucarPorId(produto);

			if (idProduto.isPresent()) {
				listaProduto.add(idProduto.get());
			}
		}
		
		Endereco endereco = new Endereco();
		endereco.setEndereco(param.getEndereco());
		endereco.setNumero(param.getNumero());
		endereco.setBairro(param.getBairro());
		
		if(param.getComplemento() == null) {
			endereco.setComplemento("");
		} else {
			endereco.setComplemento(param.getComplemento());

		}
		Endereco idEndereco = this.enderecoRepository.save(endereco);

		PedidoDelivery pd = new PedidoDelivery();
		pd.setNome(param.getNome());
		pd.setDtPedido(LocalDateTime.now());
		pd.setListaProdutos(listaProduto);
		pd.setEndereco(idEndereco);

		PedidoDelivery pedidoId = this.pedidoDeliveryRepository.save(pd);
		
		RetornoPedidoDeliveryDTO dto = new RetornoPedidoDeliveryDTO();
		
		dto.setNome(pedidoId.getNome());
		dto.setObservacao("");
		dto.setEndereco(pedidoId.getEndereco().getEndereco());
		dto.setBairro(pedidoId.getEndereco().getBairro());
		dto.setComplemento(pedidoId.getEndereco().getComplemento());
		dto.setNumero(pedidoId.getEndereco().getNumero());
		
		List<ProdutoDTO> lista = new ArrayList<>();
		for (Produto produto : pedidoId.getListaProdutos()) {
			ProdutoDTO produtoDTO = new ProdutoDTO();
			produtoDTO.setNome(produto.getNome());
			produtoDTO.setValor(produto.getValor());
			lista.add(produtoDTO);
		}
		dto.setProduto(lista);
		double sum = pedidoId.getListaProdutos().stream().mapToDouble(p -> p.getValor()).sum();
		dto.setTotal(sum);
		
		
	//	this.relatorioService.carregarTemplateDelivery(pd.getCodigo());
		
		return dto;
	}

	public PedidoDelivery buscarRelatorioId(Integer codigo) throws Exception {
		Optional<PedidoDelivery> pbId = this.bucarPorId(codigo);
		if(!pbId.isPresent()) {
			throw new Exception("id nulo");
		}
		this.relatorioService.carregarTemplateBalcao(pbId.get().getCodigo());
		return pbId.get();
	}
}
