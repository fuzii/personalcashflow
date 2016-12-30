package util;

import com.sendgrid.*;
import java.io.IOException;

public class SendGridEmail {
	
	
	public static void Send(String from, String to, String subject, String content) throws IOException{
		
		Mail mail = new Mail(new Email(from), subject, new Email(to), new Content("text/plain", content));

		SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
		Request request = new Request();

		try {

			request.method = Method.POST;
			request.endpoint = "mail/send";
			request.body = mail.build();
			Response response = sg.api(request);
			System.out.println(response.statusCode);
			System.out.println(response.body);
			System.out.println(response.headers);

		} catch (IOException ex) {
			throw ex;
		}

	}

}
