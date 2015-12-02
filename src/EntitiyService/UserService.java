package EntitiyService;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import EntityP.User;
import EntityP.UserNotes;

public class UserService {

	public void deleteNote(int noteID) {

		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			UserNotes note = session.get(UserNotes.class, noteID);

			session.delete(note);

			session.getTransaction().commit();
			session.close();
			sessionFactory.close();

		} catch (Exception e) {
			System.out.print(e);
			e.printStackTrace();
		}
	}

	public void updateNote(int noteId, String title, String noteTxt) {

		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			UserNotes note = session.get(UserNotes.class, noteId);

			note.setTitle(title);
			note.setNote(noteTxt);
			note.setLastUpdate(new Date());

			session.getTransaction().commit();
			session.close();
			sessionFactory.close();

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}


	public List<UserNotes> getUser() {
		List<UserNotes> lst=null;
		try {

			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			lst=session.createQuery("SELECT e from UserNotes").list();
			
			
			session.getTransaction().commit();
			session.close();
			sessionFactory.close();
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return lst;
	}

	public void addUser() {
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();

			User user = new User("admin123", "hmyadav87@yahoo.com", new Date(),
					new Date());
			UserNotes userNote_1 = new UserNotes("firstTitle", "FirstNote",
					new Date(), new Date());
			UserNotes userNote_2 = new UserNotes("secTitle", "sectNote",
					new Date(), new Date());

			Set<UserNotes> set = new HashSet<UserNotes>();
			set.add(userNote_1);
			set.add(userNote_2);

			user.setNotes(set);

			session.save(user);
			session.save(userNote_1);
			session.save(userNote_2);

			session.getTransaction().commit();
			session.close();
			sessionFactory.close();

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
