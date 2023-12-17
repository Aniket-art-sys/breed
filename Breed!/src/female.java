import java.util.List;

public class female extends human{

    public female(int age, int smartness, String name) {
        super(age, smartness, name);
    }
    public static boolean check(List<female> list){
        boolean won = false;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).smartness>=1000){
                won = true;
            }
            if(list.get(i).age>life_expectency(null,i,list,i,false)){
                System.out.println(list.get(i).dead((list.get(i).age<40)? "heart attack":"old age",list,i));
            }
        }
        return won;
    }

}
