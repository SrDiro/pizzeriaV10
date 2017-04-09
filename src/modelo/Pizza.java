package modelo;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Pizza {

    Precios precios = new Precios();

    private String masa;
    private String tipoPizza;
    private String tamano;
    static int contador;
    public final Set<String> preciosExtra = new HashSet<>(); // Llevar a clase precio

    public Pizza(String masa, String tipoPizza, String tamano) {
        this.masa = masa;
        this.tipoPizza = tipoPizza;
        this.tamano = tamano;
    }

    public Pizza() {
        contador++;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public void setTipoPizza(String tipoPizza) {
        this.tipoPizza = tipoPizza;
    }

    public String getMasa() {
        return masa;
    }

    public String getTipoPizza() {
        return tipoPizza;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public void setPreciosExtra(String ingrediente) {
        preciosExtra.add(ingrediente);
    }

    public void limpiarPreciosExtra() {
        preciosExtra.clear();
    }

    public String lista() {
        String respuesta = "";

        for (String ingredientes : preciosExtra) {
            respuesta += ingredientes + " ";
        }

        return respuesta;
    }

    public double calcularPrecio() { // Se queda aqui

        //ATRIBUTOS
        double total, precioMasa, precioTipo, precioIngredientes = 0.0, precioTamano = 1.0, totalFormateado, precio;

        //CALCULO PRECIO TIPO MASA
        precioMasa = precios.buscarPrecio(this.masa);

        //CALCULO PRECIO TIPO DE PIZZA
        precioTipo = precios.buscarPrecio(this.tipoPizza);

        //CALCULO PRECIO INGREDIENTES
        for (String ingrediente : this.preciosExtra) {
            precio = precios.buscarPrecio(ingrediente);
            precioIngredientes = precioIngredientes + precio;
        }

        //CALCULO PRECIO TAMAÑO
        if (precios.buscarPrecio(getTamano()) != 0.0) {
            precioTamano = precios.buscarPrecio(getTamano());
        }

        total = precioMasa + precioTipo + precioIngredientes;
        total = total * precioTamano;
        totalFormateado = Math.round(total * 100.0) / 100.0;

        return totalFormateado;
    }

    public void generarTicket() throws IOException {
        LocalDate date = LocalDate.now();
        String formato;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'-'");
        formato = date.format(formatter);
        formato += contador;

        try {
            Path path = Paths.get(formato + "ticket.txt");
            Files.createFile(path);
        } catch (FileAlreadyExistsException e) {
            System.err.println("already exists: " + e.getMessage());
        }

    }

}
