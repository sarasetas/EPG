package com.epg.EPGAPI.dao;

import com.epg.EPGAPI.Model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, String> {
}
