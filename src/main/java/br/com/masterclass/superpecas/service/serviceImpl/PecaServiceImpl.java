package br.com.masterclass.superpecas.service.serviceImpl;

import br.com.masterclass.superpecas.model.Carro;
import br.com.masterclass.superpecas.model.DTO.CarroDTO;
import br.com.masterclass.superpecas.model.DTO.PecaDTO;
import br.com.masterclass.superpecas.model.Peca;
import br.com.masterclass.superpecas.repository.CarroRepository;
import br.com.masterclass.superpecas.repository.PecaRepository;
import br.com.masterclass.superpecas.service.PecaService;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service("PecaService")
public class PecaServiceImpl implements PecaService {
    @Autowired
    PecaRepository pecaRepository;

    @Autowired
    CarroRepository carroRepository;

    @Override
    public Page<PecaDTO> getAllParts(int page, int size) {
        return pecaRepository.getAllParts(PageRequest.of(page, size)).map(PecaDTO::new);
    }

    @Override
    public PecaDTO getById(Long id) {
        return new PecaDTO(pecaRepository.getById(id));
    }

    @Override
    public Page<PecaDTO> getByName(int page, int size, String nome) {
        return pecaRepository.getByName(PageRequest.of(page, size), nome).map(PecaDTO::new);
    }

    @Override
    @Transactional
    public PecaDTO insert(PecaDTO pecaDTO) {
        Peca peca = new Peca();

        peca = validateAndSetFields(peca, pecaDTO);

        return new PecaDTO(pecaRepository.save(peca));
    }

    @Override
    @Transactional
    public PecaDTO edit(Long id, PecaDTO pecaDTO) {
        Peca peca = pecaRepository.getById(pecaDTO.getId());

        if(peca == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No entity with the specified id was found");

        peca = validateAndSetFields(peca, pecaDTO);

        return new PecaDTO(pecaRepository.save(peca));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Peca peca = pecaRepository.getById(id);

        if(peca == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No entity with the specified id was found");

        try {
            pecaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No entity with the specified id was found");
        }
    }

    private Peca validateAndSetFields(Peca peca, PecaDTO pecaDTO){
        if (StringUtils.isEmpty(pecaDTO.getNome()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required field: Name");
        else
            peca.setNome(pecaDTO.getNome());

        if (StringUtils.isEmpty(pecaDTO.getDescricao()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required field: Descrição");
        else
            peca.setDescricao(pecaDTO.getDescricao());

        if (StringUtils.isEmpty(pecaDTO.getFabricante()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required field: Manufacturer");
        else
            peca.setFabricante(pecaDTO.getFabricante());

        if (StringUtils.isEmpty(pecaDTO.getNumeroSerie()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required field: SeriesNumber");
        else
            peca.setNumeroSerie(pecaDTO.getNumeroSerie());

        if (StringUtils.isEmpty(pecaDTO.getModeloCarro()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required field: CarModel");
        else
            peca.setModeloCarro(pecaDTO.getModeloCarro());

        if (pecaDTO.getCarroId() == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required field: CarId");
        else {
            Carro carro = carroRepository.getById(pecaDTO.getCarroId());

            if (carro == null)
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CarId inválido");

            peca.setCarro(carro);
        }

        return peca;
    }
}
