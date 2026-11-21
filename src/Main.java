import dip.EmailSender;
import dip.MessageSender;
import dip.NotificationService;
import dip.SmsSender;
import isp.OldPrinter;
import isp.Printer;
import lsp.Bird;
import lsp.Flyable;
import lsp.Penguin;
import lsp.Sparrow;
import ocp.DiscountCalculator;
import ocp.RegularDiscount;
import ocp.SuperVipDiscount;
import ocp.VipDiscount;
import srp.ReportManager;
import srp.ReportSaver;

import java.util.List;

public class Main {
    public static void main(String[] args){
        //SRP
        System.out.println("----SRP----");
        ReportSaver saver = new ReportSaver();
        ReportManager manager = new ReportManager(List.of(5, 10, 15, 20), saver);
        manager.generateReport();

        //OCP
        System.out.println("\n---OCP---");
        DiscountCalculator calculator = new DiscountCalculator();
        System.out.println("Regular: " + calculator.calculateDiscount(new RegularDiscount(), 1000));
        System.out.println("VIP: " + calculator.calculateDiscount(new SuperVipDiscount(), 1000));
        System.out.println("SuperVIP: " + calculator.calculateDiscount(new SuperVipDiscount(), 1000));

        //LSP
        System.out.println("\n---LSP---");
        Sparrow sparrow = new Sparrow();
        Penguin penguin = new Penguin();

        displayBird(sparrow);
        displayBird(penguin);
        displayFlyable(sparrow);

        //ISP
        System.out.println("\n---ISP---");
        Printer printer = new OldPrinter();
        printer.print("Отчет за неделю");

        //DIP
        System.out.println("\n---DIP---");
        MessageSender emailSender = new EmailSender();
        NotificationService emailService = new NotificationService(emailSender);
        emailService.send("Ваш заказ готов к выдаче!");

        MessageSender smsSender = new SmsSender();
        NotificationService smsService = new NotificationService(smsSender);
        smsService.send("Код подтверждения: 1234");
    }
    public static void displayBird(Bird bird){
        bird.eat();
    }
    public static void displayFlyable(Flyable flyable){
        flyable.fly();
    }
}

