package DesignPattern.Facade;

/**
 * Created by donezio on 2/1/19.
 */
public class FacadeExample {

    /*
               As the name suggests, it means the face of the building.
               The people walking past the road can only see this glass face of the building.
               They do not know anything about it, the wiring, the pipes and other complexities.
               It hides all the complexities of the building and displays a friendly face.

               Example : Java, the interface JDBC can be called a facade because,
               we as users or clients create connection using the ?java.sql.Connection? interface,
               the implementation of which we are not concerned about. The implementation is left to the vendor of driver.

               Usually one facade, use singleton
     */

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.wrapOperation();
    }

    public static class SystemA {
        public void operationA(){
            System.out.println("operation a...");
        }
    }

    public static class SystemB {
        public void operationB() {
            System.out.println("operation b...");
        }
    }

    public static class SystemC {
        public void operationC() {
            System.out.println("operation c...");
        }
    }

    public static class Facade {
        public void wrapOperation() {
            SystemA a = new SystemA();
            a.operationA();
            SystemB b = new SystemB();
            b.operationB();
            SystemC c = new SystemC();
            c.operationC();
        }
    }
}
