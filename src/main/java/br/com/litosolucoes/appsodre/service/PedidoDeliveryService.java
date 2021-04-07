package br.com.litosolucoes.appsodre.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.litosolucoes.appsodre.dto.PedidoDeliveryDTO;
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

	public PedidoDelivery salvarPedidoDelivery(PedidoDeliveryDTO param) throws Exception {
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

		this.pedidoDeliveryRepository.save(pd);
		this.relatorioService.carregarTemplateDelivery(pd.getCodigo());
		return pd;
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
