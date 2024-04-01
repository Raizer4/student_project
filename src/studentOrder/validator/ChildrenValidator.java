package studentOrder.validator;

import studentOrder.domain.children.AnswerChildren;
import studentOrder.domain.StudentOrder;

public class ChildrenValidator {

     public AnswerChildren checkChildren(StudentOrder so){
        System.out.println("Children Check is running");
        return new AnswerChildren();
    }

}
