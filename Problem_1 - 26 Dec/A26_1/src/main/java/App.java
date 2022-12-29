
import java.util.List;

import javax.persistence.EntityManager;

import com.masai.main.EMUtils.EMUtils;
import com.masai.main.entity.Address;
import com.masai.main.entity.Customer;
import javax.persistence.Query;

public class App {
		public static void main(String args[])
		{
			EntityManager em=EMUtils.provideEntityManager();
			
			Address d1 = new Address();
			d1.setState("New Delhi");
			d1.setCity("Delhi");
			d1.setPincode(110078);


			Address d2 = new Address();
			d2.setState("Uttar Pradesh");
			d2.setCity("Gorakhpur");
			d2.setPincode(273015);

			Customer c1 = new Customer();
			c1.setCname("Rabindra");
			c1.setMobile("9874563210");
			c1.setEmail("rabindra@gmail.com");
			
			
			Customer c2 = new Customer();
			c2.setCname("Rahul");
			c2.setMobile("987321456");
			c2.setEmail("rahul@gmail.com");
			
			c1.getAdds().add(d1);
			c2.getAdds().add(d1);
			
			
			d1.getCust().add(c1);
			d1.getCust().add(c2);
			
			em.getTransaction().begin();
			
			em.persist(d1);
			em.persist(d2);
			String jpql= "select addresses from Customer";
			Query q= em.createQuery(jpql);
			
			List<Address> alladd= q.getResultList();
			
			
			em.getTransaction().commit();
			
			em.close();
			
			System.out.println(alladd);
			

			System.out.println("done");
		}


}
