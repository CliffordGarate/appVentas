/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Com.Tienda.DAO;

import Com.Tienda.Bean.Tablita;
import java.util.ArrayList;


public class TablitaFuncion {
  private ArrayList<Tablita> prod;
  
  public TablitaFuncion(){
  prod = new ArrayList<Tablita>();
  }
  public void adicionar (Tablita x){
  prod.add(x);
  }
  public void eliminar(Tablita x){
  prod.remove(x);
  }
  public Tablita obtener(int pos){
  return prod.get(pos);
  }
 
  
  public int tamaño(){
  return prod.size();
  }
  public Tablita buscar(int cod){
  for(int i = 0; i<prod.size();i++){
  if(cod==prod.get(i).getId()){
  return prod.get(i);
  }
  }
  return null;
 
  }
}
