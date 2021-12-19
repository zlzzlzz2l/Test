public class MyFunctionalInterfaceExample {
    public static void main(String[] args) {
        MyFunctionalInterface fi;

        fi = () -> { // 람다식에 매개변수가 없는 이유는 method()가 매개변수를 갖지 않기 때문
            String str = "method call1";
            System.out.println(str);
        };
        fi.method(); // 이 호출로 람다식의 중괄호를 실행시킴

        fi = () -> {
            System.out.println("method call2");
        };
        fi.method();

        fi = () -> System.out.println("method call3");

        fi.method();
    }
}
