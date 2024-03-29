package br.com.masterclass.superpecas.model.DTO;

import br.com.masterclass.superpecas.model.Carro;

public class CarroDTO {

    Long id;
    String nomeModelo;
    String fabricante;
    String codigoUnico;

    public CarroDTO(Carro carro) {
        this.id = carro.getId();
        this.nomeModelo = carro.getNomeModelo();
        this.fabricante = carro.getFabricante();
        this.codigoUnico = carro.getCodigoUnico();
    }

    public CarroDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
}
