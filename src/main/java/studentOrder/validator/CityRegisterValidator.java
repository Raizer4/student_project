package studentOrder.validator;

import studentOrder.domain.Person;
import studentOrder.domain.register.AnswerCityRegister;
import studentOrder.domain.Child;
import studentOrder.domain.register.AnswerCityRegisterItem;
import studentOrder.domain.register.CityRegisterResponse;
import studentOrder.domain.StudentOrder;
import studentOrder.exception.CityRegisterException;
import studentOrder.exception.TransportException;
import studentOrder.validator.register.CityRegisterChecker;
import studentOrder.validator.register.FakeCityRegisterChecker;

public class CityRegisterValidator {

    public static final String IN_GRN = "NO GRN";

    String hostName;
    String login;
    String password;

    private CityRegisterChecker personChecker;

    public CityRegisterValidator(){
        personChecker = new FakeCityRegisterChecker();
    }

     public AnswerCityRegister checkCityRegister(StudentOrder so){

         AnswerCityRegister ans = new AnswerCityRegister();

         ans.addItem(checkPerson(so.getHusband()));
         ans.addItem(checkPerson(so.getWife()));
         for (Child temp : so.getChildren()) {
             ans.addItem(checkPerson(temp));
         }

         return ans;
    }

    private AnswerCityRegisterItem checkPerson(Person person){

        AnswerCityRegisterItem.CityStatus status = null;
        AnswerCityRegisterItem.CityError error = null;

        try {
            CityRegisterResponse tmp = personChecker.checkPerson(person);
            status = tmp.isExisting() ? AnswerCityRegisterItem.CityStatus.YES :
                                        AnswerCityRegisterItem.CityStatus.NO;
        } catch (CityRegisterException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(ex.getCode(),ex.getMessage());
        }catch (TransportException ex) {
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_GRN,ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace(System.out);
            status = AnswerCityRegisterItem.CityStatus.ERROR;
            error = new AnswerCityRegisterItem.CityError(IN_GRN,ex.getMessage());
        }

        AnswerCityRegisterItem ans = new AnswerCityRegisterItem(status,person,error);

        return ans;
    }

}
