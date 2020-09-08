public class Main {
    public static void main(String [] args){
        System.out.println("In Main");
        Stack s = new Stack();
        s.push(50);
        s.push(60);
        s.push(70);
        s.display();
        s.pop();
        s.pop();
        s.display();
    }
}
