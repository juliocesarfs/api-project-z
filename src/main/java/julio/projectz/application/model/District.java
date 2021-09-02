package julio.projectz.application.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity( name = "District" )
@Table(
		name = "Districts",
		uniqueConstraints = {
			@UniqueConstraint( name = "uk_district_unique_name", columnNames = "districtName")
	}
)

public @Data class District {

  @Id
	@SequenceGenerator(
			name = "district_sequence",
			sequenceName = "district_sequence",
			allocationSize = 1,
			initialValue = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "district_sequence"
			)
	private Long id;

  @NotEmpty
	@Column( name = "districtName", nullable = false, length = 100, unique = true )
	private String districtName;

	public District(String districtName) {
		this.districtName = districtName;
	}
}
