package br.com.be3HealthTech.cadastroPaciente.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.be3HealthTech.cadastroPaciente.model.Paciente;


@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
	
	public List <Paciente> findAllByNomeContainingIgnoreCase(String nome);
	// igual o select * from tb_paciente where nome like "%nome%" do MYSQL
	
	Optional<Paciente> findByCpf(Long cpf);//busca pelo cpf
}