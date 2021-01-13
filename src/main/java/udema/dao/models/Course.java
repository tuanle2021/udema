package udema.dao.models;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	private Integer id;
	private String name;
	private String description;
	private String detail;
	private String images;
	private Double price;
	private String status;
	private Integer teacherId;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private Integer viewCount;
	private Integer categoryId;
	private Integer discount;
}
