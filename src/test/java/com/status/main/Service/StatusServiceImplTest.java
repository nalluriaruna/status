package com.status.main.Service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.status.main.entity.Progress;
import com.status.main.entity.Status;
import com.status.main.service.StatusService;
import com.status.main.service.StatusServiceImpl;

import java.util.List;

@SpringBootTest

public class StatusServiceImplTest {
	@Autowired
    private StatusService statusService;

    @BeforeEach
    public void setUp() {
        
       
    }

    @Test
    public void testCreateStatus() {
        
        Status status = new Status(1, "New Status", Progress.BACKLOG);

        try {
            Status createdStatus = statusService.createStatus(status);
            Assertions.assertNotNull(createdStatus);
            Assertions.assertEquals(status.getTitle(), createdStatus.getTitle());
            Assertions.assertEquals(status.getProgress(), createdStatus.getProgress());
        } catch (Exception e) {
            Assertions.fail("Exception occurred during createStatus");
        }
    }

    @Test
    public void testUpdateStatus() {
        
        Status existingStatus = new Status(1, "Existing Status", Progress.BACKLOG);

        try {
            Status updatedStatus = statusService.updateStatus(existingStatus);
            Assertions.assertNotNull(updatedStatus);
            Assertions.assertEquals(existingStatus.getTitle(), updatedStatus.getTitle());
            Assertions.assertEquals(existingStatus.getProgress(), updatedStatus.getProgress());
        } catch (Exception e) {
            Assertions.fail("Exception occurred during updateStatus");
        }
    }

    @Test
    public void testGetAllStatus() {
        try {
            List<Status> statusList = statusService.getAllStatus();
            Assertions.assertNotNull(statusList);
        } catch (Exception e) {
            Assertions.fail("Exception occurred during getAllStatus");
        }
    }

   
  }


