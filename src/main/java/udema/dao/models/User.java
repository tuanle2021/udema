package udema.dao.models;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Integer id;
	private String email;
	private String password;
	private String fullName;
	private String gender;
	private String avatar;
	private Timestamp createdAt;
	private Integer roleId;
	private Boolean status;
}
