package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.model.DTO.PecaDTO;
import br.com.masterclass.superpecas.service.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peca")
public class PecaController {

    @Autowired
    PecaService pecaService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public Page<PecaDTO> getAllParts(@RequestParam int page, @RequestParam int size) {
        return pecaService.getAllParts(page, size);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PecaDTO getById(@PathVariable Long id) {
        return pecaService.getById(id);
    }

    @RequestMapping(value = "/nome", method = RequestMethod.GET)
    public Page<PecaDTO> getByName(@RequestParam int page,@RequestParam int size, @RequestParam String nome) {
        return pecaService.getByName(page, size, nome);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public PecaDTO insert(@RequestBody PecaDTO pecaDTO) {
        return pecaService.insert(pecaDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public PecaDTO edit(@PathVariable Long id, @RequestBody PecaDTO pecaDTO) {
        return pecaService.edit(id, pecaDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        pecaService.delete(id);
    }
}
