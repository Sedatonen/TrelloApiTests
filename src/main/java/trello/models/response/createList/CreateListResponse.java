package trello.models.response.createList;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateListResponse{
	private String idBoard;
	private int pos;
	private String name;
	private boolean closed;
	private String id;
	private Object limits;
	private Object status;


}