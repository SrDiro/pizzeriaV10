package modelo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Precios {
    
    final Set<String> preciosExtra = new HashSet<>(); // Llevar a clase precio
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
    
    
    public void modificarPrecios(String nombre, double cantidad) { // Llevar a clase precio
        precios.computeIfPresent(nombre, (k, v) -> cantidad);
    }
        
    public double buscarPrecio(String nombre) { // Llevar a clase precio
        double precio;

        precio = precios.get(nombre);

        return precio;
    }

    public void setPreciosExtra(String ingrediente) {
        
        preciosExtra.add(ingrediente);
        
    }
    
    
}
