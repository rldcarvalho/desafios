package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela criação e recuperação dos carrinhos de compras.
 */
public class CarrinhoComprasFactory {

	private List<CarrinhoCompras> carrinhos;

	public CarrinhoComprasFactory() {
		this.carrinhos = new ArrayList<>();
	}

	public CarrinhoComprasFactory(List<CarrinhoCompras> carrinhos) {
		this.carrinhos = carrinhos;
	}

	/**
     * Cria e retorna um novo carrinho de compras para o cliente passado como parâmetro.
     *
     * Caso já exista um carrinho de compras para o cliente passado como parâmetro, este carrinho deverá ser retornado.
     *
     * @param identificacaoCliente
     * @return CarrinhoCompras
     */
    public CarrinhoCompras criar(String identificacaoCliente) {

		if (this.carrinhos.contains(new CarrinhoCompras(identificacaoCliente))){
			return this.carrinhos.stream()
					.filter(c -> identificacaoCliente.equals(c.getIdentificacaoCliente()))
					.findAny().orElse(null);
		}else {
			CarrinhoCompras novoCarrinho = new CarrinhoCompras(identificacaoCliente, new ArrayList<>());
			this.carrinhos.add(novoCarrinho);
			return novoCarrinho;
		}

    }

    /**
     * Retorna o valor do ticket médio no momento da chamada ao método.
     * O valor do ticket médio é a soma do valor total de todos os carrinhos de compra dividido
     * pela quantidade de carrinhos de compra.
     * O valor retornado deverá ser arredondado com duas casas decimais, seguindo a regra:
     * 0-4 deve ser arredondado para baixo e 5-9 deve ser arredondado para cima.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTicketMedio() {

		BigDecimal sum = carrinhos.stream().map(CarrinhoCompras::getValorTotal)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		return sum.divide(BigDecimal.valueOf(this.carrinhos.size()), 2, RoundingMode.CEILING);
    }

    /**
     * Invalida um carrinho de compras quando o cliente faz um checkout ou sua sessão expirar.
     * Deve ser efetuada a remoção do carrinho do cliente passado como parâmetro da listagem de carrinhos de compras.
     *
     * @param identificacaoCliente
     * @return Retorna um boolean, tendo o valor true caso o cliente passado como parämetro tenha um carrinho de compras e
     * e false caso o cliente não possua um carrinho.
     */
    public boolean invalidar(String identificacaoCliente) {

		CarrinhoCompras carrinhoARemover = this.carrinhos.stream()
				.filter(c -> identificacaoCliente.equals(c.getIdentificacaoCliente()))
				.findFirst().orElse(null);

		if (carrinhoARemover == null) return false;
		else {
			this.carrinhos.remove(carrinhoARemover);
			return true;
		}
	}
}
