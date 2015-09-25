package com.xebia.controller;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.naming.InitialContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.domain.Message;
import com.xebia.domain.Response;

@RestController
public class TopicController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TopicController.class);
	private static final String JMS_CONNECTION_FACTORY = "java:comp/env/jmsConnectionFactory";
	private static final String TOPIC = "java:comp/env/jndi/myTopic";
	private static final String SUCCESS = "Success";
	private static final String FAILED = "Failed";

	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	public Response sendMessage(@RequestBody Message message) throws Exception {
		try {
			sendMessageToWmqTopic(message);
		} catch (Exception e) {
			LOGGER.error("Exception Occurred", e);
			return new Response(FAILED);
		}
		return new Response(SUCCESS);
	}

	private void sendMessageToWmqTopic(final Message message) throws Exception {
		ConnectionFactory cf1 = (ConnectionFactory) new InitialContext().lookup(JMS_CONNECTION_FACTORY);
		Connection con = cf1.createConnection();
		con.start();
		Session session = (Session) con.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
		Topic topic = (Topic) new InitialContext().lookup(TOPIC);
		MessageProducer messageProducer = session.createProducer(topic);
		TextMessage msg = session.createTextMessage(message.getMessage());
		messageProducer.send(msg);
		if (con != null)
			con.close();
	}
}