package udema.dao.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterVideo {
	private Integer id;
	private Integer chapterId;
	private Integer courseId;
	private String videoSrc;
	private String attachment;
	private String note;
}
