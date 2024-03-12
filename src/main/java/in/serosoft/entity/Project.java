package in.serosoft.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Project {
	@Id
	private String code;
	private String title;
	private String subject;
	@ManyToOne
	private Student student;
}
