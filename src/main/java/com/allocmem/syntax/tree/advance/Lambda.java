package com.allocmem.syntax.tree.advance;

@FunctionalInterface
interface Print<T> {
    public void print(T x);
}
public class Lambda {
    public void PrintString(String s, Print<String> print) {
        print.print(s);
    }
    public void main(String[] args) {
        PrintString("test", (x) -> System.out.println(x));
    }

}
