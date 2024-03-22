package it.sponzi.gamma.pec.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "ATTACHMENT")
@Entity(name = "Attachment")
@Data
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_att")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "att_seq", sequenceName = "seq_att")
    protected Long id;

    @Lob
    protected byte[] sender;
}
