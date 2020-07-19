package com.epg.EPGAPI.Controller;

import com.epg.EPGAPI.Model.Channel;
import com.epg.EPGAPI.dao.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class ChannelController {

    @Autowired
    private final ChannelRepository channelRepository;

    ChannelController(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @GetMapping("/channels")
    public Collection<Channel> channels() {
        List<Channel> allChannels = channelRepository.findAll();
        return allChannels;
    }

    @PostMapping("/channels/create")
    public String createChannel(@RequestBody Channel channel) {
        Channel newChannel = channelRepository.save(channel);
        return newChannel.getId();
    }
}
