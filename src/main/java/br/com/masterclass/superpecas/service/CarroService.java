package br.com.masterclass.superpecas.service;

import br.com.masterclass.superpecas.model.DTO.CarroDTO;
import org.springframework.data.domain.Page;

public interface CarroService {

    Page<CarroDTO> getAllCars(int page, int size);

    CarroDTO getById(Long id);

    Page<CarroDTO> getByModelName(int page, int size, String nomeModelo);

    CarroDTO insert(CarroDTO carroDTO);

    CarroDTO edit(Long id, CarroDTO carroDTO);

    void delete(Long id);
}
