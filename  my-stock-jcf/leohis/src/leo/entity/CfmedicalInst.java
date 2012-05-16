package leo.entity;



/**
 * CfmedicalInst entity. @author MyEclipse Persistence Tools
 */

public class CfmedicalInst  implements java.io.Serializable {


    // Fields    

     private Long did;
     private String disposeName;
     private String cfvalue;
     private Integer medicalInstId;


    // Constructors

    /** default constructor */
    public CfmedicalInst() {
    }

	/** minimal constructor */
    public CfmedicalInst(Long did) {
        this.did = did;
    }
    
    /** full constructor */
    public CfmedicalInst(Long did, String disposeName, String cfvalue, Integer medicalInstId) {
        this.did = did;
        this.disposeName = disposeName;
        this.cfvalue = cfvalue;
        this.medicalInstId = medicalInstId;
    }

   
    // Property accessors

    public Long getDid() {
        return this.did;
    }
    
    public void setDid(Long did) {
        this.did = did;
    }

    public String getDisposeName() {
        return this.disposeName;
    }
    
    public void setDisposeName(String disposeName) {
        this.disposeName = disposeName;
    }

    public String getCfvalue() {
        return this.cfvalue;
    }
    
    public void setCfvalue(String cfvalue) {
        this.cfvalue = cfvalue;
    }

    public Integer getMedicalInstId() {
        return this.medicalInstId;
    }
    
    public void setMedicalInstId(Integer medicalInstId) {
        this.medicalInstId = medicalInstId;
    }
   








}