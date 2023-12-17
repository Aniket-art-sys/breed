import javax.swing.*;
import java.util.*;

public class human {
    public int age;
    public int smartness;
    public String name;


    public human(int age, int smartness, String name) {
        this.age = age;
        this.smartness = smartness;
        this.name = name;
    }

    public void aged(int years) {
        age += years;
    }

    public String dead(String due_to,List list,int no) {
        if (!due_to.startsWith(" ")) {
            due_to=" "+due_to;
        }

            if (!due_to.startsWith(" due to")) {
                due_to = " due to" + due_to;
            }
            list.remove(no);
            return name + " died " + due_to;
    }
        public static void mated(List<male> malelist,int male_no, List<female> femalelist,int female_no){
            Main.passtime();
           if(femalelist.get(female_no).age>50){
               System.out.println(femalelist.get(female_no).name+" has gone through menopause and can't breed anymore!");
           } else if (malelist.get(male_no).kids>malelist.get(male_no).kids_expectency) {
               System.out.println(malelist.get(male_no).name+" has lost his will and can't breed anymore!");
           }else
            {if(femalelist.get(female_no).age<18){
            System.out.println(femalelist.get(female_no).dead("under age mating",femalelist,female_no));
            }else if(malelist.get(male_no).age<18){
                System.out.println(malelist.get(male_no).dead("under age mating",malelist,male_no));
            }else{
            Random random = new Random();
            Scanner scanner = new Scanner(System.in);
            int gender = random.nextInt(2);
            switch (gender){
                case 1:{System.out.println("A female is born! enter name");
                femalelist.add(new female(0, random.nextInt(1,femalelist.get(female_no).smartness+malelist.get(male_no).smartness),scanner.next()));
                System.out.println("stats of the child are age: "+femalelist.getLast().age+" smartness: "+femalelist.getLast().smartness+" name: "+femalelist.getLast().name+" id: "+femalelist.size());
                break;}
                case 0:{System.out.println("A male is born! enter name");
                malelist.add(new male(0,random.nextInt(1,malelist.get(male_no).smartness+femalelist.get(female_no).smartness),scanner.next(),0,0));
                malelist.getLast().kids_expectency=human.life_expectency(malelist,malelist.size()-1,null,femalelist.size(),true);
                System.out.println("stats of the child are age: "+malelist.getLast().age+" smartness: "+malelist.getLast().smartness+" name: "+malelist.getLast().name+" id: "+malelist.size());
                malelist.get(male_no).kids++;
                break;}
            }
        }
            }
        }
        public static int life_expectency(List<male> malelist,int male_no,List<female> femalelist,int female_no,boolean male_or_female) {
            Random random = new Random();
            List<Integer> smartness = new ArrayList<>();
            int life_expectencyy =0;
            if (male_or_female) {

                    life_expectencyy = random.nextInt(60 - (malelist.get(male_no).smartness / Main.getmax(malelist,null,true,false,false) * 15), 70);

            } else {

                    life_expectencyy = random.nextInt(60 - (femalelist.get(male_no).smartness / Main.getmax(null,femalelist,false,false,false) * 15), 70);

            }
            return life_expectencyy;
        }
    private static int getmax(List<Integer> numbers) {
        int maximum = -1;

        for (Integer number : numbers) {
            if (number > maximum) {
                maximum = number;
            }
        }

        return maximum;
    }
    }
