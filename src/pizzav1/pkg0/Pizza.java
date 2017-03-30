package pizzav1.pkg0;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Pizza {

    private String masa = "";
    private String tipoPizza = "";
    private String tamano = "";

    private final Set<String> preciosExtra = new HashSet<>(); // Llevar a clase precio
    private final Map<String, Double> precios = new HashMap<>(); //Llecar a clase precio

    {
        precios.put("Normal", 9.0);
        precios.put("Integral", 9.50);
        precios.put("Basica", 3.0);
        precios.put("Cuatro Quesos", 5.0);
        precios.put("Barbacoa", 7.0);
        precios.put("Mexicana", 8.5);
        precios.put("Sin extra", 0.0);
        precios.put("Jamon", 0.5);
        precios.put("Queso", 0.75);
        precios.put("Tomate", 1.5);
        precios.put("Cebolla", 2.5);
        precios.put("Olivas", 1.0);
        precios.put("Pequeña", 1.0);
        precios.put("Mediana", 1.15);
        precios.put("Grande", 1.30);

    }

    public Pizza(String masa, String tipoPizza, String tamano) {
        this.masa = masa;
        this.tipoPizza = tipoPizza;
        this.tamano = tamano;
    }

    public Pizza() {
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

    public void modificarPrecios(String nombre, double cantidad) { // Llevar a clase precio
        precios.computeIfPresent(nombre, (k, v) -> cantidad);
    }

    public double buscarPrecio(String nombre) { // Llevar a clase precio
        double precio;

        precio = precios.get(nombre);

        return precio;
    }

    public double calcularPrecio() { // Se queda aqui

        //ATRIBUTOS
        double total = 0.0, precioMasa = 0.0, precioTipo = 0.0, precioIngredientes = 0.0, precioTamano = 1.0, totalFormateado = 0.0;

        //CALCULO PRECIO TIPO MASA
        precioMasa = buscarPrecio(masa);

        //CALCULO PRECIO TIPO DE PIZZA
        precioTipo = buscarPrecio(getTipoPizza());

        //CALCULO PRECIO INGREDIENTES
        double precio;
        for (String ingrediente : preciosExtra.keySet()) {
            precio = preciosExtra.get(ingrediente);
            precioIngredientes = precioIngredientes + precio;
        }

        //CALCULO PRECIO TAMAÑO
        System.out.println(preciosExtra.toString());
        System.out.println(precioIngredientes);
        precioTamano = buscarPrecio(getTamano());

        total = precioMasa + precioTipo + precioIngredientes;
        total = total * precioTamano;
        totalFormateado = Math.round(total * 100.0) / 100.0;

        return totalFormateado;
    }

    public String pedido() {
        String tiquet = "";

        return tiquet;
    }

    public String ingredientes() {
        String cadena = "", jamon = "", queso = "", tomate = "", cebolla = "", olivas = "";
        for (String ingrediente : preciosExtra.keySet()) {

            if (ingrediente.equals("Jamon")) {
                jamon = "Jamón, ";
            }
            if (ingrediente.equals("Queso")) {
                queso = "Queso, ";
            }
            if (ingrediente.equals("Tomate")) {
                tomate = "Tomate, ";
            }
            if (ingrediente.equals("Cebolla")) {
                cebolla = "Cebolla, ";
            }
            if (ingrediente.equals("Olivas")) {
                olivas = "Olivas";
            }
        }

        cadena = jamon + queso + tomate + cebolla + olivas;

        return cadena;
    }

}
