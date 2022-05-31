package some_tests;

class A {
    private int a;
}

class B extends A {

}

public class Overload {
    static int a;
    static int b;

    static void foo(int... a) {
        System.out.println(1);
    }

    static void foo(int a) {
        int b;
        System.out.println(2);
    }

    public static void main(String[] args) {
        foo(1);
        Test.a++;
        Test.a++;
        System.out.println(Test.a);
        Test t = new Test();
        System.out.println(Test.a);

    }


}

class Test {
    static int a;
}