/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.itcr.bountyhunters;

/**
 *
 * @author daniel
 */
 
 
/** "Producto" */
class PizzaErrands {
    private String masa = "";
    private String salsa = "";
    private String relleno = "";
 
    public void setMasa(String masa)     { this.masa = masa; }
    public void setSalsa(String salsa)     { this.salsa = salsa; }
    public void setRelleno(String relleno) { this.relleno = relleno; }
}
 
 
/** "Abstract Builder" */
abstract class PizzaBuilder {
    protected PizzaErrands pizza;
 
    public PizzaErrands getPizza() { return pizza; }
    public void crearNuevaPizza() { pizza = new PizzaErrands(); }
 
    public abstract void buildMasa();
    public abstract void buildSalsa();
    public abstract void buildRelleno();
}
 
 
/** "ConcreteBuilder" */
class HawaiPizzaBuilder extends PizzaBuilder {
    @Override
    public void buildMasa()   { pizza.setMasa("suave"); }
    @Override
    public void buildSalsa()   { pizza.setSalsa("dulce"); }
    @Override
    public void buildRelleno() { pizza.setRelleno("chorizo+alcachofas"); }
}
 
/** "ConcreteBuilder" */
class PicantePizzaBuilder extends PizzaBuilder {
    @Override
    public void buildMasa()   { pizza.setMasa("cocida"); }
    @Override
    public void buildSalsa()   { pizza.setSalsa("picante"); }
    @Override
    public void buildRelleno() { pizza.setRelleno("pimienta+salchichón"); }
}
 
 
/** "Director" */
class Cocina {
    private PizzaBuilder pizzaBuilder;
 
    public void setPizzaBuilder(PizzaBuilder pb) { pizzaBuilder = pb; }
    public PizzaErrands getPizza() { return pizzaBuilder.getPizza(); }
 
    public void construirPizza() {
       pizzaBuilder.crearNuevaPizza();
       pizzaBuilder.buildMasa();
       pizzaBuilder.buildSalsa();
       pizzaBuilder.buildRelleno();
    }
} 
 
/** Un cliente pidiendo una pizza. */
class BuilderExample {
    public static void main(String[] args) {
        Cocina cocina = new Cocina();
        PizzaBuilder hawai_pizzabuilder = new HawaiPizzaBuilder();
        PizzaBuilder picante_pizzabuilder = new PicantePizzaBuilder();
 
        cocina.setPizzaBuilder( hawai_pizzabuilder );
        cocina.construirPizza();
 
        PizzaErrands pizza = cocina.getPizza();
    }
}