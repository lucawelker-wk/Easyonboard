package wk.easyonboard.common.dataaccess;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Map;

/**
 * Created by wkss on 4/26/17.
 */
public abstract class Repository<T> {

    public T read(Map<String, String> keys) {
        throw new NotImplementedException();
    }

    public List<T> readAll() {
        throw new NotImplementedException();
    }

    public boolean create(T data) {
        throw new NotImplementedException();
    }

    public boolean update(T data, Map<String, String> keys) {
        throw new NotImplementedException();
    }

    public boolean delete(Map<String, String> keys) {
        throw new NotImplementedException();
    }
}
