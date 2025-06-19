package com.ordem.Desafio.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;


@Entity
@Table(name="tb_item-ordem", uniqueConstraints =
        {@UniqueConstraint(name = "Unique_itemordem_Servico", columnNames = { "ordem_servico_id", "servico_id" })})
public class ItemOrdem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ITEM_ORDEM_ID")
    private Long id;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ordem_servico_id")
    @JsonBackReference
    private OrdemServico ordemServico;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "servico_id")
    private Servico servico;

    private int quantidade;

    private double subtotal;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public OrdemServico getOrdemServico() {
        return ordemServico;
    }
    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        setSubtotal(this.quantidade * getServico().getValor());
    }
    public Servico getServico() {
        return servico;
    }
    public void setServico(Servico servico) {
        this.servico = servico;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

}
