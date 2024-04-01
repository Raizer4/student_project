package studentOrder.dao;

import studentOrder.domain.Street;
import studentOrder.exception.DaoException;

import java.util.List;

public interface DictionaryDao {

    List<Street> findStreet(String pattern) throws DaoException;

}
