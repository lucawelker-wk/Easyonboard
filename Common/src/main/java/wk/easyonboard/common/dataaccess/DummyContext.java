package wk.easyonboard.common.dataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Luca Welker on 4/26/17.
 */
public class DummyContext<T> extends DbContext {
    private List<Map<String, Object>> data;
    private Class<T> typeClass;

    public DummyContext(List<T> dummyData, Class<T> typeClass) {
        this.typeClass = typeClass;
        initializeData(dummyData);
    }

    private void initializeData(List<T> dummyData) {
        data = new ArrayList<>();
        FieldMapper<T> mapper = new AnnotationFieldMapper<>(typeClass);

        dummyData.forEach(x -> {
            try {
                data.add(mapper.mapToMap(x));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public Map<String, Object> read(Map<String, Object> keys) {
        return null;
    }

    public List<Map<String, Object>> readAll() {
        return data;
    }

    @Override
    public boolean create(Map<String, Object> data) {
        return this.data.add(data);
    }
}
