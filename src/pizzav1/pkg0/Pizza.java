package pizzav1.pkg0;

import java.util.HashMap;
import java.util.Map;

public class Pizza {

    private String masa = "";
    private String tipoPizza = "";
    private String tamano = "";

    private static final Map<String, Double> precios = new HashMap<>();
    static{
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
    
    }
        
    public Pizza(String masa, String tipoPizza, String tamano) {
        this.masa = masa;
        this.tipoPizza = tipoPizza;
        this.tamano = tamano;        
    }

    public String getMasa() {
        return masa;
    }

    public String getTipoPizza() {
        return tipoPizza;
    }
        
    public void modificarPrecios(String nombre, double cantidad) {
        precios.computeIfPresent(nombre, (k, v) -> cantidad);
    }
    
    private double buscarPrecio(String nombre){
        double precio = 0.0;
        
        for(String nombres : precios.keySet()){
            if (nombres.equalsIgnoreCase(nombre)) {
                precio = precios.get(nombres);
            }
            
        }
        return precio;
    }
    

    public double calcularPrecio() {

        //PRECIOS
        double total = 0.0, precioMasa = 0.0, precioTipo = 0.0, precioIngredientes = 0.0, precioTamano = 0.0;
        //INGREDIENTES
        double precioSinExtra = 0.0, precioJamon = 0.0, precioQueso = 0.0, precioTomate = 0.0, precioCebolla = 0.0, precioOlivas = 0.0;

        //CALCULO PRECIO TIPO MASA
        precioMasa = buscarPrecio(getMasa());

        //CALCULO PRECIO TIPO DE PIZZA
        precioTipo = buscarPrecio(getTipoPizza());
        
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
