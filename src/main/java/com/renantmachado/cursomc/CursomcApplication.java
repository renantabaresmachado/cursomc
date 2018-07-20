package com.renantmachado.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.renantmachado.cursomc.domain.Categoria;
import com.renantmachado.cursomc.domain.Cidade;
import com.renantmachado.cursomc.domain.Cliente;
import com.renantmachado.cursomc.domain.Endereco;
import com.renantmachado.cursomc.domain.Estado;
import com.renantmachado.cursomc.domain.Produto;
import com.renantmachado.cursomc.domain.enums.TipoCliente;
import com.renantmachado.cursomc.repositories.CategoriaRepository;
import com.renantmachado.cursomc.repositories.CidadeRepository;
import com.renantmachado.cursomc.repositories.ClienteRepository;
import com.renantmachado.cursomc.repositories.EnderecoRepository;
import com.renantmachado.cursomc.repositories.EstadoRepository;
import com.renantmachado.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepositiry;
	@Autowired
	private CidadeRepository cidadeRepositoy;
	@Autowired
	private EnderecoRepository enderecoRepositoy;
	@Autowired
	private ClienteRepository clienteRepositoy;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2)); 
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Ublerlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		estadoRepositiry.saveAll(Arrays.asList(est1, est2));
		cidadeRepositoy.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cl1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cl1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apto203", "Jardim", "38220834", cl1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "sala 800", "centro", "38777012", cl1, c2);
		
		cl1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		clienteRepositoy.saveAll(Arrays.asList(cl1));
		enderecoRepositoy.saveAll(Arrays.asList(e1, e2));
		
		
	}
}
