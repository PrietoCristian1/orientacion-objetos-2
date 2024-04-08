package tp2lambdas.punto3;

public record Persona(String nombre, String apellido) {

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", apellido=" + apellido + "]";
    }


}
