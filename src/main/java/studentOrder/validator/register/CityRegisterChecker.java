package studentOrder.validator.register;

import studentOrder.domain.register.CityRegisterResponse;
import studentOrder.domain.Person;
import studentOrder.exception.CityRegisterException;
import studentOrder.exception.TransportException;

public interface CityRegisterChecker {

    CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException;

}
