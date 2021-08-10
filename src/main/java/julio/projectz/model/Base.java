package julio.projectz.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity( name = "Base" )
@Table(
		name = "Bases",
		uniqueConstraints = {
			@UniqueConstraint( name = "uk_base_unique_name", columnNames = "baseName")
	}
)

public @Data class Base {

  @Id
	@SequenceGenerator(
			name = "base_sequence",
			sequenceName = "base_sequence",
			allocationSize = 1,
			initialValue = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "base_sequence"
			)
	private Long id;

  @NotEmpty
	@Column( name = "baseName", nullable = false, length = 100, unique = true )
	private String baseName;

	public Base(String baseName) {
		this.baseName = baseName;
	}
}
