import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final List<male> malelist = new ArrayList<>();
    private static final List<female> femalelist = new ArrayList<>();
    private static final Random random = new Random();


    public static void main(String[] args) {
        play();

    }
    public static void play(){
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("you will be given two ppl breed them till u reach 1000 smartness in any of the person. good luck!");
        malelist.add(new male(random.nextInt(15,23),random.nextInt(1,4),"pow",0,0));
        malelist.getLast().kids_expectency=human.life_expectency(malelist,malelist.size()-1,null,femalelist.size(),true);
        femalelist.add(new female(random.nextInt(15,23),random.nextInt(1,4),"roa"));
        listall(true, true);
        while (true) {
            System.out.println("what to do?");
            System.out.println("1: breed and make new life!,");
            System.out.println("2: kill some one and randomly give some a part of their smartness to the same gender,");
            System.out.println("3: pass time 1 year," );
            System.out.println("4: mate the smartest");
            switch (scanner1.nextInt()){
                case 1: listall(true, true);
                human.mated(malelist, candinate(true, false), femalelist, candinate(false, true));
                listall(true, true);
                break;

                case 2:
                    listall(true, true);
                    System.out.println("kill someone?");
                    listall(true, true);
                    System.out.println("Enter id");
                    int b = scanner1.nextInt();
                    System.out.println("Enter 1 for male 0 for female");
                    int a = scanner1.nextInt();
                switch (a) {

                        case 1: kill(true,false, b);
                    break;

                        case 0: kill(false,true, b);
                    break;

                }
                    listall(true, true);
                break;

                case 3:
                    passtime();
                    System.out.println("happy new year!");
                    listall(true, true);
                    break;
                case 4:
                    human.mated(malelist,getmax(malelist,null,true,true,true),femalelist,getmax(null,femalelist,false,true,true)); listall(true,true);
                break;
                default:
                    System.out.println("That's not an option.");
                break;
            }
            if(male.check(malelist)||female.check(femalelist)){
                listall(true,true);
                System.out.println("You won!!!"+((male.check(malelist))?malelist.get(getmax(malelist,null,true,true,false)).name:femalelist.get(getmax(null,femalelist,false,true,false)).name)+"has reached 1000 smartness. gg!");
                break;
            }
            if(malelist.isEmpty() || femalelist.isEmpty()){
                System.out.println("you lost because "+((malelist.isEmpty())?"all males are dead": "all females are dead"));
                break;
            }
        }
        System.exit(0);
    }
    public static void passtime(){
        for (int i = 0; i < malelist.size(); i++) {
            malelist.get(i).age++;
        }
        for (int i = 0; i < femalelist.size(); i++) {
            femalelist.get(i).age++;
        }
    }
    private static int candinate(boolean male, boolean female){
        Scanner scanner = new Scanner(System.in);
        int id=0;
        if(male){
            System.out.println("which male to mate?");
            id = scanner.nextInt();
            idcheck(true,false,id);

        }
        if(female){
            System.out.println("which female to mate?");
            id = scanner.nextInt();
            idcheck(false,true,id);


        }
        return id;
    }
    private static void listall(boolean male,boolean female) {
        if (male) {
            System.out.println("Males :"+((malelist.isEmpty())?"none":""));
            for (int i = 0; i < malelist.size(); i++) {
                System.out.println("id: " + i + " name: " + malelist.get(i).name + " age: " + malelist.get(i).age + " smartness " + malelist.get(i).smartness+" gender: male");
            }

        }

            if (female) {
                System.out.println("Females :"+((femalelist.isEmpty())?"none":""));
                for (int i = 0; i < femalelist.size(); i++) {
                    System.out.println("id: " + i + " name: " + femalelist.get(i).name + " age: " + femalelist.get(i).age + " smartness " + femalelist.get(i).smartness+" gender: female");
                }

            }

    }
    private static void kill(boolean male,boolean female,int id){
Scanner scanner3= new Scanner(System.in);
        if(male){
            System.out.println("male");
            while (id>malelist.size()){
                System.out.println("dose not exist re enter");
                listall(true,false);
                id= scanner3.nextInt();
            }
            if(malelist.get(id).smartness>0) {
                malelist.get(random.nextInt(malelist.size())).smartness += random.nextInt(malelist.get(id).smartness+1);
                malelist.get(id).dead("being left behind", malelist, id);
            }
        }if(female) {
            System.out.println("female");
            while (id>femalelist.size()){
                System.out.println("dose not exist re enter");
                listall(false,true);
                id= scanner3.nextInt();
            }
            if (femalelist.get(id).smartness > 0) {
                femalelist.get(random.nextInt(femalelist.size())).smartness += random.nextInt(femalelist.get(id).smartness+1);
                femalelist.get(id).dead("being left behind", femalelist, id);
            }
        }
    }
    private static boolean idcheck(boolean male,boolean female,int id){
        Scanner scanner2 = new Scanner(System.in);
        boolean dose_not_exit=false;
        if (male){
            while(id>= malelist.size()){
                dose_not_exit=true;
                System.out.println("dose not exist re enter");
                listall(true,false);
                id = scanner2.nextInt();
                System.out.println(id);

            }
        }
        if (female){
            while(id>= femalelist.size()){
                dose_not_exit=true;
                System.out.println("dose not exist re enter");
                listall(false,true);
                id = scanner2.nextInt();

            }
        }
        return dose_not_exit;
    }
    public static int getmax(List<male> malelist,List<female> femalelist,Boolean male_or_female,boolean returnid,boolean agecheck) {
        List<Integer> smartness = new ArrayList<>();
        List<Integer> age = new ArrayList<>();
        if(!male_or_female){
        for (int i = 0; i < femalelist.size(); i++) {
            smartness.add(femalelist.get(i).smartness);
            age.add(femalelist.get(i).age);
        }
        }else {
            for (int i = 0; i < malelist.size(); i++) {
                smartness.add(malelist.get(i).smartness);
                age.add(malelist.get(i).age);
            }
        }
        int maximum = -1;

        for (Integer number : smartness) {
            if (number > maximum) {
                maximum = number;
            }
        }


        if (returnid) {
            for (int i = 0; i < smartness.size(); i++) {
                if (smartness.get(i) == maximum) {
                    maximum = i;
                    break;

                }

            }

        }
        if(agecheck) {

            while (age.get(maximum) < 17) {
                if (smartness.size() < 2&&age.get(0)<17) {
                    System.out.println("You lost as all of the "+((male_or_female)?"male":"female")+" are underage");
                    System.exit(0);
                } else if (age.get(0)>17) {
                    maximum=0;
                    break;
                }else {
                smartness.remove(maximum);
                for (int i = 0; i < smartness.size(); i++) {
                    if (smartness.get(i) == maximum) {
                        maximum = i;
                        break;

                    }

                }
            }
            }
        }

        return maximum;
    }
}