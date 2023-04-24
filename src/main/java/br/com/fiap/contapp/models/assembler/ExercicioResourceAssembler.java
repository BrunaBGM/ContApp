package br.com.fiap.contapp.models.assembler;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import br.com.fiap.contapp.controllers.ExercicioController;
import br.com.fiap.contapp.models.Exercicio;

@Component
public class ExercicioResourceAssembler implements ResourceAssembler<Exercicio, Resource<Exercicio>> {
    
    @Override
    public Resource<Exercicio> toResource(Exercicio exercicio) {
        Resource<Exercicio> resource = new Resource<>(exercicio);

        Link selfLink = linkTo(methodOn(ExercicioController.class).mostrarDetalhe(exercicio.getExercicioId())).withSelfRel();
        resource.add(selfLink);

        return resource;
    }
}