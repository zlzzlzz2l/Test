public class MyFunctionalInterfaceExample {
    public static void main(String[] args) {
        MyFunctionalInterface fi;

        fi = (x) -> { // 람다식에 매개변수가 없는 이유는 method()가 매개변수를 갖지 않기 때문
            int result = x * 5;
            System.out.println(result);
        };
        fi.method(2); // 이 호출로 람다식의 중괄호를 실행시킴

        fi = (x) -> {
            System.out.println(x * 5);
        };
        fi.method(2);

        fi = x -> System.out.println(x * 5);

        fi.method(2);
    }
}
