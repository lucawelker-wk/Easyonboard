package wk.easyonboard.common.dataaccess;

import wk.easyonboard.common.dataaccess.typemapping.TypeMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class DefaultTypeMapper {
    private Map<Class<?>, TypeMapper> nonDefaultTypemappers;

    public DefaultTypeMapper() {
        initializeNonDefaultTypeMappers();
    }

    private void initializeNonDefaultTypeMappers() {
        nonDefaultTypemappers = new HashMap<>();
    }

    public Object mapToFieldType(Class<?> fieldType, Object value) {
        if (value.getClass() == fieldType)
            return value;

        if (fieldType.isEnum()) {
            return mapToEnumType(fieldType.asSubclass(Enum.class), value);
        } else {
            return mapToType(fieldType, value);
        }
    }

    private Object mapToType(Class<?> fieldType, Object value) {
        if (nonDefaultTypemappers.containsKey(fieldType)) {
            return nonDefaultTypemappers.get(fieldType).mapToFieldType(value);
        }

        return value;
    }

    private Object mapToEnumType(Class<? extends Enum> fieldType, Object value) {
        if (!fieldType.isEnum())
            return null;

        if (value == null)
            return null;

        if (value instanceof String) {
            return mapEnumFromString(fieldType, (String)value);
        } else if(value instanceof Integer) {
            return mapEnumFromInteger(fieldType, (Integer)value);
        } else
            return null;
    }

    private Object mapEnumFromInteger(Class<? extends Enum> fieldType, Integer value) {
        return value;
    }

    private Object mapEnumFromString(Class<? extends Enum> fieldType, String value) {
        return Enum.valueOf(fieldType, value);
    }
}
