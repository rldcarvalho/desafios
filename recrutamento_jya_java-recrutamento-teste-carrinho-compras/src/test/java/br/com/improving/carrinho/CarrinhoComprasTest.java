package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarrinhoComprasTest {

	Produto produto1 = new Produto(1L, "Celular");
	Produto produto2 = new Produto(2L, "Notebook");
	Produto produto3 = new Produto(3L, "Tv");
	Produto produto4 = new Produto(4L, "Geladeira");
	Produto produto5 = new Produto(5L, "Fogão");

	Item item1 = new Item(produto1, BigDecimal.valueOf(2500), 3);
	Item item2 = new Item(produto2, BigDecimal.valueOf(4500), 1);
	Item item3 = new Item(produto3, BigDecimal.valueOf(1999), 5);
	Item item4 = new Item(produto4, BigDecimal.valueOf(2499.90), 2);
	Item item5 = new Item(produto5, BigDecimal.valueOf(700), 3);
	Item item5Corrigido = new Item(produto5, BigDecimal.valueOf(800), 4);

	List<Item> listaItem1 = new ArrayList<>(Arrays.asList(item1, item2));
	List<Item> listaRespostaTeste1 = new ArrayList<>(Arrays.asList(item1, item2, item3));
	List<Item> listaItem2 = new ArrayList<>(Arrays.asList(item4, item5));
	List<Item> listaRespostaTeste2 = new ArrayList<>(Arrays.asList(item4, item5Corrigido));

	CarrinhoCompras carrinho1 = new CarrinhoCompras("João", listaItem1);
	CarrinhoCompras carrinho2 = new CarrinhoCompras("Maria", listaItem2);

	int totalCarrinho1 = 12000;
	double totalCarrinho2 = 7099.8;

	@Test
	@Order(1)
	void deveriaAdicionarUmItemNovoAUmCarrinhoDeComprasExistente() {
		carrinho1.adicionarItem(produto3, BigDecimal.valueOf(1999), 5);
		assertEquals(listaRespostaTeste1, carrinho1.getItens());
	}

	@Test
	@Order(2)
	void deveriaAtualizarUmItemAoInseriloNovamenteAoCarrinho(){
		carrinho2.adicionarItem(produto5, BigDecimal.valueOf(800), 1);
		assertEquals(listaRespostaTeste2, carrinho2.getItens());
	}

	@Test
	@Order(3)
	void deveriaRetornarTrueAoRemoverItemDoCarrinhoPorProdutoCorretamente(){
		carrinho1.adicionarItem(produto4, BigDecimal.valueOf(500), 1);
		assertTrue(carrinho1.removerItem(produto4));
	}

	@Test
	@Order(4)
	void deveriaRetornarTrueAoRemoverItemDoCarrinhoPorIndiceCorretamente(){
		carrinho1.adicionarItem(produto4, BigDecimal.valueOf(500), 1);
		assertTrue(carrinho1.removerItem(2));
	}

	@Test
	@Order(5)
	void deveriaRetornarFalseAoRemoverItemInexistenteDoCarrinho(){
		assertFalse(carrinho1.removerItem(3));
		assertFalse(carrinho1.removerItem(produto4));
	}

	@Test
	@Order(6)
	void deveriaRetornarOValorTotalDoCarrinho(){
		assertEquals(BigDecimal.valueOf(totalCarrinho1), carrinho1.getValorTotal());
		assertEquals(BigDecimal.valueOf(totalCarrinho2), carrinho2.getValorTotal());

	}

	@Test
	@Order(7)
	void deveriaRetornarAListaDeItensNoCarrinho(){
		assertEquals(listaItem1, carrinho1.getItens());
		assertEquals(listaItem2, carrinho2.getItens());
	}


}