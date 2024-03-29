package br.com.masterclass.superpecas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Carros")
public class Carro {

    @Id
    @Column(name = "CarroId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "NomeModelo", nullable = false)
    String nomeModelo;

    @Column(name = "Fabricante")
    String fabricante;

    @Column(name = "CodigoUnico", nullable = false)
    String codigoUnico;

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
