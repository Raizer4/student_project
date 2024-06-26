package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.domain.register.AnswerCityRegisterItem;
import edu.javacourse.studentorder.domain.register.CityRegisterResponse;
import edu.javacourse.studentorder.exception.CityRegisterException;
import edu.javacourse.studentorder.validator.register.CityRegisterChecker;
import edu.javacourse.studentorder.validator.register.FakeCityRegisterChecker;
import edu.javacourse.studentorder.exception.TransportException;

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
