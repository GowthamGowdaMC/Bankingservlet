package DTO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class BankAccount 
{
	@Id
	@GeneratedValue(generator = "account_no")
	@SequenceGenerator(initialValue = 378838829,allocationSize = 1,sequenceName = "account_no",name = "account_no")
    long accountno;
	String type;
	double amount;
	boolean status;
	double acc_limit;
	
	@ManyToOne
	Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<BankTransaction> transactions;
	
}
