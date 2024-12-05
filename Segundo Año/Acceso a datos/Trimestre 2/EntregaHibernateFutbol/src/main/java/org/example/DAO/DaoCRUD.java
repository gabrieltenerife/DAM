package org.example.DAO;

import java.util.ArrayList;

public interface DaoCRUD <T>{
    int create (T obj);
    ArrayList<T> read ();
    int update (T obj);
    int delete (T obj);
}
