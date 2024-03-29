package br.com.masterclass.superpecas.model.DTO;

import br.com.masterclass.superpecas.model.Peca;

public class PecaDTO {

    Long id;
    String nome;
    String descricao;
    String numeroSerie;
    String fabricante;
    String modeloCarro;
    Long carroId;

    public PecaDTO(Peca peca) {
        this.id = peca.getId();
        this.nome = peca.getNome();
        this.descricao = peca.getDescricao();
        this.numeroSerie = peca.getNumeroSerie();
        this.fabricante = peca.getFabricante();
        this.modeloCarro = peca.getModeloCarro();
        this.carroId = peca.getCarro().getId();
    }

    public PecaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public Long getCarroId() {
        return carroId;
    }

    public void setCarroId(Long carroId) {
        this.carroId = carroId;
    }
}