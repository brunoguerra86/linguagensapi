package br.com.bg8.linguagensapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinguagemRepository extends MongoRepository<Linguagem, String> {
    List<Linguagem> findByOrderByRanking();
}
