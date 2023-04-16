package br.com.fiap.contapp.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.contapp.models.Refeicao;
import br.com.fiap.contapp.models.Usuario;
import br.com.fiap.contapp.repository.RefeicaoRepository;
import br.com.fiap.contapp.repository.UsuarioRepository;

@Configuration
public class DataBaseSeeder implements CommandLineRunner {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RefeicaoRepository refeicaoRepository;

    @Override
    public void run(String... args) throws Exception {

        Usuario usuario1 =  new Usuario(1L,"Maria da Silva", "maria@gmail.com", "senha123", "feminino",20, 60.00, 1.60,LocalDate.now());
        Usuario usuario2 =  new Usuario(1L,"Jose da Silva", "jose@gmail.com", "senha123", "masculino",30, 80.00, 1.80,LocalDate.now());
        Usuario usuario3 =  new Usuario(2L, "Joao das Neves", "neves@gmail.com", "joao123","masculino",25, 70.00, 1.70,LocalDate.now());
      
        usuarioRepository.saveAll(List.of(usuario1,usuario2,usuario3));

        refeicaoRepository.saveAll(List.of(
            Refeicao.builder().categoriaRefeicao("cafe da manha").nome("mamão").categoriaAlimento("fruta").descricao("é uma fruta rica em vitamina C, vitamina A e betacaroteno").calorias(90).quantidade(1).data(LocalDate.now()).usuario(usuario1).build(),
            Refeicao.builder().categoriaRefeicao("lanche").nome("iogurte").categoriaAlimento("probiótico").descricao("iogurte natural").calorias(59).quantidade(1).data(LocalDate.now()).usuario(usuario1).build(),
            Refeicao.builder().categoriaRefeicao("lanche").nome("queijo branco").categoriaAlimento("laticínios").descricao("contem cálcio e outros minerais").calorias(84).quantidade(1).data(LocalDate.now()).usuario(usuario1).build(),
            Refeicao.builder().categoriaRefeicao("lanche").nome("banana").categoriaAlimento("fruta").descricao("é rica em fibras, vitaminas A, B1, B2 e C, cálcio, fósforo e ferro").calorias(89).quantidade(1).data(LocalDate.now()).usuario(usuario1).build(),
            Refeicao.builder().categoriaRefeicao("cafe da manha").nome("pao frances").categoriaAlimento(" carboidratos").descricao("pao frances medio").calorias(90).quantidade(1).data(LocalDate.now()).usuario(usuario1).build(),
            Refeicao.builder().categoriaRefeicao("cafe da manha").nome("cafe com leite").categoriaAlimento("bebida").descricao("xicara").calorias(90).quantidade(1).data(LocalDate.now()).usuario(usuario1).build(),
            Refeicao.builder().categoriaRefeicao("almoco").nome("file de frango").categoriaAlimento("proteina").descricao("baixo teor de gordura e é rico em nutrientes").calorias(239).quantidade(1).data(LocalDate.now()).data(LocalDate.now()).usuario(usuario1).build(),
            Refeicao.builder().categoriaRefeicao("lanche").nome("manga").categoriaAlimento("fruta").descricao("rica em potássio e vitamina A").calorias(60).quantidade(1).data(LocalDate.now()).usuario(usuario1).build(),
            Refeicao.builder().categoriaRefeicao("jantar").nome("arroz branco").categoriaAlimento("carboidrato").descricao("Arroz branco de grão longo, cozinhado").calorias(130).quantidade(1).data(LocalDate.now()).usuario(usuario1).build(),
            Refeicao.builder().categoriaRefeicao("jantar").nome("file de peixe").categoriaAlimento("probiótico").descricao("iogurte natural").calorias(59).quantidade(1).data(LocalDate.now()).usuario(usuario1).build()

        ));    

    }
} 