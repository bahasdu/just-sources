package hello;

public class Hello {

    public static void main(String[] args) {
        int max = 20;
        max = 30;
        System.out.println(max);

        char letter = 'k';
        System.out.println(letter);
        String zhadyra = "world";
        System.out.println(zhadyra);
        if (letter == 'a') {
            System.out.println("letter is k");
        } else {
            System.out.println("letter is not k" );
        }
            
        if (zhadyra.equals("world")){
            System.out.println("i am zhadyra");
        }
        else {
            System.out.println("i am not zhadyra");
        }
        zhadyra = zhadyra + " muit";
        System.out.println(zhadyra);
        
        for (int i = 0; i < 10; i ++) {
            System.out.println("couter = "+i);
        }
        
        
    }
}
