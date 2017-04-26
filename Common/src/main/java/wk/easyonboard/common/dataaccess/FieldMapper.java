package wk.easyonboard.common.dataaccess;

import java.util.Map;

/**
 * Created by Luca Welker on 4/26/17.
 */
public interface FieldMapper<T> {
    T mapToObject(Map<String, Object> data) throws IllegalAccessException, InstantiationException;
    Map<String, Object> mapToMap(T data) throws IllegalAccessException;
}
