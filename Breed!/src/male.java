import java.util.List;

public class male extends human {
    int kids;
    int kids_expectency;
    public male(int age, int smartness, String name,int kids,int kids_expectency) {
        super(age, smartness, name);
        this.kids=kids;
        this.kids_expectency=kids_expectency;

    }
    public static boolean check(List<male> list){
        boolean won = false;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).smartness>=1000){
                won = true;
            }
            if(list.get(i).age>life_expectency(list,i,null,i,true)){
                System.out.println(list.get(i).dead((list.get(i).age<40)? "heart attack":"old age",list,i));
            }
        }
        return won;
    }


}
