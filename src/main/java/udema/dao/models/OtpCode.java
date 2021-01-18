package udema.dao.models;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtpCode {
	private Integer id;
	private String code;
	private Integer userId;
	private String email;
	private Timestamp expiredTime;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
