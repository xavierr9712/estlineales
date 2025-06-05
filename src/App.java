import controllers.QueueG;
import controllers.StackG;
import models.*;

public class App {
    public static void main(String[] args) throws Exception {

        StackG <Integer> pilaG = new StackG<Integer>();

        pilaG.push(5);
        pilaG.push(8);
        pilaG.push(-1);
        pilaG.push(5);
        System.out.println("Tam = " + pilaG.size());
        pilaG.pop();
        System.out.println("Tam = " + pilaG.size());
        pilaG.printStack();

        System.out.println("");

        Persona p1 =  new Persona("Juan");
        Persona p2 =  new Persona("Maria");
        Persona p3 =  new Persona("Pedro");
        Persona p4 =  new Persona("David");

        QueueG<Persona> colaPersona = new QueueG<Persona>();
        colaPersona.add(p1);
        colaPersona.add(p2);
        colaPersona.add(p3);
        colaPersona.add(p4);

        

        System.out.println("Persona atendida -> " + colaPersona.remove());
        colaPersona.printCola();;
        

        Persona pB = colaPersona.findBYName("Juan");
        System.out.println("Persona encontrada -> " + (pB !=null? pB.getName() : "ninguna"));

        
        Persona pE = colaPersona.deleteBYName("Pedro");
        System.out.println("Persona eliminada -> " + (pE !=null? pE.getName() : "ninguna"));
        colaPersona.printCola();
        

    }
}


