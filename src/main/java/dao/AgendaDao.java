package dao;

import java.util.List;

import model.Contacto;

public interface AgendaDao {
	//1
	void agregarContacto(Contacto contacto);

	Contacto recuperarContacto(String email);

	void eliminarContacto(String email);
	//2
	List<Contacto> devolverContactos();
	//4
	void eliminarContacto(int idContacto);
	//5
	Contacto recuperarContacto(int idContacto);
	//3
	void actualizarContacto(Contacto contacto);
}
