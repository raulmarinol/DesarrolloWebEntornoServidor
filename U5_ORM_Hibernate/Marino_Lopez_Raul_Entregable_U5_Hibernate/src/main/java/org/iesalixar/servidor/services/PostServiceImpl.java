package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.PostDAOImpl;
import org.iesalixar.servidor.dao.PostDAOImpl;
import org.iesalixar.servidor.model.Post;

public class PostServiceImpl implements PostService {

	private PostDAOImpl postDao;

	public PostServiceImpl(final Session session) {
		this.postDao = new PostDAOImpl(session);
	}

	@Override
	public void insertNewPost(Post post) {

		
		if (post != null && post.getId() == null) {
			postDao.insert(post);
		}

	}

	@Override
	public void updatePost(Post post) {
		// Compruebo que no es nulo y que ya existe (tiene ID)
		if (post != null && post.getId() != null) {

			// Actualizo el pedido
			postDao.update(post);
		}

	}

	@Override
	public void deletePost(Post post) {
		// Compruebo que no es nulo y que ya existe (tiene ID)
		if (post != null && post.getId() != null) {

			
			postDao.delete(post);
		}
	}

	@Override
	public Departamento searchById(Long departamentoId) {
		Departamento departamento = null;

		if (departamentoId != null) {

			departamento = departamentoDao.searchById(departamentoId);
		}

		return departamento;
	}

	@Override
	public List<Departamento> searchAll() {
		
		List<Departamento> departamentoList = new ArrayList<Departamento>();

		departamentoList = departamentoDao.searchAll();

		return departamentoList;
	}

	@Override
	public List<Departamento> searchByName(String name) {
		
		List<Departamento> departamentoList = new ArrayList<Departamento>();

		if (name!=null) {
			departamentoList = departamentoDao.searchByName(name);
		}
		

		return departamentoList;
	}

}
