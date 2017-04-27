package wk.easyonboard.common.dataaccess;

import java.util.List;
import java.util.Map;

/**
 * Created by Luca Welker on 4/26/17.
 */
public abstract class DbContext {
    public abstract Map<String, Object> read(Map<String, Object> keys);

    public abstract List<Map<String, Object>> readAll();

    public abstract List<Map<String, Object>> readMany(Map<String, Object> keys);

    public abstract boolean create(Map<String, Object> data);
}
