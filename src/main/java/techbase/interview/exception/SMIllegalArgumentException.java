package techbase.interview.exception;

import lombok.Data;

/**
 * Description:
 * The SMIllegalArgumentException class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@Data
public class SMIllegalArgumentException extends SMBaseException {
    public SMIllegalArgumentException(String msg) {
        super(msg);
    }
}
