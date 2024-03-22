package it.sponzi.gamma.pec.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.sponzi.gamma.common.controller.BaseController;
import it.sponzi.gamma.pec.dao.PecMail;
import it.sponzi.gamma.pec.dto.PecMailDto;
import it.sponzi.gamma.pec.service.PecMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pec-mail")
@Tag(name="Pec Mail", description = "Api for Pec Mail Management")
public class PecMailController extends BaseController<PecMailService, PecMail, PecMailDto> {

    @Autowired
    public PecMailController(PecMailService service) {
        super(service);
    }
}
