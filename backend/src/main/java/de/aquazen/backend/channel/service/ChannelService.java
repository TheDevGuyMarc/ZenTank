package de.aquazen.backend.channel.service;

import de.aquazen.backend.channel.domain.Channel;
import de.aquazen.backend.channel.exception.ChannelNotFoundException;
import de.aquazen.backend.channel.repository.ChannelEntity;
import de.aquazen.backend.channel.repository.ChannelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelService {
    private final ChannelRepository channelRepository;

    public ChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public List<Channel> findAllChannels() {
        return this.channelRepository.findAll()
            .stream()
            .map(Channel::new)
            .toList();
    }

    public Optional<Channel> findChannelById(Long id) {
        return this.channelRepository.findById(id)
            .map(Channel::new);
    }

    public Channel createChannel(Channel channel) {
        return new Channel(this.channelRepository.saveAndFlush(new ChannelEntity(channel)));
    }

    public Channel updateChannel(Long id, Channel channel) {
        Optional<Channel> existingElement = this.channelRepository.findById(id)
            .map(Channel::new);

        if (existingElement.isPresent()) {
            Channel updatedElement = existingElement.get();

            updatedElement.setId(channel.getId());
            updatedElement.setName(channel.getName());
            updatedElement.setColor(channel.getColor());
            updatedElement.setManual(channel.isManual());
            updatedElement.setMin(channel.getMin());
            updatedElement.setMax(channel.getMax());
            updatedElement.setState(channel.isState());
            updatedElement.setPin(channel.getPin());
            updatedElement.setValue(channel.getValue());
            updatedElement.setType(channel.getType());
            updatedElement.setLight(channel.getLight());

            return new Channel(this.channelRepository.saveAndFlush(new ChannelEntity(updatedElement)));
        }
        else {
            throw new ChannelNotFoundException("Couldn't find the channel entry you requested with id: " + id);
        }
    }

    public void deleteChannel(Long id) {
        this.channelRepository.deleteById(id);
    }

    public void history(Long id) {
        /* TODO: Implement this method */

        /*
         * Concept:
         * This should return the usage history of the light
         */
    }
}
