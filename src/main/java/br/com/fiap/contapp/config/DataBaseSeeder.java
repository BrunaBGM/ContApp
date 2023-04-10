package br.com.fiap.contapp.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.contapp.models.Exercicio;
import br.com.fiap.contapp.models.Refeicao;
import br.com.fiap.contapp.repository.ExercicioRepository;
import br.com.fiap.contapp.repository.RefeicaoRepository;

@Configuration
public class DataBaseSeeder implements CommandLineRunner {

    @Autowired
    ExercicioRepository exercicioRepository;

    @Autowired
    RefeicaoRepository refeicaoRepository;

    @Override
    public void run(String... args) throws Exception {

        exercicioRepository.saveAll(List.of(
            new Exercicio(1L, "Esteira", "Exercicio para cardio", "Aerobico", 50, 2, 0, 0, LocalDate.now()),
            new Exercicio(2L, "Supino", "Exercicio para peitoral e tríceps", "Musculação",45, 0, 60, 10, LocalDate.now())
        ));

        refeicaoRepository.saveAll(List.of(
            new Refeicao(1L, "cafe da manha", "mamão", "fruta", "é uma fruta rica em vitamina C, vitamina A e betacaroteno", 90, 1),
            new Refeicao(2L, "lanche", "iogurte", "laticínio", "iogurte natural", 59, 1)

        ));    

    }
} 