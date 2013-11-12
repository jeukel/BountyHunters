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

package edu.itcr.bountyhunters;

public class HowToFill extends GrafosUI{
    
    static Graph grafo;

    public static void llenandoGrafo(){
        grafo = new Graph();

        grafo.adjuntarNodo(new Node("A"));
        grafo.adjuntarNodo(new Node("B"));
        grafo.adjuntarNodo(new Node("C"));
        grafo.adjuntarNodo(new Node("D"));
        grafo.adjuntarNodo(new Node("F"));

        grafo.crearEnlaces("A","B");// de A hacia B
        grafo.crearEnlaces("B","A");// de B hacia A
        /*
         * Lo anterior lo hacemos por ser un grafo no dirigido...
         * En caso de ser un grafo con peso esto no estaria muy bien que digamos
        */

        grafo.crearEnlaces("A","C");
        grafo.crearEnlaces("C","A");

        grafo.crearEnlaces("A","F");
        grafo.crearEnlaces("F","A");

//        grafo.crearEnlaces("B","A");//Esta enlace ya existe
//        grafo.crearEnlaces("A","B");//Esta enlace ya existe

        grafo.crearEnlaces("B","F");
        grafo.crearEnlaces("F","B");

//        grafo.crearEnlaces("C","A");//Esta enlace ya existe
//        grafo.crearEnlaces("A","C");//Esta enlace ya existe

        grafo.crearEnlaces("C","D");
        grafo.crearEnlaces("D","C");

//        grafo.crearEnlaces("D","C");//Esta enlace ya existe
//        grafo.crearEnlaces("C","D");//Esta enlace ya existe

//        grafo.crearEnlaces("F","A");//Esta enlace ya existe
//        grafo.crearEnlaces("A","F");//Esta enlace ya existe

//        grafo.crearEnlaces("F","B");//Esta enlace ya existe
//        grafo.crearEnlaces("B","F");//Esta enlace ya existe

    }


    public static void main(String []args){

        llenandoGrafo();

        PlanningRoute recorrido = new PlanningRoute();
        System.out.println("----------------------------------------------");
        System.out.println("Recorrido en profundidad");
        recorrido.recorrerProfundidadIterativo(grafo,grafo.buscarNodo("A"));
        System.out.println();

        llenandoGrafo();

        System.out.println("----------------------------------------------");
        System.out.println("Recorrido en Amplitud");
        recorrido.recorrerAmplitud(grafo,grafo.buscarNodo("A"));
        System.out.println();
        System.out.println("----------------------------------------------");
    }
}
