package br.com.fiap.contapp.models.assembler;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import br.com.fiap.contapp.controllers.RefeicaoController;
import br.com.fiap.contapp.models.Refeicao;

@Component
public class RefeicaoResourceAssembler implements ResourceAssembler<Refeicao, Resource<Refeicao>> {
    
    @Override
    public Resource<Refeicao> toResource(Refeicao refeicao) {
        Resource<Refeicao> resource = new Resource<>(refeicao);

        Link selfLink = linkTo(methodOn(RefeicaoController.class).mostrarDetalhe(refeicao.getRefeicaoId())).withSelfRel();
        resource.add(selfLink);

        return resource;
    }
}