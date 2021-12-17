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

import br.com.be3HealthTech.cadastroPaciente.model.Convenio;
import br.com.be3HealthTech.cadastroPaciente.repository.ConvenioRepository;

@RestController
@RequestMapping("/convenios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ConvenioController {
    
    @Autowired
	private ConvenioRepository convenioRepository;

	@GetMapping
	public ResponseEntity<List<Convenio>> getAll() {
		return ResponseEntity.ok(convenioRepository.findAll());
	
	}

	@GetMapping("/{id}")
	public ResponseEntity<Convenio> getById(@PathVariable long id) {
		return convenioRepository.findById(id)
			.map(resp -> ResponseEntity.ok(resp))
			.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Convenio>> getByDescricao(@PathVariable String nome) {
		return ResponseEntity.ok(convenioRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Convenio> postTema(@RequestBody Convenio convenio){
		return ResponseEntity.status(HttpStatus.CREATED)
			.body(convenioRepository.save(convenio));
	}

	@PutMapping
	public ResponseEntity<Convenio> putTema(@RequestBody Convenio convenio) {
		return ResponseEntity.status(HttpStatus.OK)
			.body(convenioRepository.save(convenio));

	}
}