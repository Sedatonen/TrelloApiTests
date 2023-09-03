package trello.models.response.createBoard;

import lombok.Data;

@Data
public class SwitcherViewsItem{
	private String viewType;
	private boolean enabled;
}