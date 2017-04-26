package wk.easyonboard.common.dataaccess.typemapping;

/**
 * Created by Luca Welker on 4/26/17.
 */
public abstract class TypeMapper {
    private Class<?> fieldType;
    private Class<?> databaseType;

    public TypeMapper(Class<?> fieldType, Class<?> databaseType) {
        this.databaseType = databaseType;
        this.fieldType = fieldType;
    }

    public abstract Object mapToFieldType(Object value);
    public abstract Object mapToDatabaseType(Object value);
}
