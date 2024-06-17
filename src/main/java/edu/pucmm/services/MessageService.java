package edu.pucmm.services;

import edu.pucmm.data.Message;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MessageService {
    public List<Message> listAllMessage();
    public Message getMessageById(Long id);

    public Message createMessage(Message message);
    public Message updateMessage(Message message);
    public void deleteMessage(Long id);
}
