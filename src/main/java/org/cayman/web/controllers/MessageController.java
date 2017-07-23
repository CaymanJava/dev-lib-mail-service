package org.cayman.web.controllers;


import lombok.extern.slf4j.Slf4j;
import org.cayman.dto.MessageRequestDto;
import org.cayman.messages.model.Message;
import org.cayman.messages.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message")
@Slf4j
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> getAll() {
        return messageService.getAllMessage();
    }

    @RequestMapping(value = "new/count", method = RequestMethod.GET)
    public int getNewMessageCount() {
        return (int) messageService.getNewMessageCount();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveMessage(@RequestBody MessageRequestDto messageDto) {
        log.info("Receive message: " + messageDto);
        return messageService.save(Message
                .builder()
                .userId(messageDto.getUserId())
                .email(messageDto.getEmail())
                .message(messageDto.getMessage())
                .ip(messageDto.getIp())
                .sendDateTime(LocalDateTime.now())
                .newOne(true)
                .build());
    }

    @RequestMapping(value = "mark", method = RequestMethod.GET)
    public boolean changeStatus(@RequestParam("id") int id) {
        return messageService.changeStatus(id);
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public boolean delete(@RequestParam("id") int id) {
        messageService.delete(id);
        return true;
    }
}
