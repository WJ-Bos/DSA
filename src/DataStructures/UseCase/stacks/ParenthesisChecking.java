package DataStructures.UseCase.stacks;

import java.util.*;

public class ParenthesisChecking {

    public static void main(String[] args) {

        if(  checkParenthesis("{test")){
            System.out.println("Parenthesis is valid");
        }else {
            System.out.println("Parenthesis is not valid");
        }
    }

    public static boolean checkParenthesis(String statement) {

        Stack<Character> charStack = new Stack<>();
        Map<Character, Character> pairs = Map.of(
                ')','(',']','[','}','{');


        for(char c : statement.toCharArray()) {
            if(pairs.containsValue(c)){
                charStack.push(c);
            }else if(pairs.containsKey(c)){
                if(charStack.isEmpty()||charStack.pop() != pairs.get(c)){
                    return false;
                }
            }
        }
         return charStack.isEmpty();
    }
}
