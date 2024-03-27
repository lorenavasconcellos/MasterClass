package br.com.masterclass.superpecas.controller;

import br.com.masterclass.superpecas.model.CarroModel;
import br.com.masterclass.superpecas.model.DTO.CarroDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carro")
public class CarroController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String buscaCarro() {
        return "teste";
    }


//    @Operation(summary = "Buscar carro", description = "Busca os dados de um carro pelo seu Id.")
//    @ApiResponses({ @ApiResponse(responseCode = "200", content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CarroDTO.class)) }),
//            @ApiResponse(responseCode = "404", description = "Carro não encontrado", content = @Content) })
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<CarroDTO> buscarCarro(@Parameter(description = "Id do Carro", required = true) @PathVariable int id) {
//        //CarroModel carroModel = carroService.buscaCarro(id);
//
//        //if (carroModel == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        //return new ResponseEntity<>(modelMapper.map(carroModel, CarroDTO.class), HttpStatus.OK);
//    }
}
