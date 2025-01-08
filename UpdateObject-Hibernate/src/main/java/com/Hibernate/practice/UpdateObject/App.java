package com.Hibernate.practice.UpdateObject;

import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

//Program to Update the student id 
public class App 
{
    public static void main( String[] args )
    {
        //Loading the Configuration
    	Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	
    	//Creating the SessionFactory
    	SessionFactory sessionFactory = configuration.buildSessionFactory();
    	
    	//Opening the Session
    	Session session =  sessionFactory.openSession();
    	
    	//Begin Transaction
    	Transaction transaction = session.beginTransaction();
    	
    	//Perform Operation
    	System.out.println("Enter the Student Id to Update : ");
    	Scanner sc = new Scanner(System.in);
    	int id = sc.nextInt();
    	
    	Student st = session.get(Student.class, id);
    	
    	if(st!=null) {
    		st.setName("Avinash");
    		st.setMarks(88);
    		st.setEmail("Avi@gmail.com");
    		session.update(st);
    	}
    	else {
    		System.out.println("STUDENT WITH THE ID "+id+" IS NOT PRESENT");
    	}
    	
    	//Commit transaction
    	transaction.commit();
    	
    	//Close the session
    	session.close();
    	
    	//Close the sessionFactory
    	sessionFactory.close();
    }
}
