package udema.service.params;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MailParams {
	private String from;
	private String to;
	private String template;
	private String subject;
	private Map<String, String> params;
}
