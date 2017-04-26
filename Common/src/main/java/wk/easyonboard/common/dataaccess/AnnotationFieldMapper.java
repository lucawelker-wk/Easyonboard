package wk.easyonboard.common.dataaccess;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class AnnotationFieldMapper<T> implements FieldMapper<T> {
    private Class<T> classType;
    private Map<String, Field> fieldMap;
    private DefaultTypeMapper typeMapper;

    public AnnotationFieldMapper(Class<T> classType) {
        this.classType = classType;
        typeMapper = new DefaultTypeMapper();
        initializeFields();
    }

    private void initializeFields() {
        fieldMap = new HashMap<>();
        final Field[] fields = classType.getDeclaredFields();
        Arrays.stream(fields).forEach(x -> fieldMap.put(x.getName(), x));
    }

    public T mapToObject(Map<String, Object> data) throws IllegalAccessException, InstantiationException {
        T result = classType.newInstance();

        for (Map.Entry entry : data.entrySet()) {
            if (fieldMap.containsKey(entry.getKey())) {
                Field field = fieldMap.get(entry.getKey());
                field.set(result, typeMapper.mapToFieldType(field.getType(), entry.getValue()));
            }
        }
        return result;
    }

    public Map<String, Object> mapToMap(T data) throws IllegalAccessException {
        if (data == null)
            return null;

        Map<String, Object> result = new HashMap<>();
        for (Map.Entry<String, Field> field : fieldMap.entrySet()) {
            final Object value = field.getValue().get(data);
            if (value != null) {
                result.put(field.getKey(), value);
            }
        }
        return result;
    }
}
