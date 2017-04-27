package wk.easyonboard.common.dataaccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
        final Optional<Map<String, Object>> first = data.stream()
                .filter(x -> {
                    for (Map.Entry key : keys.entrySet()) {
                        if (x.containsKey(key.getKey()))
                            if (!x.get(key.getKey()).equals(key.getValue()))
                                return false;
                    }
                    return true;
                }).findFirst();

        return first.isPresent() ? first.get() : null;
    }

    public List<Map<String, Object>> readAll() {
        return data;
    }

    @Override
    public boolean create(Map<String, Object> data) {
        return this.data.add(data);
    }

    @Override
    public List<Map<String, Object>> readMany(Map<String, Object> keys) {
        return data.stream().filter(x -> {
            for (Map.Entry key : keys.entrySet()) {
                if (x.containsKey(key.getKey()))
                    if (!x.get(key.getKey()).equals(key.getValue()))
                        return false;
            }
            return true;
        }).collect(Collectors.toList());
    }
}
