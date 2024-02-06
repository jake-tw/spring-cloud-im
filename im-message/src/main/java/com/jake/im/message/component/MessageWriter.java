package com.jake.im.message.component;

import com.jake.im.common.util.ConstantUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageWriter {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(), key = ConstantUtil.Rabbit.MESSAGE_WRITE_QUEUE_KEY, exchange = @Exchange(value = ConstantUtil.Rabbit.MESSAGE_WRITE_EXCHANGE, type = ExchangeTypes.DIRECT)), concurrency = "8-16")
    @RabbitHandler
    public void receiveMessage(Message message) {

    }
}
