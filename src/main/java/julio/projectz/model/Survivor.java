package julio.projectz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity( name = "Survivor" )
@Table(
		name = "survivors",
		uniqueConstraints = {
				@UniqueConstraint( name = "uk_survivor_unique_email", columnNames = "email")
		}
)


public @Data class Survivor {
	
	@Id
	@SequenceGenerator(
			name = "survivor_sequence",
			sequenceName = "survivor_sequence",
			allocationSize = 1,
			initialValue = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "survivor_sequence"
			)
	private Long id;
	
	@Column( name = "firstName", nullable = false, length = 200 )
	private String firstName;
	
	@Column( name = "lastName", nullable = false, length = 150 )
	private String lastName;
	
	@Column( name = "email", nullable = false, length = 250 )
	private String email;
	
	@Column( name = "age", nullable = false )
	private Integer age;
	
	@Column( name = "description", nullable = true, length = 400 )
	private String description;
	
	@Column( name = "likes", nullable = true )
	private Integer likes;
}
