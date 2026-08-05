
public class Persona {
    int dni;      //datos private, todos los datos de los atributos de la clase son privados(encapsulados)
    String nombre;
    int sueldo;

    Persona(){
        dni= 0;
        nombre=" ";
        sueldo=0;

    }

    Persona(int dni, String nombre,int sueldo ){
        this.dni=dni;
        this.nombre=nombre;
        this.sueldo=sueldo;
    }

    void setsueldo (int sueldo){
        this.sueldo = sueldo;
    }

    int getsueldo(){

        return sueldo;
    }
    


    boolean sueldomayor(){
        if(sueldo > 1000){
            return true;
        }else{
            return false;
        }
    }

}

