package hus.oop.lab11.visitor.example.vistors;

import hus.oop.lab11.visitor.example.structure.OperaMailClient;
import hus.oop.lab11.visitor.example.structure.SquirrelMailClient;
import hus.oop.lab11.visitor.example.structure.ZimbraMailClient;

public class MailClientVisitorTest {
    private MacMailClientVisitor macVisitor;
    private LinuxMailClientVisitor linuxVisitor;
    private WindowsMailClientVisitor windowsVisitor;
    private OperaMailClient operaMailClient;
    private SquirrelMailClient squirrelMailClient;
    private ZimbraMailClient zimbraMailClient;

    public static void main(String[] args) {
        MailClientVisitorTest test = new MailClientVisitorTest();
        test.setup();
        test.testOperaMailClient();
        test.testSquirrelMailClient();
        test.testZimbraMailClient();
    }

    public void setup() {
        macVisitor = new MacMailClientVisitor();
        linuxVisitor = new LinuxMailClientVisitor();
        windowsVisitor = new WindowsMailClientVisitor();
        operaMailClient = new OperaMailClient();
        squirrelMailClient = new SquirrelMailClient();
        zimbraMailClient = new ZimbraMailClient();
    }

    public void testOperaMailClient() {
        System.out.println("-----Testing Opera Mail Client for different environments-----");
        operaMailClient.accept(macVisitor);
        operaMailClient.accept(linuxVisitor);
        operaMailClient.accept(windowsVisitor);
    }

    public void testSquirrelMailClient() {
        System.out.println("\n-----Testing Squirrel Mail Client for different environments-----");
        squirrelMailClient.accept(macVisitor);
        squirrelMailClient.accept(linuxVisitor);
        squirrelMailClient.accept(windowsVisitor);
    }

    public void testZimbraMailClient() {
        System.out.println("\n-----Testing Zimbra Mail Client for different environments-----");
        zimbraMailClient.accept(macVisitor);
        zimbraMailClient.accept(linuxVisitor);
        zimbraMailClient.accept(windowsVisitor);
    }
}
