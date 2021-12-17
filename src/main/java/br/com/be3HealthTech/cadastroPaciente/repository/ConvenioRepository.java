package br.com.be3HealthTech.cadastroPaciente.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.be3HealthTech.cadastroPaciente.model.Convenio;


public interface ConvenioRepository extends JpaRepository <Convenio, Long> {
	public List <Convenio> findAllByNomeContainingIgnoreCase(String nome);
}
