package br.com.masterclass.superpecas.repository;

import br.com.masterclass.superpecas.model.CarroModel;
import org.springframework.data.repository.CrudRepository;

public interface CarroRepository extends CrudRepository<CarroModel, Integer> {
}
