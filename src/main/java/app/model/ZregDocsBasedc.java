package app.model;

import java.time.LocalDate;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "zreg_docs_basedc")
public class ZregDocsBasedc {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zreg_docs_basedc_seq_gen")
	@SequenceGenerator(name = "zreg_docs_basedc_seq_gen", sequenceName = "zreg_docs_basedc_id_seq", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_prn", nullable = false)
	private ZregDoc zregDoc;

	@Column(name = "naimosn")
	private String naimosn;

	@Column(name = "nomosn")
	private String nomosn;

	@Column(name = "dataosn")
	private LocalDate dataosn;

	@Column(name = "dopsvosn", length = 1000)
	private String dopsvosn;

	@Column(name = "identosn")
	private String identosn;

	@Column(name = "base_doc_type")
	private byte baseDocType;

	public ZregDocsBasedc fillFields() {
		ZregDocsBasedc z = new ZregDocsBasedc();
		z.setNaimosn("naimosn");
		z.setNomosn("nomosn");
		z.setDataosn(LocalDate.now());
		z.setDopsvosn("dopsvosn");
		z.setBaseDocType((byte) 1);
		return z;
	}
}