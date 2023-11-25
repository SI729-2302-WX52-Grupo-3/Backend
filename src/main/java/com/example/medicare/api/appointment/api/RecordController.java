package com.example.medicare.api.appointment.api;

import com.example.medicare.api.appointment.domain.model.entities.Record;
import com.example.medicare.api.appointment.domain.service.RecordService;
import com.example.medicare.api.appointment.mapping.RecordMapper;
import com.example.medicare.api.appointment.resource.CreateRecordResource;
import com.example.medicare.api.appointment.resource.RecordResource;
import com.example.medicare.api.shared.exception.InternalServerErrorException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/records")
public class RecordController {

    private final RecordService recordService;
    private final RecordMapper recordMapper;

    @PostMapping
    public ResponseEntity<RecordResource> save(@RequestBody CreateRecordResource resource){
        return new ResponseEntity<>(
                recordMapper.toResource(recordService.save(recordMapper.toEntity(resource))),
                HttpStatus.CREATED
    );
    }

    @GetMapping
    public ResponseEntity<List<Record>> fetchAll(){
        return ResponseEntity.ok(recordService.fetchAll());
    }

    @PutMapping("/{id}")
    public Record update(@RequestBody Record record, @PathVariable("id") Integer id){
        return recordService.update(record, id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecordResource> fetchById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(
                recordMapper.toResource(recordService.fetchById(id)),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id){
        if(recordService.deleteById(id))
            return ResponseEntity.ok().build();
        throw new InternalServerErrorException("Record", "id", String.valueOf(id), "deleted");
    }
}
