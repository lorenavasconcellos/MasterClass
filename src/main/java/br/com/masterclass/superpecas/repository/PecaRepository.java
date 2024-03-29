package br.com.masterclass.superpecas.repository;

import br.com.masterclass.superpecas.model.DTO.PecaDTO;
import br.com.masterclass.superpecas.model.Peca;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PecaRepository extends PagingAndSortingRepository<Peca, Long>, CrudRepository<Peca, Long> {

    @Query("FROM Peca peca ")
    Page<Peca> getAllParts(Pageable pageable);

    @Query("SELECT peca FROM Peca peca " +
            "WHERE peca.id = ?1 ")
    Peca getById(Long id);

    @Query("SELECT peca FROM Peca peca " +
            "WHERE peca.nome like concat ('%',?1,'%') " +
            "OR ?1 IS NULL")
    Page<Peca> getByName(Pageable pageable, String nome);
}
