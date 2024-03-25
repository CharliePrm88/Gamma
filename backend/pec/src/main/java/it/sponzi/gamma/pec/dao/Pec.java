package it.sponzi.gamma.pec.dao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Table(name = "PEC")
@Entity(name = "Pec")
@Data
public class Pec implements Comparable<Pec> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pec")
    @SequenceGenerator(allocationSize = 1, initialValue = 1, name = "pec_seq", sequenceName = "seq_pec")
    protected Long id;

    protected String sender;

    protected String receiver;

    protected Instant date;

    protected String subject;

    @Lob
    protected String message;

    @JoinColumn(name = "pec", referencedColumnName = "Id")
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Attachment.class, orphanRemoval = true, fetch = FetchType.LAZY)
    protected List<Attachment> attachments;

    @Override
    public int compareTo(Pec pec) {
        return pec.getDate().compareTo(this.date);
    }
}
