package modelo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Pizza {
    
    Precios p1 = new Precios();
    
    private String masa = "";
    private String tipoPizza = "";
    private String tamano = "";

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

    public double calcularPrecio() { // Se queda aqui

        //ATRIBUTOS
        double total = 0.0, precioMasa = 0.0, precioTipo = 0.0, precioIngredientes = 0.0, precioTamano = 1.0, totalFormateado = 0.0;

        //CALCULO PRECIO TIPO MASA
        precioMasa = p1.buscarPrecio(masa);

        //CALCULO PRECIO TIPO DE PIZZA
        precioTipo = p1.buscarPrecio(getTipoPizza());

        //CALCULO PRECIO INGREDIENTES
        double precio;
        for (String ingrediente : p1.preciosExtra) {
            precio = p1.buscarPrecio(ingrediente);
            precioIngredientes = precioIngredientes + precio;
        }

        //CALCULO PRECIO TAMAÑO
        System.out.println(p1.preciosExtra.toString());
        System.out.println(precioIngredientes);
        precioTamano = p1.buscarPrecio(getTamano());

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
        for (String ingrediente : p1.preciosExtra) {

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
