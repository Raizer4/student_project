package studentOrder.dao;

import studentOrder.domain.CountryArea;
import studentOrder.domain.PassportOffice;
import studentOrder.domain.RegisterOffice;
import studentOrder.domain.Street;
import studentOrder.exception.DaoException;

import java.util.List;

public interface DictionaryDao {

    List<Street> findStreets(String pattern) throws DaoException;
    List<PassportOffice> findPassportOffices(String areaId) throws DaoException;
    List<RegisterOffice> findRegisterOffices(String areaId) throws DaoException;
    List<CountryArea> findAreas(String areaId) throws DaoException;

}
