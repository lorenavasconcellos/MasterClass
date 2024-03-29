package br.com.masterclass.superpecas.repository;

import br.com.masterclass.superpecas.model.Carro;
import br.com.masterclass.superpecas.model.DTO.CarroDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarroRepository extends PagingAndSortingRepository<Carro, Long>, CrudRepository<Carro, Long> {

    @Query("FROM Carro carro")
    Page<Carro> getAllCars(Pageable pageable);

    @Query("SELECT carro FROM Carro carro " +
            "WHERE carro.id = ?1")
    Carro getById(Long id);

    @Query("SELECT carro FROM Carro carro " +
            "WHERE carro.nomeModelo like concat ('%',?1,'%') " +
            "OR ?1 IS NULL")
    Page<Carro> getByModelName(Pageable pageable, String nomeModelo);
}
