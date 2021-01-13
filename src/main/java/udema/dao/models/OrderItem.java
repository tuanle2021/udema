package udema.dao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
	private Integer id;
	private Integer courseId;
	private Integer amount;
	private Integer discount;
	private Double totalMoney;
	private Integer orderId;
}
