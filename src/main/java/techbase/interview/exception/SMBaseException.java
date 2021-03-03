package techbase.interview.exception;

import lombok.Data;

/**
 * Description:
 * The SMBaseException class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/1/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/1/2021
 */
@Data
public class SMBaseException extends RuntimeException {
    public SMBaseException(String msg) {
        super(msg);
    }
}
