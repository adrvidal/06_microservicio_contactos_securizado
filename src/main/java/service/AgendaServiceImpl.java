package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AgendaDao;
import model.Contacto;

@Service
public class AgendaServiceImpl implements AgendaService {

	@Autowired
	AgendaDao agendaDao;

	@Override
	public boolean agregarContacto(Contacto contacto) {
		// Si no existe: lo agregamos
		if (agendaDao.recuperarContacto(contacto.getIdContacto()) == null) {
			agendaDao.agregarContacto(contacto);
			return true;
		} else
			return false;
	}

	@Override
	public List<Contacto> recuperarContactos() {
//		try {
//			Thread.sleep(8000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return agendaDao.devolverContactos();
	}

	@Override
	public void actualizarContacto(Contacto contacto) {
		// Si existe, lo actualizamos
		if (agendaDao.recuperarContacto(contacto.getIdContacto()) != null)
			agendaDao.actualizarContacto(contacto);

	}

	@Override
	public boolean eliminarContacto(int idContacto) {
		// Si existe, lo eliminamos.
		if (agendaDao.recuperarContacto(idContacto) != null) {
			agendaDao.eliminarContacto(idContacto);
			return true;
		}
		return true;

	}

	@Override
	public Contacto buscarContacto(int idContacto) {
		return agendaDao.recuperarContacto(idContacto);
	}

}
