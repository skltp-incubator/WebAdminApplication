package se.skltp.adminapplication.modules.verify.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import se.skltp.adminapplication.modules.verify.domain.VerifiedUrlList;


@RestController
@RequestMapping(method = RequestMethod.GET, value = "/api/verifyUrl")
public class VerifyControllerImpl {

  private static Logger LOG = LoggerFactory.getLogger(VerifyControllerImpl.class);

	//@Autowired
	//private JMSDestinationsStatsService jmsDestinationsStatsService;
	//String command = "curl -vk --cert ./qa.esb.ntjp.sjunet.org.pem --key qa.esb.ntjp.sjunet.org.key https://ntjp-test.kry.se/api/getcarecontacts";

	@RequestMapping
	@ResponseStatus(HttpStatus.OK)
	public VerifiedUrlList getAllVerifiedUrls() {
	  VerifiedUrlList list = new VerifiedUrlList();
		return list;
	}
}
