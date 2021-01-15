package udema.dao.models;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	private Integer id;
	private Integer studentId;
	private String content;
	private Integer starValue;
	private Integer courseId;
	private Timestamp createdAt;
	private Boolean status;
}
