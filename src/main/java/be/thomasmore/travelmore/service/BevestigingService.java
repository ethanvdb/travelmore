package be.thomasmore.travelmore.service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class BevestigingService {

    private static final String HOST = "smtp.gmail.com";
    private static final int PORT = 465;
    private static final String USER = "travelmorebevestiging";
    private static final String PASSWORD = "travelmore123";
    private static final String FROM = "travelmorebevestiging <travelmorebevestiging@gmail.com>";

    private static Session mailSession;

    private static BevestigingService service = null;

    private BevestigingService() {
        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", HOST);
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.from", FROM);
        props.put("mail.smtps.quitwait", "false");

        mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);
    }

    public static void stuurBevestiging(String ontvanger, String onderwerp, String tekst) throws MessagingException {


        if ( service == null ) {
            service = new BevestigingService();
        }

        MimeMessage mimeMessage = new MimeMessage(mailSession);

        mimeMessage.setFrom(new InternetAddress(FROM));
        mimeMessage.setSender(new InternetAddress(FROM));
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(ontvanger));
        mimeMessage.setSubject(onderwerp);
        mimeMessage.setContent(tekst, "text/html; charset=utf-8");

        Transport transport = mailSession.getTransport("smtps");
        transport.connect(HOST, PORT, USER, PASSWORD);
        transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.TO));
        transport.close();

    }





}
