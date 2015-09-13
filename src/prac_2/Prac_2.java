
package prac_2;
import java.util.Scanner;




public class Prac_2 {
Scanner leer=new Scanner(System.in);
String nombre,cantidad_aux,costo_aux;
int cantidad=0, costo=0, cant_ventas=0,cant_gan=0;
void inicio(){
      System.out.println("======================");
      System.out.println("Por favor seleccion una opcion:");
      System.out.println("|1| Agregar producto");
      System.out.println("|2| Buscar Producto");
      System.out.println("|3| Eliminar producto");
      System.out.println("|4| Mostrar Inventario");
      System.out.println("|5| Realizar venta");
      System.out.println("|6| Ganacias Totales");
      System.out.println("|7| Salir");
}
    
void agregar(){
boolean Flag=true;
System.out.println("======================");
System.out.println("Por favor Ingrese:");
do{
  try{
        System.out.println("Nombre Producto:");
        this.nombre=leer.nextLine();
        if(this.nombre.matches("[a-z]*")){Flag=true;}
        else {System.out.println("Error de entrada, intente de nuevo!!");Flag=false;}
        if(this.nombre.equals("")) { System.out.println("Error de entrada, intente de nuevo!!");Flag=false;}
   }catch(Exception e) {System.out.println("Error de Entrada  "+e.getMessage());Flag=false;}//problema en el enlace de conexion
}while(Flag==false);
do{
 try{
        System.out.println("Cantidad:");
        this.cantidad_aux=leer.nextLine();
        if(this.cantidad_aux.matches("[0-9]*")){Flag=true;cantidad=Integer.parseInt(cantidad_aux);}
        else {System.out.println("Error de entrada, intente de nuevo!!");Flag=false;}
        if(this.cantidad_aux.equals("")) { System.out.println("Error de entrada, intente de nuevo!!");Flag=false;}
 }catch(Exception e) {System.out.println("Error de Entrada  "+e.getMessage());Flag=false;}//problema en el enlace de conexion
 }while(Flag==false);
do{
 try{
        System.out.println("Costo:");
        this.costo_aux=leer.nextLine();
        if(this.costo_aux.matches("[0-9]*")){Flag=true;costo=Integer.parseInt(costo_aux);}
        else {System.out.println("Error de entrada, intente de nuevo!!");Flag=false;}
        if(this.nombre.equals("")) { System.out.println("Error de entrada, intente de nuevo!!");Flag=false;}
 }catch(Exception e) {System.out.println("Error de Entrada  "+e.getMessage());Flag=false;}//problema en el enlace de conexion
 }while(Flag==false);
}
    void mostrar(){
System.out.println("Nombre Producto: "+this.nombre+" Cantidad: "+this.cantidad+" Costo: "+this.costo);
 }
    void mostrar_2(){
System.out.println("Nombre Producto: "+this.nombre+" Cantidad Vendidas: "+this. cant_ventas+" Ganacia: "+this.cant_gan);
 }
    
    String validacion(){
        boolean Flag=true;
        String Buscar="nada";
    do{
        try{
            System.out.println("Ingrese Nombre producto: ");
            Buscar=leer.nextLine();
            if(Buscar.matches("[a-z]*")){Flag=true;}
            else {System.out.println("Error de entrada, intente de nuevo!!");Flag=false;}
            if(Buscar.equals("")) { System.out.println("Error de entrada, intente de nuevo!!");Flag=false;}
            }catch(Exception e) {System.out.println("Error de Entrada  "+e.getMessage());Flag=false;}//problema en el enlace de conexion
         }while(Flag==false);
    return Buscar;
    }
       

    public static void main(String[] args) {
    Scanner leer=new Scanner(System.in);
    Prac_2 producto[]=new Prac_2[100];
    int suma=0;
        for (int i=0;i<producto.length;i++){
            producto[i]=new Prac_2();
        }
   int  cont=0,aux=0, Tcant=0, Tgan=0, cant=0,opc_int=0;
    String Buscar,opc; 
    boolean Flag=true;
   do{       
    producto[cont].inicio();
    opc=leer.nextLine();
    try{
    if(opc.matches("[0-9]*")){
    opc_int=Integer.parseInt(opc);
    if(opc_int<1 || opc_int >7)System.out.println("Elección NO valida,intente de nuevo!!");
        }
    else {System.out.println("Error de entrada, intente de nuevo!!");}
    } catch(Exception e){
                System.out.println("Error de Entrada  "+e.getMessage());//problema en el enlace de conexion
            }
    //----------------------------------------------------
  switch(opc_int){
      case 1:{// agregar
      producto[cont].agregar();
      cont++;
      break;
      }
      case 2:{// buscar
      System.out.println("=======BUSCAR===============");
      Buscar= producto[0].validacion();
      for(aux=0;aux<cont;aux++){
           if(Buscar.equals(producto[aux].nombre)){
                 producto[aux].mostrar();
                 aux=1000;
            }
        }
      if(aux!=1001){System.out.println("Producto NO exite");}
   
      break;
      }
      case 3:{// eliminar
      System.out.println("=======ELIMINAR===============");
       Buscar= producto[0].validacion();
       for(aux=0;aux<cont;aux++){
         if(Buscar.equals(producto[aux].nombre)){
         System.out.println("Producto Si exite, Eliminacion OK");
         producto[aux].nombre= "*";
         producto[aux].costo=0;
         producto[aux].cantidad=0;
         aux=1000;
         }
     }
      if(aux!=1001){System.out.println("Producto NO exite");}
       break;
      }
      case 4:{//mostrar
          System.out.println("==========MOSTRAR============");
      for(aux=0;aux<cont;aux++){
        // System.out.println("El producto ["+(aux+1) +"] es:")
          if(producto[aux].nombre.equals("*")){ System.out.println("espacio");}
          else producto[aux].mostrar();
          
      }
       break;
      }
      case 5:{//venta
       System.out.println("=========VENTA=============");
       Buscar= producto[0].validacion();       
       for(aux=0;aux<cont;aux++){
         if(Buscar.equals(producto[aux].nombre)){
             System.out.println("Cantidad: ");
             cant=leer.nextInt();
             leer.nextLine();
          if(producto[aux].cantidad>= cant){
              System.out.println("mayor ");
              producto[aux].cantidad-=cant;
              Tcant+=cant;
              Tgan=Tgan+(cant*producto[aux].costo);
              System.out.println("Producto Si exite, Venta OK");
              producto[aux].cant_ventas+=cant;
              producto[aux].cant_gan+=(cant*producto[aux].costo);
         }
           else    System.out.println("No hay esa Cantidad disponible"); 
         aux=1000;
         }
     }
      if(aux!=1001){System.out.println("Producto NO exite");}
      break;
      }
      case 6:{// ganacias
      System.out.println("==========GANANCIAS============");
      for(aux=0;aux<cont;aux++){
       if( producto[aux].cant_ventas!=0)    producto[aux].mostrar_2();
      }
      System.out.println("T Vendidos:"+Tcant+" T Ganancia: "+Tgan);
      break;
      }
      case 7:{
               opc_int=-1;
      break;
      }
  }      
        
    } while(opc_int!=-1);
    }
    
}





