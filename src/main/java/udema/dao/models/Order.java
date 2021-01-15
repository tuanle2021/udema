package udema.dao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private Integer id;
	private Integer studentId;
	private Double totalMoney;
	private Integer status;
}
