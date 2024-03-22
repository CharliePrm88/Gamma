package it.sponzi.gamma.pec.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class PecDto implements Comparable<PecDto> {

    protected Long id;

    @Email
    @NotNull
    protected String sender;

    @Email
    @NotNull
    protected String receiver;

    @NotNull
    protected Instant date;

    protected String subject = "";

    protected String message = "";

    protected List<AttachmentDto> attachments = new ArrayList<>();

    @Override
    public int compareTo(PecDto pecDto) {
        return pecDto.getDate().compareTo(this.date);
    }
}
