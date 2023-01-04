package br.com.improving.carrinho;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {

	private final String identificacaoCliente;
	private List<Item> itens;

	public CarrinhoCompras(String identificacaoCliente, List<Item> itens) {
		this.identificacaoCliente = identificacaoCliente;
		this.itens = itens;
	}

	public CarrinhoCompras(String identificacaoCliente) {
		this.identificacaoCliente = identificacaoCliente;
	}

	/**
     * Permite a adição de um novo item no carrinho de compras.
     *
     * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser seguidas:
     * - A quantidade do item deverá ser a soma da quantidade atual com a quantidade passada como parâmetro.
     * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor unitário do item deverá ser
     * o passado como parâmetro.
     *
     * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao carrinho de compras.
     *
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
		Item novoItem = new Item(produto, valorUnitario, quantidade);

		if (this.itens.contains(novoItem)){

			Item itemAtual = this.itens.get(this.itens.indexOf(novoItem));
			try {
				itemAtual.atualizaItem(novoItem);
			} catch (RuntimeException e){
				System.out.println("Não foi possível inserir o item ao carrinho de compras");
			}

		} else {
			try {
				this.itens.add(new Item(produto, valorUnitario, quantidade));
			} catch (RuntimeException e){
				System.out.println("Não foi possível inserir o item ao carrinho de compras");
			}
		}

    }

    /**
     * Permite a remoção do item que representa este produto do carrinho de compras.
     *
     * @param produto
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(Produto produto) {

		Item itemARemover = new Item(produto);

		if (this.itens.contains(itemARemover)) {

			this.itens.remove(itemARemover);
			return true;

		} else return false;

	}

    /**
     * Permite a remoção do item de acordo com a posição.
     * Essa posição deve ser determinada pela ordem de inclusão do produto na 
     * coleção, em que zero representa o primeiro item.
     *
     * @param posicaoItem
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removerItem(int posicaoItem) {

		try {
			this.itens.remove(posicaoItem);
			return true;
		} catch (Exception e){
			return false;
		}

    }

    /**
     * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais
     * de todos os itens que compõem o carrinho.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTotal() {

		return this.itens.stream().map(Item::getValorTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * Retorna a lista de itens do carrinho de compras.
     *
     * @return itens
     */
    public Collection<Item> getItens() {
		return itens;
    }

	public String getIdentificacaoCliente() {
		return identificacaoCliente;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final CarrinhoCompras that = (CarrinhoCompras) o;
		return getIdentificacaoCliente().equals(that.getIdentificacaoCliente());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getIdentificacaoCliente());
	}
}