package pizzav1.pkg0;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class Pizza {

    private String masa = "";
    private String tipoPizza = "";
    private String tamano = "";

    public Map<String, Double> preciosExtra = new HashMap<>();
    private static final Map<String, Double> precios = new HashMap<>();

    static {
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

    public void modificarPrecios(String nombre, double cantidad) {
        precios.computeIfPresent(nombre, (k, v) -> cantidad);
    }

    public double buscarPrecio(String nombre) {
        double precio = 0.0;

        for (String nombres : precios.keySet()) {
            if (nombres.equalsIgnoreCase(nombre)) {
                precio = precios.get(nombres);
            }

        }
        return precio;
    }

    public double calcularPrecio() {

        //ATRIBUTOS
        double total = 0.0, precioMasa = 0.0, precioTipo = 0.0, precioIngredientes = 0.0, precioTamano = 1.0, totalFormateado = 0.0;

        //CALCULO PRECIO TIPO MASA
        precioMasa = buscarPrecio(getMasa());

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
