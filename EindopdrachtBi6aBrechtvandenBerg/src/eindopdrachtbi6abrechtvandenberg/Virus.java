/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eindopdrachtbi6abrechtvandenberg;

import java.util.Comparator;

/**
 *
 * @author Brecht
 */
public class Virus{
   
    // instancing variables
    private Integer virus_tax_id;
    private Integer host_tax_id;
    private String virus_name;
    private String virus_lineage;
    private String refseq_id;
    private String kegg_genome;
    private String kegg_disease;
    private String disease;
    private String host_name;
    private String host_lineage;
    private String pmid;    
    private String evidence;
    
    
    // constructor construction
    Virus(Integer virus_tax_id, String virus_name, String virus_lineage, String refseq_id, String kegg_genome, String kegg_disease, String disease, Integer host_tax_id, String host_name, String host_lineage, String pmid, String evidence){
        this.disease = disease;
        this.evidence = evidence;
        this.host_lineage = host_lineage;
        this.host_name = host_name;
        this.host_tax_id = host_tax_id;
        this.kegg_disease = kegg_disease;
        this.kegg_genome = kegg_genome;
        this.pmid = pmid;
        this.refseq_id = refseq_id;
        this.virus_lineage = virus_lineage;
        this.virus_name = virus_name;
        this.virus_tax_id = virus_tax_id;
    }

 


            
      
    /**
     * @return the virus_tax_id
     */
    public Integer getVirus_tax_id() {
        return virus_tax_id;
    }

    /**
     * @param virus_tax_id the virus_tax_id to set
     */
    public void setVirus_tax_id(Integer virus_tax_id) {
        this.virus_tax_id = virus_tax_id;
    }

    /**
     * @return the host_tax_id
     */
    public Integer getHost_tax_id() {
        return host_tax_id;
    }

    /**
     * @param host_tax_id the host_tax_id to set
     */
    public void setHost_tax_id(Integer host_tax_id) {
        this.host_tax_id = host_tax_id;
    }

    /**
     * @return the virus_name
     */
    public String getVirus_name() {
        return virus_name;
    }

    /**
     * @param virus_name the virus_name to set
     */
    public void setVirus_name(String virus_name) {
        this.virus_name = virus_name;
    }

    /**
     * @return the virus_lineage
     */
    public String getVirus_lineage() {
        return virus_lineage;
    }

    /**
     * @param virus_lineage the virus_lineage to set
     */
    public void setVirus_lineage(String virus_lineage) {
        this.virus_lineage = virus_lineage;
    }

    /**
     * @return the refseq_id
     */
    public String getRefseq_id() {
        return refseq_id;
    }

    /**
     * @param refseq_id the refseq_id to set
     */
    public void setRefseq_id(String refseq_id) {
        this.refseq_id = refseq_id;
    }

    /**
     * @return the kegg_genome
     */
    public String getKegg_genome() {
        return kegg_genome;
    }

    /**
     * @param kegg_genome the kegg_genome to set
     */
    public void setKegg_genome(String kegg_genome) {
        this.kegg_genome = kegg_genome;
    }

    /**
     * @return the kegg_disease
     */
    public String getKegg_disease() {
        return kegg_disease;
    }

    /**
     * @param kegg_disease the kegg_disease to set
     */
    public void setKegg_disease(String kegg_disease) {
        this.kegg_disease = kegg_disease;
    }

    /**
     * @return the disease
     */
    public String getDisease() {
        return disease;
    }

    /**
     * @param disease the disease to set
     */
    public void setDisease(String disease) {
        this.disease = disease;
    }

    /**
     * @return the host_name
     */
    public String getHost_name() {
        return host_name;
    }

    /**
     * @param host_name the host_name to set
     */
    public void setHost_name(String host_name) {
        this.host_name = host_name;
    }

    /**
     * @return the host_lineage
     */
    public String getHost_lineage() {
        return host_lineage;
    }

    /**
     * @param host_lineage the host_lineage to set
     */
    public void setHost_lineage(String host_lineage) {
        this.host_lineage = host_lineage;
    }

    /**
     * @return the pmid
     */
    public String getPmid() {
        return pmid;
    }

    /**
     * @param pmid the pmid to set
     */
    public void setPmid(String pmid) {
        this.pmid = pmid;
    }

    /**
     * @return the evidence
     */
    public String getEvidence() {
        return evidence;
    }

    /**
     * @param evidence the evidence to set
     */
    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    

    
}