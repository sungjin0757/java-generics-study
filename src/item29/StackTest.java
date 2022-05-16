package item29;

public class StackTest {
    private static String[] testArray=new String[]{"a","b","c"};

    public static void main(String[] args){
        StackV3<String> stackV3=new StackV3<>();
        StackV4<String> stackV4=new StackV4<>();

        for(String s : testArray){
            String upper = s.toUpperCase();
            stackV3.push(upper);
            stackV4.push(upper);
        }

        while(!stackV3.isEmpty()){
            System.out.println(stackV3.pop());
        }

        while(!stackV4.isEmpty()){
            System.out.println(stackV4.pop());
        }
    }

}
