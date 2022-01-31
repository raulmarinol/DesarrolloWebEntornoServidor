package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Comments;

public interface CommentsService {
	
	public void insertNewComments(final Comments comments);	
	 
	public void updateComments(final Comments comments);	
	
	public void deleteComments(final Comments comments);
	
	public Comments searchById(final Long commentsId);
	
	public List<Comments> searchAll();

}
