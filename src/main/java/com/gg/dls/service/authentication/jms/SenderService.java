package com.gg.dls.service.authentication.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class SenderService {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(SenderService.class);

  @Autowired
  private JmsTemplate jmsTemplate;

  public void send(String message) {
    LOGGER.info("sending message='{}'", message);
    jmsTemplate.convertAndSend("helloworld.q", message);
  }
}
