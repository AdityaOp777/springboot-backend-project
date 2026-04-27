package com.marvellous.MarvellousPortal.controller;

import com.marvellous.MarvellousPortal.Entity.BatchEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;      // It is a parent class of ArrayList
import java.util.Map;   // parent class of HashMap

@RestController  // Object automatically tayar karayla bhag padto tyacha Object Bean mahnun consider kela jato hyachi sagli jabadari spring boot gheto (tells spring that this class will handle web requests and return data as json
@RequestMapping("/Batches")
public class BatchEntryController
{
    private Map<Long, BatchEntry> batchentries = new HashMap<>();   // Batchentries navacha hashmap ahe jya madhe don gosti ahet, key as a long and value as a BatchEntry navachya class cha object ahe

    //  select *from Batches;

    @GetMapping()   // Now we are going to fetch the data
    public List<BatchEntry> getAll()        // It means I want to create ArrayList of type BatchEntry
    {
        return new ArrayList<>(batchentries.values());   // batchentries.values() returns a Collection<BatchEntry>- all the values from the map
    }

    // HTTP : POST
    // C : create
    // insert into batches value(1,PPA,25000)

    @PostMapping   // POST - Data Takayla // This Annotations maps HTTP POST Reqoest to the createEntry method
    public boolean createEntry(@RequestBody BatchEntry myentry) // means the method will recieve data(like json)from the body of an HTTP POST Request
    {
        batchentries.put(myentry.getId(), myentry);  // put is use to insert  // .put(key, value) methods adds or updats an entry in the map // batchentries.put(1L, new BatchEntry(1, PPA, 25000));
        return true;
    }

    // HTTP : GET
    // R : Read
    //select *from Batches where id = 1

    @GetMapping("/id/{myid}") // http://localhost:8090/Batches/id/1 or 2 or 3
    public BatchEntry getBatchEntryById(@PathVariable Long myid)     // Gets value from URL(like index or ID)
    {
        return batchentries.get(myid);  // get fetch the data or read the data
    }

    // HTTP : DELETE
    // D : Delete
    // delete from batches where id = 1

    @DeleteMapping("/id/{myid}")
    public BatchEntry deleteEntryById(@PathVariable Long myid)
    {
        return batchentries.remove(myid);
    }

    // HTTP : PUT
    // update Batches set fees = 30000 where id = 1

    @PutMapping("/id/{myid}")
    public BatchEntry UpdateEntryById(@PathVariable Long myid, BatchEntry myentry)
    {
        return batchentries.put(myid, myentry);
    }
}
