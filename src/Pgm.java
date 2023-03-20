import java.util.ArrayList;
import java.util.List;

public class Pgm {
   public static void main(String[] a){
       List<Integer> a1=new ArrayList<>();
       a1.addAll(List.of(1,2,3,4));
       List<Integer> a2=a1.subList(1,3);
       a2.set(0,-1);
       print(a1);

   }



    public static void print(List<Integer> list){
        for(Integer a: list){
            System.out.println(a);
        }
    }
}

