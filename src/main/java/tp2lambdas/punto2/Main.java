package tp2lambdas.punto2;

public class Main {
    public static void main(String[] args) {
        //Punto 2
        //Escriba una clase Main para poder llamar al metodo AprendiendoLambdas#unMetodo(C c) de la siguiente forma:
        //a. Utilizando un lambda dado que imprima true si el largo del String es par, false en caso contrario.
        //b. Utilizando un lambda dado que imprima true si el String empieza con a minúscula, false en caso contrario.

        AprendiendoLambdas a = new AprendiendoLambdas();
        a.unMetodo((String c) -> c.length() % 2 == 0);
        a.unMetodo((String c) -> c.startsWith("a"));
    }
}
