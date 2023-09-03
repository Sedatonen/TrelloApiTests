package trello.models.response.createBoard;

import lombok.Data;

@Data
public class CreateBoardResponse{
	private Object descData;
	private boolean pinned;
	private LabelNames labelNames;
	private String shortUrl;
	private String url;
	private Prefs prefs;
	private Object idEnterprise;
	private String name;
	private String idOrganization;
	private boolean closed;
	private String id;
	private Limits limits;
	private String desc;
}