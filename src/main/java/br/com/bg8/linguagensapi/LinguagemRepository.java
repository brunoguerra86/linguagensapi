package br.com.bg8.linguagensapi;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LinguagemRepository extends MongoRepository<Linguagem, String> {
    List<Linguagem> findByOrderByRanking();
}
