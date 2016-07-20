/**
 * Created by run on 16/7/14.
 */
public class StaticTest {
    public static void Add(int a){
        a = a+1;
    }
    public static void Append(String str){
        str += "a";
    }
    public static void main(String args[]){
        int a=0;
        Add(a);
        //System.out.println(a);
        String b = "a";
        Append(b);
        System.out.println(b);
    }

}


