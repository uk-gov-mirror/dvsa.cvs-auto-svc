/*
 * Vehicles Microservice
 * This is the API spec for the vehicle microservice. Endpoints and parameters only exist for the operations getVehicle and getTechRecords. Other operations within the microservice are out of scope.
 *
 * OpenAPI spec version: 1.0.0
 * Contact: bpecete@deloittece.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package vott.models.dto.techrecords;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TechRecordPOST
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-04-13T13:30:43.231Z[GMT]")
public class TechRecordPOST {
  @SerializedName("msUserDetails")
  private TechRecordArchiveAndProvisionalPayloadMsUserDetails msUserDetails = null;

  @SerializedName("vin")
  private String vin = null;

  @SerializedName("primaryVrm")
  private String primaryVrm = null;

  @SerializedName("secondaryVrms")
  private List<String> secondaryVrms = null;

  @SerializedName("trailerId")
  private String trailerId = null;

  @SerializedName("techRecord")
  private TechRecords techRecord = null;

  public TechRecordPOST msUserDetails(TechRecordArchiveAndProvisionalPayloadMsUserDetails msUserDetails) {
    this.msUserDetails = msUserDetails;
    return this;
  }

   /**
   * Get msUserDetails
   * @return msUserDetails
  **/
    public TechRecordArchiveAndProvisionalPayloadMsUserDetails getMsUserDetails() {
    return msUserDetails;
  }

  public void setMsUserDetails(TechRecordArchiveAndProvisionalPayloadMsUserDetails msUserDetails) {
    this.msUserDetails = msUserDetails;
  }

  public TechRecordPOST vin(String vin) {
    this.vin = vin;
    return this;
  }

   /**
   * Used for all vehicle types - PSV, HGV, TRL, car, lgv, motorcycle
   * @return vin
  **/
    public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  public TechRecordPOST primaryVrm(String primaryVrm) {
    this.primaryVrm = primaryVrm;
    return this;
  }

   /**
   * Mandatory for PSV, HGV, car, lgv, motorcycle. Optional for TRL
   * @return primaryVrm
  **/
    public String getPrimaryVrm() {
    return primaryVrm;
  }

  public void setPrimaryVrm(String primaryVrm) {
    this.primaryVrm = primaryVrm;
  }

  public TechRecordPOST secondaryVrms(List<String> secondaryVrms) {
    this.secondaryVrms = secondaryVrms;
    return this;
  }

  public TechRecordPOST addSecondaryVrmsItem(String secondaryVrmsItem) {
    if (this.secondaryVrms == null) {
      this.secondaryVrms = new ArrayList<String>();
    }
    this.secondaryVrms.add(secondaryVrmsItem);
    return this;
  }

   /**
   * Mandatory for PSV and HGV. Optional for TRL
   * @return secondaryVrms
  **/
    public List<String> getSecondaryVrms() {
    return secondaryVrms;
  }

  public void setSecondaryVrms(List<String> secondaryVrms) {
    this.secondaryVrms = secondaryVrms;
  }

  public TechRecordPOST trailerId(String trailerId) {
    this.trailerId = trailerId;
    return this;
  }

   /**
   * Used only for TRL. Optional for HGV and PSV
   * @return trailerId
  **/
    public String getTrailerId() {
    return trailerId;
  }

  public void setTrailerId(String trailerId) {
    this.trailerId = trailerId;
  }

  public TechRecordPOST techRecord(TechRecords techRecord) {
    this.techRecord = techRecord;
    return this;
  }

   /**
   * Get techRecord
   * @return techRecord
  **/
    public TechRecords getTechRecord() {
    return techRecord;
  }

  public void setTechRecord(TechRecords techRecord) {
    this.techRecord = techRecord;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TechRecordPOST techRecordPOST = (TechRecordPOST) o;
    return Objects.equals(this.msUserDetails, techRecordPOST.msUserDetails) &&
        Objects.equals(this.vin, techRecordPOST.vin) &&
        Objects.equals(this.primaryVrm, techRecordPOST.primaryVrm) &&
        Objects.equals(this.secondaryVrms, techRecordPOST.secondaryVrms) &&
        Objects.equals(this.trailerId, techRecordPOST.trailerId) &&
        Objects.equals(this.techRecord, techRecordPOST.techRecord);
  }

  @Override
  public int hashCode() {
    return Objects.hash(msUserDetails, vin, primaryVrm, secondaryVrms, trailerId, techRecord);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TechRecordPOST {\n");
    
    sb.append("    msUserDetails: ").append(toIndentedString(msUserDetails)).append("\n");
    sb.append("    vin: ").append(toIndentedString(vin)).append("\n");
    sb.append("    primaryVrm: ").append(toIndentedString(primaryVrm)).append("\n");
    sb.append("    secondaryVrms: ").append(toIndentedString(secondaryVrms)).append("\n");
    sb.append("    trailerId: ").append(toIndentedString(trailerId)).append("\n");
    sb.append("    techRecord: ").append(toIndentedString(techRecord)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}