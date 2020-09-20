package in.srikanth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@SequenceGenerator(sequenceName = "Employee_Id_Seq", name = "E_Id_Seq", allocationSize = 1)
	@GeneratedValue(generator = "E_Id_Seq", strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String name;
	private Double salary;

	@Transient
	private String captcha;

	@Transient
	private String hidden;

	@Transient
	private String image;
}