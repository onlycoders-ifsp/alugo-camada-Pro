package com.onlycoders.camadapro.api.rest;

import com.onlycoders.camadapro.model.entity.Produto;
import com.onlycoders.camadapro.model.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@Api(value = "Produtos")
@RequestMapping("/produtos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProdutoController {

    private final ProdutoRepository repository;

    @ApiOperation(value = "Cria novo produto")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto inserir(@RequestBody Produto produto) {
        return repository.save(produto);
    }


    @ApiOperation(value = "Muda dados produto")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Produto produto) {
        repository.save(produto);
    }

    @ApiOperation(value = "Inativa produto pelo id")
    @GetMapping("{id}/inativa")
    @ResponseStatus(HttpStatus.OK)
    public Boolean inativaById(@PathVariable Integer id) {
        Optional<Produto> produto = repository.findById(id);
        produto.ifPresent(u -> {
            u.setAtivo(false);
            repository.save(u);
        });
        if (!produto.isPresent())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        return produto.get().getAtivo();
    }

    @ApiOperation(value = "Inativa produto pelo id")
    @GetMapping("{nome}/inativa")
    @ResponseStatus(HttpStatus.OK)
    public Integer getIdByNome(@PathVariable String nome) {
        Optional<Produto> produto = repository.getByNome(nome);
        if (produto.isPresent())
            return produto.get().getId();
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        );
    }

    @ApiOperation(value = "Deleta produto")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository.deleteById(id);
    }

    @ApiOperation(value = "Lista os produtos")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> list(){
        return repository.findAll();
    }

    @ApiOperation(value = "Lista os produtos pelo código dos usuários")
    @GetMapping("lista/{codigo}")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> listByUsuarioCode(@PathVariable String codigo){
        return repository.getByLocatarioCodigo(codigo);
    }

}
