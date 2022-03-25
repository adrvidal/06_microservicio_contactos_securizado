package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Contacto;
import service.AgendaService;

@CrossOrigin(origins = "*")
@RestController
public class AgendaController {
	@Autowired
	AgendaService agendaService;

	@GetMapping(value = "contactos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	Contacto buscarContacto(@PathVariable ("id") int idContacto) {
		return agendaService.buscarContacto(idContacto);
	}

	@GetMapping(value = "contactos", produces = MediaType.APPLICATION_JSON_VALUE)
	List<Contacto> recuperarContactos() {
		return agendaService.recuperarContactos();
	}

	@PostMapping(value = "contactos", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	String agregarContacto(@RequestBody Contacto contacto) {
		return String.valueOf(agendaService.agregarContacto(contacto));
	}

	@PutMapping(value = "contactos", consumes = MediaType.APPLICATION_JSON_VALUE)
	void actualizarContacto(@RequestBody Contacto contacto) {
		agendaService.actualizarContacto(contacto);
	}

	@DeleteMapping(value = "contactos/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	String eliminarContacto(@PathVariable ("id") int idContacto) {
		return String.valueOf(agendaService.eliminarContacto(idContacto));
	}

}
