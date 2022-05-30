package service_db;

import java.util.List;

public interface CRUD<T> {
    void createTable();
    void create(T o);
    List<T> read();
    void update(T o);
    void delete(int index);
}
