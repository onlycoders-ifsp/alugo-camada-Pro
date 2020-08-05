package com.onlycoders.camadapro.api.rest;

import com.onlycoders.camadapro.model.entity.Aluguel;
import com.onlycoders.camadapro.model.entity.Produto;
import com.onlycoders.camadapro.model.repository.AluguelRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Alugueis")
@RequestMapping("/aluguel")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AluguelController {

    private final AluguelRepository repository;
    @ApiOperation(value = "Cria novo aluguel")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aluguel inserir(@RequestBody Aluguel aluguel) {
        return repository.save(aluguel);
    }

    @ApiOperation(value = "Muda dados aluguel")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Aluguel aluguel) {
        repository.save(aluguel);
    }

    @ApiOperation(value = "Lista os aluguel")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Aluguel> list(){
        return repository.findAll();
    }

    @ApiOperation(value = "Deleta alguel")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository.deleteById(id);
    }




}
