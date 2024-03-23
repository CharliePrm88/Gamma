package it.sponzi.gamma.signer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.sponzi.gamma.common.controller.BaseController;
import it.sponzi.gamma.signer.dao.DigitalSign;
import it.sponzi.gamma.signer.dto.DigitalSignDto;
import it.sponzi.gamma.signer.service.DigitalSignService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/digital-sign")
@Tag(name="Digital Sign", description = "Api for Digital Sign Management")
public class DigitalSignController extends BaseController<DigitalSignService, DigitalSign, DigitalSignDto> {

    private final DigitalSignService digitalSignService;

    public DigitalSignController(DigitalSignService service) {
        super(service);
        this.digitalSignService = service;
    }

    @PostMapping(value = "/sign", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "", operationId = "signDocument", description = "Sign a document")
    public Mono<byte[]> signDocument(@RequestBody byte[] body) {
        return digitalSignService.signDocument("User", body); //TODO get username from securityContextUtils
    }

    @PostMapping(value = "/verify", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "", operationId = "verify", description = "Check a document")
    public Mono<Boolean> verifySign(@RequestBody byte[] body) {
        return service.verify("User", body);
    }


}
