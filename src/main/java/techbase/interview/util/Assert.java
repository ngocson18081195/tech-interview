package techbase.interview.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import techbase.interview.exception.SMIllegalArgumentException;

import java.util.List;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Assert {

    public static void notNull(Object object, String message) {
        notNullSM(object, message);
    }

    public static void notEmpty(List<String> objects, String message) {
        notEmptySM(objects, message);
    }

    private static void notNullSM(Object object, String message) {
        if (Objects.isNull(object)) {
            throw new SMIllegalArgumentException(message);
        }
    }

    private static void notEmptySM(List<String> objects, String message) {
        if (Objects.isNull(objects) || objects.isEmpty()) {
            throw new SMIllegalArgumentException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (null != object) {
            throw new SMIllegalArgumentException(message);
        }
    }

}
