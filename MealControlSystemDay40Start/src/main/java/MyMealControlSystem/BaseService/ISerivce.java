package MyMealControlSystem.BaseService;

import java.io.Serializable;
import java.util.List;

public interface ISerivce {

    <E> void delete(E Object);

    <E> E query(Class<E> e, Serializable code);

    <E> List<E> query(Class<E> e);

    void delete(String code);

    void excute(String sql);

    void save(List<?> list);
}
