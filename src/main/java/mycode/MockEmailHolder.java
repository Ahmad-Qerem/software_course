package mycode;
import static org.mockito.Mockito.*;
public class MockEmailHolder {
private EmailSender emailSender=mock(EmailSender.class);
public MockEmailHolder() {
	Homes.setEmailService(emailSender);
}
public EmailSender getEmailSender(){
	return emailSender;
}
public void setEmailService(EmailSender emailSender) {
	this.emailSender=emailSender;
}
}
