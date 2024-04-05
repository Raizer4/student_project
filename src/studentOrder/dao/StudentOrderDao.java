package studentOrder.dao;

import studentOrder.domain.StudentOrder;
import studentOrder.exception.DaoException;

public interface StudentOrderDao
{
    Long saveStudentOrder(StudentOrder so) throws DaoException;
}
