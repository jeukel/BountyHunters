package edu.itcr.bountyhunters;

/*
 * Graph.java
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

import java.util.ArrayList;

public class Graph{
    private ArrayList<Node> listaNodo;

    public Graph(){
        listaNodo = new ArrayList<Node>();
    }
    public void adjuntarNodo(Node nodo){
        listaNodo.add(nodo);
    }
    public void crearEnlaces(Object nombreNodoPadre,Object nombreNodoHijo){
        Node padre = buscarNodo(nombreNodoPadre);
        Node hijo = buscarNodo(nombreNodoHijo);
        if(padre != null && hijo != null){
            padre.setNodo(hijo);
        }
    }
    public Node buscarNodo(Object nombreNodo){
        Node temp = null;
        for(int i = 0;i < listaNodo.size(); i++){
            if(((String)nombreNodo).equals((String)listaNodo.get(i).getDato())){
                return listaNodo.get(i);
            }
        }
        return temp;
    }
}
