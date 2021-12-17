package br.com.be3HealthTech.cadastroPaciente.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.be3HealthTech.cadastroPaciente.model.Paciente;
import br.com.be3HealthTech.cadastroPaciente.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PacienteController {
	
	@Autowired 
	private PacienteRepository pacienteRepository;
	
	@GetMapping
	public ResponseEntity<List<Paciente>> getAll (){
		
		return ResponseEntity.ok(pacienteRepository.findAll());
		
	}
	
	@GetMapping("/{cpf}")
	public ResponseEntity<Paciente> findByCpf(@PathVariable long cpf) {
		
		return pacienteRepository.findByCpf(cpf)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());
		
	}
	
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Paciente>> getByTitulo(@PathVariable String nome){
		
		return ResponseEntity.ok(pacienteRepository.findAllByNomeContainingIgnoreCase(nome));
		
	}

	
	@PostMapping
	public ResponseEntity<Paciente> postPostagem (@RequestBody Paciente paciente){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pacienteRepository.save(paciente));
		
	}
	
	
	@PutMapping
	public ResponseEntity<Paciente> putPostagem (@RequestBody Paciente paciente){

		return ResponseEntity.status(HttpStatus.OK).body(pacienteRepository.save(paciente));

	}
			
	
}