package br.com.acelera.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.acelera.biblioteca.entities.LivroEntity;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long>{

}
