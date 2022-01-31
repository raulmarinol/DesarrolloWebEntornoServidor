package org.iesalixar.servidor;

import org.hibernate.Session;
import org.iesalixar.servidor.services.CommentsService;
import org.iesalixar.servidor.services.CommentsServiceImpl;
import org.iesalixar.servidor.services.PostService;
import org.iesalixar.servidor.services.PostServiceImpl;
import org.iesalixar.servidor.services.UserService;
import org.iesalixar.servidor.services.UserServiceImpl;
import org.iesalixar.servidor.services.ValorarService;
import org.iesalixar.servidor.services.ValorarServiceImpl;
import org.iesalixar.servidor.utils.HibernateUtils;

public class Main {
	
	Session session = HibernateUtils.getSessionFactory().openSession();
	
	CommentsService commentsService = new CommentsServiceImpl(session);
	UserService userService = new UserServiceImpl(session);
	PostService postService = new PostServiceImpl(session);
	ValorarService valorarService = new ValorarServiceImpl(session);
	

}
