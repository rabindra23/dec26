package main;
import java.util.List;
import javax.persistence.Query;

import javax.persistence.EntityManager;

import cshyb_main.EmuUtils.EMUtils;
import cshyb_main.entity.Collage;
import cshyb_main.entity.Student;

public class App {

	public static void main(String[] args) {
			EntityManager em=EMUtils.provideEntityManager();
			
			System.out.println("Tables have been created");
			
			Collage c1=new Collage();
			
			c1.setCollageName("Vit");
			c1.setCollageAddress("Bhopal");
			
			Collage c2=new Collage();
			
			c2.setCollageName("IP");
			c2.setCollageAddress("New Delhi");
			
			Student s1=new Student();
		
			s1.setStudentName("Rabindra");
			s1.setEmail("rabi@gmail.com");
			s1.setMobileNumber("987456321");
			
			
			
			Student s2=new Student();
			
			s2.setStudentName("Rahul");
			s2.setEmail("rahul@gmail.com");
			s2.setMobileNumber("985632147");
			
			
			Student s3=new Student();
			
			s3.setStudentName("Satyam");
			s3.setEmail("satyam@gmail.com");
			s3.setMobileNumber("965874123");
			
			
			Student s4=new Student();
		
			s4.setStudentName("Sapna");
			s4.setEmail("sapna@gmail.com");
			s4.setMobileNumber("874521369");
			s4.setCollage(c1);
			
			Student s5=new Student();
		
			s5.setStudentName("Mukesh");
			s5.setEmail("mukesh@gmail.com");
			s5.setMobileNumber("985647123");
		
			
			Student s6=new Student();
		
			s6.setStudentName("Shyam");
			s6.setEmail("shyam@gmail.com");
			s6.setMobileNumber("789541236");
			s6.setCollage(c2);
			
			Student s7=new Student();
			
			s7.setStudentName("Kanishka");
			s7.setEmail("kanishka@gmail.com");
			s1.setMobileNumber("985471263");
		
			
			Student s8=new Student();
			
			s8.setStudentName("Micah");
			s8.setEmail("micah@gmail.com");
			s8.setMobileNumber("9854764155");
			
			s1.setCollage(c1);
			s2.setCollage(c1);
			s3.setCollage(c1);
			s4.setCollage(c1);
			s5.setCollage(c2);
			s6.setCollage(c2);
			s7.setCollage(c2);
			s8.setCollage(c2);
			
			c1.getStudents().add(s1);
			c1.getStudents().add(s2);
			c1.getStudents().add(s3);
			c1.getStudents().add(s4);
			
			c2.getStudents().add(s5);
			c2.getStudents().add(s6);
			c2.getStudents().add(s7);
			c2.getStudents().add(s8);
			
		
			
			em.getTransaction().begin();
			em.persist(c1);
			em.persist(c2);
		
			System.out.print("Item are saved successfully");
			em.getTransaction().commit();**/
			
			
			String jpql="select c.students from Collage c where c.collageId=:collageId";
			Query query=em.createQuery(jpql);
			query.setParameter("collageId",100);
			List<Student> students=query.getResultList();
			Collage collage = em.find(Collage.class, query.getParameterValue("collageId"));
			System.out.println(collage.getCollageId()+" "+collage.getCollageName()+" students");
			for(Student s:students) {
				System.out.println(s.getStudentRoll()+" "+s.getStudentName());
			}**/
			
			
			
			
			String jpql="select s.collage from Student s where s.studentRoll=:id";
			Query query=em.createQuery(jpql);
			query.setParameter("id", 110);
			Student student=em.find(Student.class,query.getParameterValue("id"));
			Collage collage=(Collage)query.getSingleResult();
			System.out.println(student.getStudentName()+" studies in "+collage.getCollageName()
			+" which is located in "+collage.getCollageAddress()); 
			
		}
			
		
			

	

}
