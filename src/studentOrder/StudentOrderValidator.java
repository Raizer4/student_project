package studentOrder;

import studentOrder.domain.*;
import studentOrder.domain.children.AnswerChildren;
import studentOrder.domain.register.AnswerCityRegister;
import studentOrder.domain.student.AnswerStudent;
import studentOrder.domain.wedding.AnswerWedding;
import studentOrder.mail.MailSender;
import studentOrder.validator.ChildrenValidator;
import studentOrder.validator.CityRegisterValidator;
import studentOrder.validator.StudentValidator;
import studentOrder.validator.WeddingValidator;

import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSender mailSender;

    public StudentOrderValidator(){
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {
        StudentOrderValidator studentOrderValidator = new StudentOrderValidator();
        studentOrderValidator.checkAll();
    }

     void checkAll(){
         List<StudentOrder> soList = readStudentOrders();

         for (StudentOrder temp : soList){
             checkOneOrder(temp);
         }

    }

    public static List<StudentOrder> readStudentOrders(){
        List<StudentOrder> soList = new LinkedList<>();

        for (int c = 0; c < soList.size();c++){
            soList.add(SaveStudentOrder.buildStudentOrder(c));
        }

        return soList;
    }

    public void checkOneOrder(StudentOrder so){
        AnswerCityRegister cityRegister = checkCityRegister(so);
        //AnswerChildren childAnswer = checkChildren(so);
        //AnswerStudent studentAnswer = checkStudent(so);
        //AnswerWedding wedAnswer = checkWedding(so);
        //sendMail(so);
    }


    public AnswerCityRegister checkCityRegister(StudentOrder so){
        return cityRegisterVal.checkCityRegister(so);
    }

    public AnswerWedding checkWedding(StudentOrder so){
        return weddingVal.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so){
        return childrenVal.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so){
        return studentVal.checkStudent(so);
    }

    public void sendMail(StudentOrder so){
        mailSender.sendMail(so);
    }

}