package in.serosoft.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.NotAudited;

import lombok.Data;

@Entity
@Table(name="student")
@Data
//@Audited
//@AuditTable("student_history")
public class Student {
	@Id
	private int id;
	private String name;
	private String branch;
	private int semester;
	private int marks;
	@NotAudited
	private String email;
	@OneToMany(mappedBy="student")
	private List<Project> projects;
}
