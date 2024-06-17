package edu.pucmm.services;

import edu.pucmm.data.Message;
import edu.pucmm.data.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> listAllMessage() {
        return messageRepository.findAll();
    }

    @Override
    public Message getMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message updateMessage(Message message) {
        Message messageDB = messageRepository.findById(message.getId()).orElse(null);
        if (messageDB == null) {
            return null;
        }
        messageDB.setName(message.getName());
        messageDB.setText(message.getText());
        messageDB.setEmail(message.getEmail());
        return messageRepository.save(messageDB);
    }

    @Override
    public void deleteMessage(Long id) {
        Message messageDB = getMessageById(id);
        if (messageDB != null) {
            messageRepository.deleteById(id);
        }

    }
}
