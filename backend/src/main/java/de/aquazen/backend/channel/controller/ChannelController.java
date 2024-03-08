package de.aquazen.backend.channel.controller;

import de.aquazen.backend.channel.domain.Channel;
import de.aquazen.backend.channel.service.ChannelService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/channels")
public class ChannelController {
    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping
    public List<ChannelDTO> list() {
        return this.channelService.findAllChannels()
                .stream()
                .map(ChannelDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public ChannelDTO read(@PathVariable @Min(1) Long id) {
        return this.channelService.findChannelById(id)
                .map(ChannelDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public ChannelDTO create(@RequestBody @Valid @NotNull @NotEmpty Channel channel) {
        return new ChannelDTO(this.channelService.createChannel(channel));
    }

    @PutMapping("/{id}")
    public ChannelDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Channel channel) {
        return new ChannelDTO(this.channelService.updateChannel(id, channel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.channelService.deleteChannel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/history")
    public ResponseEntity<Void> history(@PathVariable @Min(1) Long id) {
        this.channelService.history(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
