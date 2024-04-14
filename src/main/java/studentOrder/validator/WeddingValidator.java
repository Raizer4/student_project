package studentOrder.validator;

import studentOrder.domain.wedding.AnswerWedding;
import studentOrder.domain.StudentOrder;

public class WeddingValidator {

     public AnswerWedding checkWedding(StudentOrder so){
        System.out.println("Wedding is running");
        return new AnswerWedding();
    }

}
