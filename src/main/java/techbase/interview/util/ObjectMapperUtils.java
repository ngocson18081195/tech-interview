package techbase.interview.util;

import org.modelmapper.ModelMapper;

/**
 * Description:
 * The ObjectMapperUtils class.
 * change history:
 * date              person             comments
 * -------------------------------------------------------------------------------
 * 3/2/2021        Ngoc Son           create file
 *
 * @author: Ngoc Son
 * @date: 3/2/2021
 */
public class ObjectMapperUtils {

    private static ModelMapper modelMapper = new ModelMapper();

    public static <D, T> D map(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }
}
