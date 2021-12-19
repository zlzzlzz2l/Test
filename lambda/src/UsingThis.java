public class UsingThis {
    public int outterField = 10; //바깥 객체

    class Inner {
        int innerField = 20;

        void method() {
            MyFunctionalInterface fi = () -> {
                System.out.println("outterField: " + outterField);
                System.out.println("outterField: " + UsingThis.this.outterField + "\n"); // 클래스명.this 사용

                System.out.println("innerField: " + innerField);
                System.out.println("innerField: " + this.innerField + "\n"); // 람다식 내부에서 this는 Inner 객체 참조
            };
            fi.method();
        }
    }
}
