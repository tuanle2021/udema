package udema.dao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseChapter {
	private Integer id;
	private Integer ordinalNum;
	private String name;
	private Integer courseId;
}
