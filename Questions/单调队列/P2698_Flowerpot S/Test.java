

public class Test {
    public static void main(String[] args) {
        Main main = new Main();
        Main.d = 5;
        Main.n = 4;
        Main.arr = new int[][]{{6,3},
                {2, 4},
                {4, 10},
                {12, 15}};
        System.out.println(Main.compute());
    }
}
