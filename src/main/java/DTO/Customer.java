package DTO;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;


@Entity
@Data
public class Customer 
{
	@Id
	@SequenceGenerator(initialValue = 1001,allocationSize = 1,sequenceName = "customer_id",name = "customer_id")
	@GeneratedValue(generator = "customer_id")
	int customer_id;
	String name;
	String email;
	String password;
	Long mobile;
	String gender;
	Date dob;
	
	@OneToMany
	List<BankAccount> accounts;
	
}
