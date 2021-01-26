package celular;


public class Main {
  public static void main(String[] args) {
    Agenda newAgenda = new Agenda();
    newAgenda.addContact("maria", 1);
    newAgenda.addContact("carlos", 2);
    newAgenda.addContact("gustavo", 3);
    newAgenda.listar();
    newAgenda.update("gustavo", "carla", 99);    
    newAgenda.update("gustav", "carla", 99);
    newAgenda.listar();
    newAgenda.delete("maria");
    newAgenda.listar();
    
  }
}