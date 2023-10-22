package com.github.antonioticelso.dynamicBillingSystem.controller;

import com.github.antonioticelso.dynamicBillingSystem.models.BillingAccount;
import com.github.antonioticelso.dynamicBillingSystem.models.dto.BillingAccountCreateDTO;
import com.github.antonioticelso.dynamicBillingSystem.models.dto.BillingAccountDTO;
import com.github.antonioticelso.dynamicBillingSystem.models.mapper.BillingMapper;
import com.github.antonioticelso.dynamicBillingSystem.services.BillingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dynamicBilling")
@Api(tags = "Dynamic Billing Controller")
public class BillingController {

    private final BillingService service;
    private final BillingMapper billingMapper;

    public BillingController(BillingService service, BillingMapper billingMapper) {
        this.service = service;
        this.billingMapper = billingMapper;
    }

    @GetMapping
    @ApiOperation("Find all BillingAccounts")
    public ResponseEntity<List<BillingAccountDTO>> findAll() {

        List<BillingAccount> BillingAccountList = service.findAll();
        List<BillingAccountDTO> result = billingMapper.toBillingAccountDTOList(BillingAccountList);

        return ResponseEntity.ok(result);

    }

    @GetMapping("/{id}")
    @ApiOperation("Find by BillingAccount for id")
    public ResponseEntity<BillingAccountDTO> findById(@PathVariable String id) {

        BillingAccount billingAccount = service.findById(id);
        BillingAccountDTO result = billingMapper.toBillingAccountDTO(billingAccount);

        return ResponseEntity.ok(result);

    }

    @PostMapping
    @ApiOperation("New parkings")
    public ResponseEntity<BillingAccountDTO> create(@RequestBody BillingAccountCreateDTO dto) {

        BillingAccount parkingCreate = billingMapper.toBillingAccountCreate(dto);
        BillingAccount parking = service.create(parkingCreate);
        BillingAccountDTO result = billingMapper.toBillingAccountDTO(parking);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

    @PutMapping("/{id}")
    @ApiOperation("Update parkings")
    public ResponseEntity<BillingAccountDTO> update(@PathVariable String id, @RequestBody BillingAccountCreateDTO dto) {

        BillingAccount parkingCreate = billingMapper.toBillingAccountCreate(dto);
        BillingAccount parking = service.update(id, parkingCreate);
        BillingAccountDTO result = billingMapper.toBillingAccountDTO(parking);

        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    @PostMapping("/{id}")
    @ApiOperation("Check Out parkings")
    public ResponseEntity<BillingAccountDTO> checkOut(@PathVariable String id) {

        BillingAccount parking = service.checkOut(id);
        BillingAccountDTO result = billingMapper.toBillingAccountDTO(parking);

        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete by parking for id")
    public ResponseEntity delete(@PathVariable String id) {
        service.delete(id);

        return ResponseEntity.noContent().build();

    }

}
