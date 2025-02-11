package udema.dao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteCourse {
	private Integer id;
	private Integer userId;
	private Integer courseId;
	private Boolean status;
}
