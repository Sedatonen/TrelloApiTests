package trello.models.response.createCard;

import lombok.Data;

@Data
public class Badges{
	private int comments;
	private int attachments;
	private AttachmentsByType attachmentsByType;
	private boolean dueComplete;
	private Object start;
	private boolean description;
	private Object checkItemsEarliestDue;
	private boolean subscribed;
	private Object due;
	private boolean viewingMemberVoted;
	private boolean location;
	private int votes;
	private String fogbugz;
	private int checkItems;
	private int checkItemsChecked;
}