package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;

    /**
     * Construtor da classe Item.
     * 
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
	public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
		this.produto = produto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}

	public Item(Produto produto) {
		this.produto = produto;
	}

	/**
     * Retorna o produto.
     *
     * @return Produto
     */
	public Produto getProduto() {
		return produto;
	}

	/**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}


	/**
     * Retorna a quantidade dos item.
     *
     * @return int
     */
	public int getQuantidade() {
		return quantidade;
	}

	/**
     * Retorna o valor total do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {
		return valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

	public void atualizaItem(Item novoItem){

		this.quantidade += novoItem.quantidade;
		if (!Objects.equals(this.valorUnitario, novoItem.valorUnitario))
			this.valorUnitario = novoItem.valorUnitario;

	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Item item = (Item) o;
		return getProduto().equals(item.getProduto());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getProduto());
	}

	@Override
	public String toString() {
		return "Item{" +
				"produto=" + produto +
				", valorUnitario=" + valorUnitario +
				", quantidade=" + quantidade +
				'}';
	}
}
