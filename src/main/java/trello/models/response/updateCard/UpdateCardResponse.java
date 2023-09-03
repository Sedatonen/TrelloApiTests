package trello.models.response.updateCard;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UpdateCardResponse{
	private DescData descData;
	private List<Object> idLabels;
	private String shortUrl;
	private boolean dueComplete;
	private String dateLastActivity;
	private String idList;
	private List<Object> idMembersVoted;
	private String shortLink;
	private Cover cover;
	private Object dueReminder;
	private boolean subscribed;
	private int pos;
	private List<Object> idChecklists;
	private String id;
	private Object email;
	private String idBoard;
	private Object cardRole;
	private Object start;
	private List<Object> checkItemStates;
	private String url;
	private List<Object> labels;
	private Badges badges;
	private List<Object> idMembers;
	private int idShort;
	private Object due;
	private Object idAttachmentCover;
	@JsonProperty("isTemplate")
	private boolean isTemplate;
	private String name;
	private boolean closed;
	private boolean manualCoverAttachment;
	private String desc;
}