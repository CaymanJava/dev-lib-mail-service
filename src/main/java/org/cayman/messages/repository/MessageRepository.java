package org.cayman.messages.repository;


import org.cayman.messages.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer>{
    Long countByNewOne(boolean newOne);
}
