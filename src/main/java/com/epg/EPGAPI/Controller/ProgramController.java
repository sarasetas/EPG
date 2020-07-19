package com.epg.EPGAPI.Controller;

import com.epg.EPGAPI.Model.Program;
import com.epg.EPGAPI.dao.ProgramRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ProgramController {

    @Autowired
    ProgramRepository repository;

    ProgramController(ProgramRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/program/create")
    public String createProgram(@RequestBody Program program) {
        Program newProgram = repository.save(program);
        return newProgram.getId();
    }

    @GetMapping(value = "/program/{id}")
    public Program findProgramById(@PathVariable String id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "program"));
    }

    @GetMapping("/program")
    public Collection<Program> getProgramsByChannelId(@RequestParam(value = "channelid") String channelId) {
        return repository.findByChannelId(channelId);
    }

    @DeleteMapping("/program/{id}")
    public void deleteProgram(@PathVariable String id) {
        repository.deleteById(id);
    }

    @PutMapping("program/{id}")
    public void updateProgram(@RequestBody Program newProgram, @PathVariable String id) {
        Program program = repository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(id, "program"));

        program.setChannelId(newProgram.getChannelId());
        program.setDescription(newProgram.getDescription());
        program.setImageUrl(newProgram.getImageUrl());
        program.setTittle(newProgram.getTittle());
    }

}
