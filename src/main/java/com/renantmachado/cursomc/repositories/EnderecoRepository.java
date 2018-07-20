package com.renantmachado.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renantmachado.cursomc.domain.Endereco;

@Repository

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	

}
