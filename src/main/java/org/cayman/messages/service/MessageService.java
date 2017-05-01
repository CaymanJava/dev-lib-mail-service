package org.cayman.messages.service;


import lombok.Data;
import org.cayman.messages.model.Message;
import org.cayman.messages.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAllMessage() {
        return messageRepository.findAll();
    }

    public Long getNewMessageCount() {
        return messageRepository.countByNewOne(true);
    }

    public boolean save(Message message) {
        return messageRepository.save(message) != null;
    }

    public boolean changeStatus(int id) {
        Message one = messageRepository.findOne(id);
        one.setNewOne(!one.isNewOne());
        return save(one);
    }

    public void delete(int id) {
        messageRepository.delete(id);
    }
}
