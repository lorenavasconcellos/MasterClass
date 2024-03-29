package br.com.masterclass.superpecas.service;

import br.com.masterclass.superpecas.model.DTO.PecaDTO;
import org.springframework.data.domain.Page;

public interface PecaService {

    Page<PecaDTO> getAllParts(int page, int size);

    PecaDTO getById(Long id);

    Page<PecaDTO> getByName(int page, int size, String nome);

    PecaDTO insert(PecaDTO pecaDTO);

    PecaDTO edit(Long id, PecaDTO pecaDTO);

    void delete(Long id);
}
