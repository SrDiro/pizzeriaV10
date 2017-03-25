package pizzav1.pkg0;

import java.util.HashMap;
import java.util.Map;

public class Pizza {

    private String masa = "";
    private String tipoPizza = "";
    private String tamano = "";

    public Map<String, Double> precios = new HashMap<>();

    public Pizza(String masa, String tipoPizza, String tamano) {
        this.masa = masa;
        this.tipoPizza = tipoPizza;
        this.tamano = tamano;
    }

    public String getMasa() {
        return masa;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public String getTipo() {
        return tipoPizza;
    }

    public void setTipo(String tipo) {
        this.tipoPizza = tipo;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public double calcularPrecio() {

        //PRECIOS
        double total = 0.0, precioMasa = 0.0, precioTipo = 0.0, precioIngredientes = 0.0, precioTamano = 0.0;
        //INGREDIENTES
        double precioSinExtra = 0.0, precioJamon = 0.0, precioQueso = 0.0, precioTomate = 0.0, precioCebolla = 0.0, precioOlivas = 0.0;

        //CALCULO PRECIO TIPO MASA
        if (this.masa.equalsIgnoreCase("Normal")) {
            precioMasa = 9.0;
        } else if (this.masa.equalsIgnoreCase("Integral")) {
            precioMasa = 9.5;
        }

        //CALCULO PRECIO TIPO DE PIZZA
        if (this.tipoPizza.equalsIgnoreCase("Básica")) {
            precioTipo = 3.0;
        } else if (this.tipoPizza.equalsIgnoreCase("Cuatro Quesos")) {
            precioTipo = 5.0;
        } else if (this.tipoPizza.equalsIgnoreCase("Barbacoa")) {
            precioTipo = 7.0;
        } else if (this.tipoPizza.equalsIgnoreCase("Mexicana")) {
            precioTipo = 8.5;
        }
        
        //CALCUALAR PRECIO INGREDIENTES
//        for(String ingrediente : precios.keySet()){
//            if (ingrediente.equalsIgnoreCase("Sin extra")) {
//                
//            }
//        }

        total = precioMasa + precioTipo + precioIngredientes + precioTamano;

        return total;
    }

    public String pedido() {
        String tiquet = "";

        return tiquet;
    }

}
