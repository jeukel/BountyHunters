package edu.itcr.bountyhunters;

/*
 * sin título.java
 *
 * Copyright 2013 Daniel Jenkins <jeukel@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 *
 *
 */

public class PlanningRoute{
    
    private Stack pila;
    private Queue cola;

    public PlanningRoute(){
        pila = new Stack();
        cola = new Queue();
    }
    
    private void llenarPilaNodosAdyacentes(Node nodo){
        for(int i = 0; i < nodo.getHijos().size();i++){
            if(!nodo.getHijos().contains(nodo)){
                pila.addNodo(nodo.getHijos().get(i));
            }
        }
    }
    
    private void llenarColaNodosAdyacentes(Node nodo){
        for(int i = 0; i < nodo.getHijos().size();i++){
            if(!nodo.getHijos().contains(nodo)){
                cola.addNodo(nodo.getHijos().get(i));
            }
        }
    }

    public void recorrerProfundidadIterativo(Graph grafo,Node nodoInicio){
        if(grafo != null && nodoInicio != null){
            pila.addNodo(nodoInicio);
            while(pila.size() > 0){
                Node nodoVisitado = pila.getNodo();
                if(nodoVisitado.visitado == false){
                    nodoVisitado.visitado = true;
                    System.out.print(nodoVisitado.getDato()+",");
                    llenarPilaNodosAdyacentes(nodoVisitado);
                }
            }
        }
    }
    
    public void recorrerAmplitud(Graph grafo,Node nodoInicio){
        if(grafo != null && nodoInicio != null){
            cola.addNodo(nodoInicio);
            while(cola.size() > 0){
                Node nodoVisitado = cola.getNodo();
                if(nodoVisitado.visitado == false){
                    nodoVisitado.visitado = true;
                    System.out.print(nodoVisitado.getDato()+",");
                    llenarColaNodosAdyacentes(nodoVisitado);
                }
            }
        }
    }
}
