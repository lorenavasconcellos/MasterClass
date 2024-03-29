package br.com.masterclass.superpecas.service.serviceImpl;

import br.com.masterclass.superpecas.model.Carro;
import br.com.masterclass.superpecas.model.DTO.CarroDTO;
import br.com.masterclass.superpecas.repository.CarroRepository;
import br.com.masterclass.superpecas.service.CarroService;
import jakarta.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service("CarroService")
public class CarroServiceImpl implements CarroService {

    @Autowired
    CarroRepository carroRepository;

    @Override
    public Page<CarroDTO> getAllCars(int page, int size) {
        return carroRepository.getAllCars(PageRequest.of(page, size)).map(CarroDTO::new);
    }

    @Override
    public CarroDTO getById(Long id) {
        return new CarroDTO(carroRepository.getById(id));
    }

    @Override
    public Page<CarroDTO> getByModelName(int page, int size, String nomeModelo) {
        return carroRepository.getByModelName(PageRequest.of(page, size), nomeModelo).map(CarroDTO::new);
    }

    @Override
    @Transactional
    public CarroDTO insert(CarroDTO carroDTO) {
        Carro carro = new Carro();

        carro = validateAndSetFields(carro, carroDTO);

        return new CarroDTO(carroRepository.save(carro));
    }

    @Override
    @Transactional
    public CarroDTO edit(Long id, CarroDTO carroDTO) {
        Carro carro = carroRepository.getById(carroDTO.getId());

        if(carro == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No entity with the specified id was found");

        carro = validateAndSetFields(carro, carroDTO);

        return new CarroDTO(carroRepository.save(carro));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Carro carro = carroRepository.getById(id);

        if(carro == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No entity with the specified id was found");

        try {
           carroRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No entity with the specified id was found");
        }
    }

    private Carro validateAndSetFields(Carro carro, CarroDTO carroDTO){
        if (StringUtils.isEmpty(carroDTO.getNomeModelo()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required field: ModelName");
        else
            carro.setNomeModelo(carroDTO.getNomeModelo());

        if (StringUtils.isEmpty(carroDTO.getFabricante()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required field: Manufacturer");
        else
            carro.setFabricante(carroDTO.getFabricante());

        if (StringUtils.isEmpty(carroDTO.getCodigoUnico()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Missing required field: UniqueCode");
        else
            carro.setCodigoUnico(carroDTO.getCodigoUnico());

        return carro;
    }
}
