package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.CommentsDAO;
import org.iesalixar.servidor.dao.CommentsDAOImpl;
import org.iesalixar.servidor.model.Comments;

public class CommentsServiceImpl implements CommentsService {

	private CommentsDAO commentsDao;

	public CommentsServiceImpl(final Session session) {
		this.commentsDao = new CommentsDAOImpl(session);
	}

	@Override
	public void insertNewComments(Comments comments) {

		
		if (comments != null && comments.getId() == null) {
			
			commentsDao.insert(comments);
		}

	}

	@Override
	public void updateComments(Comments comments) {
		
		if (comments != null && comments.getId() != null) {

			
			commentsDao.update(comments);
		}

	}

	@Override
	public void deleteComments(Comments comments) {
		
		if (comments != null && comments.getId() != null) {

			commentsDao.delete(comments);
		}
	}

	@Override
	public Comments searchById(Long commentsId) {
		Comments comments = null;

		if (commentsId != null) {

			comments = commentsDao.searchById(commentsId);
		}

		return comments;
	}

	@Override
	public List<Comments> searchAll() {
		
		List<Comments> commentsList = new ArrayList<Comments>();

		commentsList = commentsDao.searchAll();

		return commentsList;
	}

	@Override
	public Comments searchByName(String name) {
		
		Comments comments = null;

		if (name!=null) {
			comments = commentsDao.searchByName(name);
		}
		
		return comments;

	}

}
