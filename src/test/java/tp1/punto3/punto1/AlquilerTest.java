package tp1.punto3.punto1;

import org.junit.jupiter.api.Test;
import tp3.ejercicio1.*;

import static junit.framework.Assert.assertEquals;

public class AlquilerTest {
    @Test
    public void calcularPagoConLibrosRegularesPrestadosMasDeDosDias() {
        Libro elPrincipito = new Regular("El principito");
        Libro marvel = new Infantil("Marvel");
        Libro capitanAmerica = new NuevoLanzamiento("capitan america");
        CopiaLibro elPrincipitoCopia = new CopiaLibro(elPrincipito);
        CopiaLibro marvelCopia = new CopiaLibro(marvel);
        CopiaLibro capitanAmericaCopia = new CopiaLibro(capitanAmerica);

        Alquiler alquilerElPrincipito = new Alquiler(elPrincipitoCopia, 5);
        Alquiler alquilerMarvel = new Alquiler(marvelCopia, 3);
        Alquiler alquilerCapitanAmerica = new Alquiler(capitanAmericaCopia, 7);

        Cliente juan = new Cliente("juan");
        juan.alquilar(alquilerElPrincipito);
        juan.alquilar(alquilerMarvel);
        juan.alquilar(alquilerCapitanAmerica);
        assertEquals(29.0, juan.calcularDeudaYPuntosObtenidos()[0]);
    }

    @Test
    public void calcularPagoConLibrosRegularesPrestadosMenosDeDosDias() {
        Libro elPrincipito = new Regular("El principito");
        Libro marvel = new Infantil("Marvel");
        Libro capitanAmerica = new NuevoLanzamiento("capitan america");
        CopiaLibro elPrincipitoCopia = new CopiaLibro(elPrincipito);
        CopiaLibro marvelCopia = new CopiaLibro(marvel);
        CopiaLibro capitanAmericaCopia = new CopiaLibro(capitanAmerica);

        Alquiler alquilerElPrincipito = new Alquiler(elPrincipitoCopia, 2);
        Alquiler alquilerMarvel = new Alquiler(marvelCopia, 3);
        Alquiler alquilerCapitanAmerica = new Alquiler(capitanAmericaCopia, 7);

        Cliente juan = new Cliente("juan");
        juan.alquilar(alquilerElPrincipito);
        juan.alquilar(alquilerMarvel);
        juan.alquilar(alquilerCapitanAmerica);
        assertEquals(24.5, juan.calcularDeudaYPuntosObtenidos()[0]);
    }

    @Test
    public void calcularPagoConLibrosInfantilesPrestadosMasDeTresDias() {
        Libro elPrincipito = new Regular("El principito");
        Libro marvel = new Infantil("Marvel");
        Libro capitanAmerica = new NuevoLanzamiento("capitan america");
        CopiaLibro elPrincipitoCopia = new CopiaLibro(elPrincipito);
        CopiaLibro marvelCopia = new CopiaLibro(marvel);
        CopiaLibro capitanAmericaCopia = new CopiaLibro(capitanAmerica);

        Alquiler alquilerElPrincipito = new Alquiler(elPrincipitoCopia, 2);
        Alquiler alquilerMarvel = new Alquiler(marvelCopia, 7);
        Alquiler alquilerCapitanAmerica = new Alquiler(capitanAmericaCopia, 7);

        Cliente juan = new Cliente("juan");
        juan.alquilar(alquilerElPrincipito);
        juan.alquilar(alquilerMarvel);
        juan.alquilar(alquilerCapitanAmerica);
        assertEquals(30.5, juan.calcularDeudaYPuntosObtenidos()[0]);
    }

    @Test
    public void calcularPagoConLibrosInfantilesPrestadosMenosDeTresDias() {
        Libro elPrincipito = new Regular("El principito");
        Libro marvel = new Infantil("Marvel");
        Libro capitanAmerica = new NuevoLanzamiento("capitan america");
        CopiaLibro elPrincipitoCopia = new CopiaLibro(elPrincipito);
        CopiaLibro marvelCopia = new CopiaLibro(marvel);
        CopiaLibro capitanAmericaCopia = new CopiaLibro(capitanAmerica);

        Alquiler alquilerElPrincipito = new Alquiler(elPrincipitoCopia, 2);
        Alquiler alquilerMarvel = new Alquiler(marvelCopia, 2);
        Alquiler alquilerCapitanAmerica = new Alquiler(capitanAmericaCopia, 7);

        Cliente juan = new Cliente("juan");
        juan.alquilar(alquilerElPrincipito);
        juan.alquilar(alquilerMarvel);
        juan.alquilar(alquilerCapitanAmerica);
        assertEquals(24.5, juan.calcularDeudaYPuntosObtenidos()[0]);
    }

    @Test
    public void calcularPagoConLanzamientoDeNuevosLibros() {
        Libro elPrincipito = new Regular("El principito");
        Libro marvel = new Infantil("Marvel");
        Libro capitanAmerica = new NuevoLanzamiento("capitan america");
        CopiaLibro elPrincipitoCopia = new CopiaLibro(elPrincipito);
        CopiaLibro marvelCopia = new CopiaLibro(marvel);
        CopiaLibro capitanAmericaCopia = new CopiaLibro(capitanAmerica);

        Alquiler alquilerElPrincipito = new Alquiler(elPrincipitoCopia, 2);
        Alquiler alquilerMarvel = new Alquiler(marvelCopia, 2);
        Alquiler alquilerCapitanAmerica = new Alquiler(capitanAmericaCopia, 7);

        Cliente juan = new Cliente("juan");
        juan.alquilar(alquilerElPrincipito);
        juan.alquilar(alquilerMarvel);
        juan.alquilar(alquilerCapitanAmerica);
        assertEquals(24.5, juan.calcularDeudaYPuntosObtenidos()[0]);
    }
}
