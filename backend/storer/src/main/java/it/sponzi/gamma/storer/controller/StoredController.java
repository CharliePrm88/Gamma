package it.sponzi.gamma.storer.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.sponzi.gamma.common.controller.BaseController;
import it.sponzi.gamma.storer.dao.StoredData;
import it.sponzi.gamma.storer.dto.StoredDataDto;
import it.sponzi.gamma.storer.service.StoredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stored")
@Tag(name="Stored", description = "Api for Store files Management")
public class StoredController extends BaseController<StoredService, StoredData, StoredDataDto> {

    @Autowired
    public StoredController(StoredService service) {
        super(service);
    }
}
