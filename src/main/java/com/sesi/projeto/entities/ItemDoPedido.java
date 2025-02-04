package com.sesi.projeto.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tb_Pedido_Item")
public class ItemDoPedido {
	

    @EmbeddedId
    private ItemDoPedidoPk id = new ItemDoPedidoPk();  

    private Integer quantidade;
    private double preco;

    public ItemDoPedido() {}

    public ItemDoPedido(Pedido pedido, Produto produto, Integer quantidade, Double preco) {
        id.setPedido(pedido);  
        id.setProduto(produto);  
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Pedido getPedido() {
        return id.getPedido();
    }

    public void setPedido(Pedido pedido) {
        id.setPedido(pedido);  
    }

    public ItemDoPedidoPk getId() {
        return id;
    }

    public void setId(ItemDoPedidoPk id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

	public Object getProduto() {
		
		return null;
	}
}
