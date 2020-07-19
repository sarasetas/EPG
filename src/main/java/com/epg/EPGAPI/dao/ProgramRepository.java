package com.epg.EPGAPI.dao;

import com.epg.EPGAPI.Model.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProgramRepository extends JpaRepository<Program, String> {

    Collection<Program> findByChannelId(String channelId);
}
