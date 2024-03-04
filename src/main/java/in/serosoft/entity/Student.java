package in.serosoft.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="student")
@Data
public class Student {
	@Id
	private int id;
	private String name;
	private String branch;
	private int semester;
	private int marks;
}
