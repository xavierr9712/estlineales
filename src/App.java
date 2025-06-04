import controllers.QueueG;
import controllers.StackG;
import models.*;

public class App {
    public static void main(String[] args) throws Exception {

        StackG pilaG = new StackG<Integer>();

        pilaG.push(5);
        pilaG.push(8);
        pilaG.push(-1);
        pilaG.push(5);
        System.out.println("Tam = " + pilaG.size());
        pilaG.pop();
        System.out.println("Tam = " + pilaG.size());
        pilaG.printStack();

        Persona p1 =  new Persona("juan");
        Persona p2 =  new Persona("Maria");
        Persona p3 =  new Persona("Pedro");

        QueueG<Persona> colaPersona = new QueueG<Persona>();
        colaPersona.add(p1);
        colaPersona.add(p2);
        colaPersona.add(p3);
        System.out.println("Persona atendida ->" + colaPersona.remove());
        colaPersona.printCola();;

        Persona pB = new colaPersona.findBYName();
        System.out.println("Persona encontrada ->" + pB !=null? pB : "ninguna");

        //retirna persona si encontro
        // retotna null si no elimino nada
        Persona pE = new colaPersona.deleteBYName("Pedro");
        System.out.println("Persona encontrada ->" + pE !=null? pE : "ninguna");
        colaPersona.printCola();
        // retorna persona si eliminada
        //

    }
}
