package train.trip.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TrainTripForm {
	
	private Integer id;
	
	@NotBlank
	@Size(min=1, max=64)
	private String value;
	
	@NotBlank
	@Pattern(regexp = "^[1-2][0-9]{3}-[0-9]{2}-[0-9]{2}$")
	private String departureDate;
	
	@NotBlank
	@Size(min=1, max=200)
	private String note;
	
	public Integer getId() {
		return id;
	}
	public String getValue() {
		return value;
	}
	public String getNote() {
		return note;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	
}

