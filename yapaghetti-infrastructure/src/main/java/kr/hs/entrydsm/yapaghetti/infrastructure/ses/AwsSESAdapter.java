package kr.hs.entrydsm.yapaghetti.infrastructure.ses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsync;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;
import kr.hs.entrydsm.yapaghetti.domain.auth.spi.SendMailPort;
import kr.hs.entrydsm.yapaghetti.global.annotation.Adapter;
import kr.hs.entrydsm.yapaghetti.global.property.AwsSesProperties;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Adapter
public class AwsSESAdapter implements SendMailPort {

	private final AmazonSimpleEmailServiceAsync amazonSimpleEmailServiceAsync;
	private final AwsSesProperties awsSesProperties;

	@Override
	public void sendAuthCode(String email, String authCode) {
			Message message = new Message()
				.withSubject(createContent("test"))
				.withBody(new Body()
					.withHtml(createContent(authCode)));

			SendEmailRequest request = new SendEmailRequest()
				.withDestination(new Destination().withToAddresses(email))
				.withSource(awsSesProperties.getSesSource())
				.withMessage(message);

			amazonSimpleEmailServiceAsync.sendEmailAsync(request);
	}

	private Content createContent(String text) {
		return new Content()
			.withCharset("UTF-8")
			.withData(text);
	}
}
