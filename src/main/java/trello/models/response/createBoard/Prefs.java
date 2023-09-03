package trello.models.response.createBoard;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Prefs{
	private boolean canBeEnterprise;
	private boolean hideVotes;
	private Object backgroundImage;
	private String voting;
	private List<Object> hiddenPluginBoardButtons;
	private List<SwitcherViewsItem> switcherViews;
	private boolean canBePublic;
	private boolean canBePrivate;
	private Object backgroundImageScaled;
	private String invitations;
	private boolean selfJoin;
	private String backgroundBrightness;
	private String backgroundColor;
	private String comments;
	private String backgroundTopColor;
	private boolean canBeOrg;
	private String backgroundBottomColor;
	private boolean calendarFeedEnabled;
	private boolean backgroundTile;
	private String permissionLevel;
	private String cardAging;
	private boolean canInvite;
	@JsonProperty("isTemplate")
	private boolean isTemplate;
	private String background;
	private boolean cardCovers;
}