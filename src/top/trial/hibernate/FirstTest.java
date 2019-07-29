package top.trial.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

public class FirstTest {
	@Test
	public void testGameEntityInsert() {
		SessionFactory sessionFactory = null;
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		try {
			System.out.println(1);
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			// create a couple of events...
			System.out.println(2);
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save( new GameEntity("234","haha") );
			session.save( new GameEntity("123","Ð´µÄÉ¶") );
			session.getTransaction().commit();
			session.close();
			System.out.println(3);
			// now lets pull events from the database and list them
			session = sessionFactory.openSession();
			session.beginTransaction();
			List result = session.createQuery( "from SG_GAME_INFO" ).list();
			for ( GameEntity gameEntity : (List<GameEntity>) result ) {
				System.out.println( gameEntity.toString());
			}
			session.getTransaction().commit();
			session.close();
			System.out.println(4);
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
	}
}
