/*
 * Copyright (c) 2014 Center for eHalsa i samverkan (CeHis).
 * 								<http://cehis.se/>
 *
 * This file is part of SKLTP.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
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
