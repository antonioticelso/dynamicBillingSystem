package com.github.antonioticelso.dynamicBillingSystem.models.mapper;

import com.github.antonioticelso.dynamicBillingSystem.models.BillingAccount;
import com.github.antonioticelso.dynamicBillingSystem.models.dto.BillingAccountCreateDTO;
import com.github.antonioticelso.dynamicBillingSystem.models.dto.BillingAccountDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BillingMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public BillingAccountDTO toBillingAccountDTO(BillingAccount BillingAccount) {
        return MODEL_MAPPER.map(BillingAccount, BillingAccountDTO.class);
    }

    public List<BillingAccountDTO> toBillingAccountDTOList(List<BillingAccount> BillingAccountList) {
        return BillingAccountList.stream().map(this::toBillingAccountDTO).collect(Collectors.toList());
    }

    public BillingAccount toBillingAccount(BillingAccountDTO dto) {
        return MODEL_MAPPER.map(dto, BillingAccount.class);
    }

    public BillingAccount toBillingAccountCreate(BillingAccountCreateDTO dto) {
        return MODEL_MAPPER.map(dto, BillingAccount.class);
    }

}
