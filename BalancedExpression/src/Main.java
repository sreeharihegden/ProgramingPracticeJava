import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        System.out.println("In Balanced Expression Main");

        // String exp = new String("1+2)");
        // String exp = new String("(1+2)");
        // String exp = new String("(");
        // String exp = new String(")1+2(");
        // String exp = new String("((1+2)");
        String exp = "(1+2>";
        System.out.println(isBalanced(exp));


    }

    public static boolean isBalanced(String exp){
        Stack<Character> st = new Stack<>();

        for(char ch: exp.toCharArray()){
            if(isLeftBracket(ch)){
                st.push(ch);
            }
            else if(isRightBracket(ch)){
                if( st.empty()){
                    return false;
                }
                var top = st.pop();
                if(!bracketsMatching(top, ch))
                    return false;
            }
        }

        return st.empty();
    }

    private static final List<Character> leftBrackets;
    private static final List<Character> rightBrackets;

    static {
        leftBrackets = Arrays.asList('(', '<', '{', '[');
        rightBrackets = Arrays.asList(')', '>', '}', ']');
    }

    private static boolean isLeftBracket(char ch){
        return leftBrackets.contains(ch);
        /*
        if(ch=='(' || ch=='{' || ch=='[' || ch=='<'){
            return true;
        }
        return false;
        */
    }

    private static boolean isRightBracket(char ch){
        return rightBrackets.contains(ch);
        /*
        if(ch==')' || ch=='}' || ch==']' || ch=='>'){
            return true;
        }
        return false;
         */
    }

    private static boolean bracketsMatching(char ch, char top){
        return leftBrackets.indexOf(ch) == rightBrackets.indexOf(top);
        /*
        return (ch == ')' && top == '(') ||
                (ch == '}' && top == '{') ||
                (ch == ']' && top == '[') ||
                (ch == '>' && top == '<');
         */
    }
}
