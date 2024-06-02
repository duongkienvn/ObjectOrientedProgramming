package hus.oop.lab11.visitor.example.structure;

import hus.oop.lab11.visitor.example.vistors.MailClientVisitor;

public interface MailClient {
    void sendMail(String[] mailInfo);
    void receiveMail(String[] mailInfo);
    boolean accept(MailClientVisitor visitor);
}
