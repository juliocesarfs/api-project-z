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

import lombok.AllArgsConstructor;
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
			name = "survivor_sequence",
			sequenceName = "survivor_sequence",
			allocationSize = 1,
			initialValue = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "survivor_sequence"
			)
	private Long base_id;

  @NotEmpty( message = "{baseName.not.empty}")
	@Column( name = "baseName", nullable = false, length = 100, unique = true )
	private String baseName;

  @Column( name = "totalSurvivors", nullable = true )
	private Integer totalSurvivors;

  @OneToMany(mappedBy = "base")
  private Set<Survivor> survivors;

	public Base(String baseName) {
		this.baseName = baseName;
	}
}
