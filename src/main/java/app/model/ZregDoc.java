package app.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@Table(name = "zreg_docs")
public class ZregDoc {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zreg_docs_seq_gen")
	@SequenceGenerator(name = "zreg_docs_seq_gen", sequenceName = "zreg_docs_id_seq", allocationSize = 1)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "bukrs", length = 4)
	private String bukrs;

	@Column(name = "gjahr", precision = 4)
	private BigDecimal gjahr;

	@Column(name = "edoc")
	private byte edoc;

	@Column(name = "in_out")
	private byte inOut;

	@Column(name = "doc_kind", length = 10)
	private String docKind;

	@Column(name = "doc_type")
	private byte docType;

	@Column(name = "nomerschf", length = 1000)
	private String nomerschf;

	@Column(name = "dataschf")
	private LocalDate dataschf;

	@Column(name = "okv", length = 3)
	private String okv;

	@Column(name = "nomisprschf", precision = 3)
	private BigDecimal nomisprschf;

	@Column(name = "dataisprschf")
	private LocalDate dataisprschf;

	@Column(name = "id_ispr")
	private Long idIspr;

	@Column(name = "date_orig_doc")
	private LocalDate dateOrigDoc;

	@Column(name = "x_approved")
	private Boolean xApproved;

	@Column(name = "user_app", length = 12)
	private String userApp;

	@Column(name = "x_accepted")
	private Boolean xAccepted;

	@Column(name = "user_acp", length = 12)
	private String userAcp;

	@Column(name = "svod1")
	private Boolean svod1;

	@Column(name = "svod2")
	private Boolean svod2;

	@Column(name = "svod3")
	private Boolean svod3;

	@Column(name = "svod4")
	private Boolean svod4;

	@Column(name = "tax_agent")
	private Boolean taxAgent;

	@Column(name = "kodvidsd")
	private byte kodvidsd;

	@Column(name = "idgoskon")
	private String idgoskon;

	@Column(name = "naimokv", length = 100)
	private String naimokv;

	@Column(name = "kursval", precision = 10, scale = 4)
	private BigDecimal kursval;

	@Column(name = "pofaktkhzh")
	private String pofaktkhzh;

	@Column(name = "naimdokopr")
	private String naimdokopr;

	@Column(name = "datainfpr")
	private LocalDate datainfpr;

	@Column(name = "vreminfpr")
	private LocalTime vreminfpr;

	@Column(name = "naimekonsubsost", length = 500)
	private String naimekonsubsost;

	@Column(name = "osndoverorgsost")
	private String osndoverorgsost;

	@Column(name = "svtrangruz", length = 1000)
	private String svtrangruz;

	@Column(name = "x_deleted")
	private Boolean xDeleted;

	@Column(name = "date_tru")
	private LocalDate dateTru;

	@Column(name = "ftype", length = 6)
	private String ftype;

	@Column(name = "subnm", length = 6)
	private String subnm;

	@Column(name = "user_ins", length = 12)
	private String userIns;

	@Column(name = "user_upd", length = 12)
	private String userUpd;

	@Column(name = "date_ins")
	private Instant dateIns;

	@Column(name = "date_upd")
	private Instant dateUpd;

	@Column(name = "date_copy_doc")
	private LocalDate dateCopyDoc;

	@Column(name = "knd", length = 7)
	private String knd;

	@Column(name = "x_made_by_agent")
	private Boolean xMadeByAgent;

	@Column(name = "gsber", length = 4)
	private String gsber;

	@Column(name = "otdel", precision = 2)
	private BigDecimal otdel;

	@Column(name = "x_barcode", length = 1)
	private String xBarcode;

	@Column(name = "tcode", length = 20)
	private String tcode;

	@OneToMany(mappedBy = "zregDoc", cascade = CascadeType.ALL)
	private Set<ZregDocsBasedc> zregDocsBasedcSet;

	public ZregDoc fillFields(Set<ZregDocsBasedc> zregDocsBasedcSet) {
		ZregDoc z = new ZregDoc();
		z.setGsber("gg14");
		z.setEdoc((byte) 1);
		z.setInOut((byte) 1);
		z.setDocType((byte) 1);
		z.setKodvidsd((byte) 1);
		z.setZregDocsBasedcSet(zregDocsBasedcSet);
		zregDocsBasedcSet.forEach(e -> e.setZregDoc(z));
		return z;
	}
}