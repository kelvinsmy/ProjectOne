import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaEx {
    public static void main(String[] args){
        People a = new People("Kelvin", "Sze");
        People b = new People("Peter", "Chan");
        People c = new People("Link", "Sze");
        ArrayList<People> pList = new ArrayList<>();
        pList.add(a);
        pList.add(b);
        pList.add(c);
        List<People> pNewList = pList.stream().filter(n-> n.getLastName()=="Sze").collect(Collectors.toList());
        pNewList.forEach(p->System.out.println(p.getFirstName()+" "+p.getLastName()));
    }
}
