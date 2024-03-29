package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.model.DTO.CarroDTO;
import br.com.masterclass.superpecas.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carro")
public class CarroController {

    @Autowired CarroService carroService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<CarroDTO> getAllCars(@RequestParam int page, @RequestParam int size) {
        return carroService.getAllCars(page, size);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CarroDTO getById(@PathVariable Long id) {
        return carroService.getById(id);
    }

    @RequestMapping(value = "/nomeModelo", method = RequestMethod.GET)
    public Page<CarroDTO> getByModelName(@RequestParam int page,@RequestParam int size, @RequestParam String nomeModelo) {
        return carroService.getByModelName(page, size, nomeModelo);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public CarroDTO insert(@RequestBody CarroDTO carroDTO) {
        return carroService.insert(carroDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public CarroDTO edit(@PathVariable Long id, @RequestBody CarroDTO carroDTO) {
        return carroService.edit(id, carroDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        carroService.delete(id);
    }
}
