package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Contacto;


@Repository
public class AgendaDaoImpl implements AgendaDao {

	@Autowired
	AgendaJpaSpring agendaJpaSpring;
	
	@Override
	public void agregarContacto(Contacto contacto) {
		agendaJpaSpring.save(contacto);
	}

	@Override
	public Contacto recuperarContacto(String email) {
		return agendaJpaSpring.findByEmail(email);
	}

	@Override
	public void eliminarContacto(String email) {
		agendaJpaSpring.eliminarPorEmail(email);
	}

	@Override
	public List<Contacto> devolverContactos() {
		return agendaJpaSpring.findAll();
	}

	@Override
	public void eliminarContacto(int idContacto) {
		agendaJpaSpring.deleteById(idContacto);

	}

	@Override
	public Contacto recuperarContacto(int idContacto) {
		return agendaJpaSpring.findById(idContacto).orElse(null);
	}

	@Override
	public void actualizarContacto(Contacto contacto) {
		agendaJpaSpring.save(contacto);

	}

}
