package julio.projectz.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity( name = "Survivor" )
@Table(
		name = "survivors",
		uniqueConstraints = {
				@UniqueConstraint( name = "uk_survivor_unique_CPF", columnNames = "CPF")
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
	
	@NotEmpty( message = "{firstName.not.empty}")
	@Column( name = "firstName", nullable = false, length = 200 )
	private String firstName;
	
	@NotEmpty( message = "{lastName.not.empty}")
	@Column( name = "lastName", nullable = false, length = 150 )
	private String lastName;
	
	@CPF( message = "{CPF.valid}")
	@Column( name = "CPF", nullable = false, length = 11 )
	private String CPF;
	
	@NotNull( message = "{age.valid}")
	@Column( name = "age", nullable = false )
	private Integer age;
	
	@Column( name = "description", nullable = true, length = 400 )
	private String description;
	
	@Column( name = "flags", nullable = true )
	private Integer flags;
	
	@Column( name = "infected", nullable = true )
	private Boolean infected;

}
