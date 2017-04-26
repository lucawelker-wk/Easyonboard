package wk.easyonboard.common.dataaccess;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wkss on 4/26/17.
 */
public abstract class Repository<T> {

    private DbContext context;
    private FieldMapper<T> mapper;
    private Class<T> classType;

    public Repository(Class<T> classType) {
        context = initializeContext();
        mapper = new AnnotationFieldMapper<T>(classType);
    }

    protected abstract DbContext initializeContext();

    public T read(Map<String, Object> keys) {

        throw new NotImplementedException();
    }

    public List<T> readAll() {
        final List<Map<String, Object>> data = context.readAll();

        return data.stream()
                .map(x -> {
                    try {
                        return mapper.mapToObject(x);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        return null;
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .collect(Collectors.toList());
    }

    public boolean create(T data) throws IllegalAccessException {
        if (data == null)
            return true;

        final Map<String, Object> stringObjectMap = mapper.mapToMap(data);
        return context.create(stringObjectMap);
    }

    public boolean update(T data, Map<String, Object> keys) {
        throw new NotImplementedException();
    }

    public boolean delete(Map<String, Object> keys) {
        throw new NotImplementedException();
    }
}
