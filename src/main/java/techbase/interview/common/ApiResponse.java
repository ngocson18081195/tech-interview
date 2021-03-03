package techbase.interview.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * Description:
 * The ApiResponse class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@Getter
@Setter
@NoArgsConstructor
public class ApiResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String time;
    private int codeStatus;
    private String messageStatus;
    private String description;
    private long took;
    private Object data;

    public ApiResponse(int codeStatus, String messageStatus, String description, long took) {
        super();
        this.codeStatus = codeStatus;
        this.messageStatus = messageStatus;
        this.description = description;
        this.took = took;
        this.time = new Date().toString();
    }

    public ApiResponse(int codeStatus, String messageStatus, String description, long took, Object data) {
        super();
        this.codeStatus = codeStatus;
        this.messageStatus = messageStatus;
        this.description = description;
        this.took = took;
        this.data = data;
        this.time = new Date().toString();
    }
}
