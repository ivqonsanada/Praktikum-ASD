package Praktikum7;

public class main {

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(0);
        st.push(6);
        st.push(7);
        st.cetak("Awal");

        System.out.println(st.peek());

        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
//        String pos = st.infixToPostfix("2+3*4+5/(3+7)");
        String pos = st.infixToPostfix("2+3*4-6/2");
        System.out.println(pos);
        String pre = st.infixToPrefix("2+3*4+5/(3+7)");
        System.out.println(pre);
        int inpos = st.countIn2Post(pos);
        System.out.println("================");
        System.out.println(inpos);
    }
}
