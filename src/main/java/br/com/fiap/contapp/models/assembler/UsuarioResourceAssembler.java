package br.com.fiap.contapp.models.assembler;

import org.springframework.hateoas.Link;
import org.springframework.stereotype.Component;

import br.com.fiap.contapp.controllers.UsuarioController;
import br.com.fiap.contapp.models.Usuario;

@Component
public class UsuarioResourceAssembler implements ResourceAssembler<Usuario, Resource<Usuario>> {
    
    @Override
    public Resource<Usuario> toResource(Usuario usuario) {
        Resource<Usuario> resource = new Resource<>(usuario);

        Link selfLink = linkTo(methodOn(UsuarioController.class).mostrarDetalhe(usuario.getUsuarioId())).withSelfRel();
        resource.add(selfLink);

        return resource;
    }
}