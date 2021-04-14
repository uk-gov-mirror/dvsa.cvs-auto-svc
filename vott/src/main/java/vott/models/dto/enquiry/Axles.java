/*
 * Vehicle Enquiry Service Swagger
 * This is the CVS API for showing details of heavy goods vehicles and their associated test result.
 *
 * OpenAPI spec version: 1.1-oas3
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package vott.models.dto.enquiry;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Axles
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-04-13T17:16:44.237Z[GMT]")
public class Axles {
  @SerializedName("axleNumber")
  private BigDecimal axleNumber = null;

  @SerializedName("parkingBrakeMrk")
  private Boolean parkingBrakeMrk = null;

  @SerializedName("kerbWeight")
  private BigDecimal kerbWeight = null;

  @SerializedName("ladenWeight")
  private BigDecimal ladenWeight = null;

  @SerializedName("gbWeight")
  private BigDecimal gbWeight = null;

  @SerializedName("eecWeight")
  private BigDecimal eecWeight = null;

  @SerializedName("designWeight")
  private BigDecimal designWeight = null;

  @SerializedName("tyreSize")
  private String tyreSize = null;

  @SerializedName("plyRating")
  private String plyRating = null;

  @SerializedName("fitmentCode")
  private String fitmentCode = null;

  @SerializedName("dataTrAxles")
  private BigDecimal dataTrAxles = null;

  @SerializedName("speedCategorySymbol")
  private String speedCategorySymbol = null;

  @SerializedName("tyreCode")
  private BigDecimal tyreCode = null;

  @SerializedName("brakeActuator")
  private BigDecimal brakeActuator = null;

  @SerializedName("leverLength")
  private BigDecimal leverLength = null;

  @SerializedName("springBrakeParking")
  private Boolean springBrakeParking = null;

  @SerializedName("tyres")
  private List<Tyre> tyres = null;

  public Axles axleNumber(BigDecimal axleNumber) {
    this.axleNumber = axleNumber;
    return this;
  }

   /**
   * ALL
   * @return axleNumber
  **/

  public BigDecimal getAxleNumber() {
    return axleNumber;
  }

  public void setAxleNumber(BigDecimal axleNumber) {
    this.axleNumber = axleNumber;
  }

  public Axles parkingBrakeMrk(Boolean parkingBrakeMrk) {
    this.parkingBrakeMrk = parkingBrakeMrk;
    return this;
  }

   /**
   * ALL
   * @return parkingBrakeMrk
  **/
  public Boolean isParkingBrakeMrk() {
    return parkingBrakeMrk;
  }

  public void setParkingBrakeMrk(Boolean parkingBrakeMrk) {
    this.parkingBrakeMrk = parkingBrakeMrk;
  }

  public Axles kerbWeight(BigDecimal kerbWeight) {
    this.kerbWeight = kerbWeight;
    return this;
  }

   /**
   * PSV
   * @return kerbWeight
  **/
  public BigDecimal getKerbWeight() {
    return kerbWeight;
  }

  public void setKerbWeight(BigDecimal kerbWeight) {
    this.kerbWeight = kerbWeight;
  }

  public Axles ladenWeight(BigDecimal ladenWeight) {
    this.ladenWeight = ladenWeight;
    return this;
  }

   /**
   * PSV
   * @return ladenWeight
  **/
  public BigDecimal getLadenWeight() {
    return ladenWeight;
  }

  public void setLadenWeight(BigDecimal ladenWeight) {
    this.ladenWeight = ladenWeight;
  }

  public Axles gbWeight(BigDecimal gbWeight) {
    this.gbWeight = gbWeight;
    return this;
  }

   /**
   * ALL
   * @return gbWeight
  **/
  public BigDecimal getGbWeight() {
    return gbWeight;
  }

  public void setGbWeight(BigDecimal gbWeight) {
    this.gbWeight = gbWeight;
  }

  public Axles eecWeight(BigDecimal eecWeight) {
    this.eecWeight = eecWeight;
    return this;
  }

   /**
   * HGV/TRL
   * @return eecWeight
  **/
  public BigDecimal getEecWeight() {
    return eecWeight;
  }

  public void setEecWeight(BigDecimal eecWeight) {
    this.eecWeight = eecWeight;
  }

  public Axles designWeight(BigDecimal designWeight) {
    this.designWeight = designWeight;
    return this;
  }

   /**
   * ALL
   * @return designWeight
  **/
  public BigDecimal getDesignWeight() {
    return designWeight;
  }

  public void setDesignWeight(BigDecimal designWeight) {
    this.designWeight = designWeight;
  }

  public Axles tyreSize(String tyreSize) {
    this.tyreSize = tyreSize;
    return this;
  }

   /**
   * ALL
   * @return tyreSize
  **/
  public String getTyreSize() {
    return tyreSize;
  }

  public void setTyreSize(String tyreSize) {
    this.tyreSize = tyreSize;
  }

  public Axles plyRating(String plyRating) {
    this.plyRating = plyRating;
    return this;
  }

   /**
   * ALL
   * @return plyRating
  **/
  public String getPlyRating() {
    return plyRating;
  }

  public void setPlyRating(String plyRating) {
    this.plyRating = plyRating;
  }

  public Axles fitmentCode(String fitmentCode) {
    this.fitmentCode = fitmentCode;
    return this;
  }

   /**
   * ALL
   * @return fitmentCode
  **/
  public String getFitmentCode() {
    return fitmentCode;
  }

  public void setFitmentCode(String fitmentCode) {
    this.fitmentCode = fitmentCode;
  }

  public Axles dataTrAxles(BigDecimal dataTrAxles) {
    this.dataTrAxles = dataTrAxles;
    return this;
  }

   /**
   * ALL
   * @return dataTrAxles
  **/
  public BigDecimal getDataTrAxles() {
    return dataTrAxles;
  }

  public void setDataTrAxles(BigDecimal dataTrAxles) {
    this.dataTrAxles = dataTrAxles;
  }

  public Axles speedCategorySymbol(String speedCategorySymbol) {
    this.speedCategorySymbol = speedCategorySymbol;
    return this;
  }

   /**
   * PSV
   * @return speedCategorySymbol
  **/
  public String getSpeedCategorySymbol() {
    return speedCategorySymbol;
  }

  public void setSpeedCategorySymbol(String speedCategorySymbol) {
    this.speedCategorySymbol = speedCategorySymbol;
  }

  public Axles tyreCode(BigDecimal tyreCode) {
    this.tyreCode = tyreCode;
    return this;
  }

   /**
   * ALL
   * @return tyreCode
  **/
  public BigDecimal getTyreCode() {
    return tyreCode;
  }

  public void setTyreCode(BigDecimal tyreCode) {
    this.tyreCode = tyreCode;
  }

  public Axles brakeActuator(BigDecimal brakeActuator) {
    this.brakeActuator = brakeActuator;
    return this;
  }

   /**
   * UNK
   * @return brakeActuator
  **/
  public BigDecimal getBrakeActuator() {
    return brakeActuator;
  }

  public void setBrakeActuator(BigDecimal brakeActuator) {
    this.brakeActuator = brakeActuator;
  }

  public Axles leverLength(BigDecimal leverLength) {
    this.leverLength = leverLength;
    return this;
  }

   /**
   * UNK
   * @return leverLength
  **/
  public BigDecimal getLeverLength() {
    return leverLength;
  }

  public void setLeverLength(BigDecimal leverLength) {
    this.leverLength = leverLength;
  }

  public Axles springBrakeParking(Boolean springBrakeParking) {
    this.springBrakeParking = springBrakeParking;
    return this;
  }

   /**
   * UNK
   * @return springBrakeParking
  **/
  public Boolean isSpringBrakeParking() {
    return springBrakeParking;
  }

  public void setSpringBrakeParking(Boolean springBrakeParking) {
    this.springBrakeParking = springBrakeParking;
  }

  public Axles tyres(List<Tyre> tyres) {
    this.tyres = tyres;
    return this;
  }

  public Axles addTyresItem(Tyre tyresItem) {
    if (this.tyres == null) {
      this.tyres = new ArrayList<Tyre>();
    }
    this.tyres.add(tyresItem);
    return this;
  }

   /**
   * Get tyres
   * @return tyres
  **/
  public List<Tyre> getTyres() {
    return tyres;
  }

  public void setTyres(List<Tyre> tyres) {
    this.tyres = tyres;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Axles axles = (Axles) o;
    return Objects.equals(this.axleNumber, axles.axleNumber) &&
        Objects.equals(this.parkingBrakeMrk, axles.parkingBrakeMrk) &&
        Objects.equals(this.kerbWeight, axles.kerbWeight) &&
        Objects.equals(this.ladenWeight, axles.ladenWeight) &&
        Objects.equals(this.gbWeight, axles.gbWeight) &&
        Objects.equals(this.eecWeight, axles.eecWeight) &&
        Objects.equals(this.designWeight, axles.designWeight) &&
        Objects.equals(this.tyreSize, axles.tyreSize) &&
        Objects.equals(this.plyRating, axles.plyRating) &&
        Objects.equals(this.fitmentCode, axles.fitmentCode) &&
        Objects.equals(this.dataTrAxles, axles.dataTrAxles) &&
        Objects.equals(this.speedCategorySymbol, axles.speedCategorySymbol) &&
        Objects.equals(this.tyreCode, axles.tyreCode) &&
        Objects.equals(this.brakeActuator, axles.brakeActuator) &&
        Objects.equals(this.leverLength, axles.leverLength) &&
        Objects.equals(this.springBrakeParking, axles.springBrakeParking) &&
        Objects.equals(this.tyres, axles.tyres);
  }

  @Override
  public int hashCode() {
    return Objects.hash(axleNumber, parkingBrakeMrk, kerbWeight, ladenWeight, gbWeight, eecWeight, designWeight, tyreSize, plyRating, fitmentCode, dataTrAxles, speedCategorySymbol, tyreCode, brakeActuator, leverLength, springBrakeParking, tyres);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Axles {\n");
    
    sb.append("    axleNumber: ").append(toIndentedString(axleNumber)).append("\n");
    sb.append("    parkingBrakeMrk: ").append(toIndentedString(parkingBrakeMrk)).append("\n");
    sb.append("    kerbWeight: ").append(toIndentedString(kerbWeight)).append("\n");
    sb.append("    ladenWeight: ").append(toIndentedString(ladenWeight)).append("\n");
    sb.append("    gbWeight: ").append(toIndentedString(gbWeight)).append("\n");
    sb.append("    eecWeight: ").append(toIndentedString(eecWeight)).append("\n");
    sb.append("    designWeight: ").append(toIndentedString(designWeight)).append("\n");
    sb.append("    tyreSize: ").append(toIndentedString(tyreSize)).append("\n");
    sb.append("    plyRating: ").append(toIndentedString(plyRating)).append("\n");
    sb.append("    fitmentCode: ").append(toIndentedString(fitmentCode)).append("\n");
    sb.append("    dataTrAxles: ").append(toIndentedString(dataTrAxles)).append("\n");
    sb.append("    speedCategorySymbol: ").append(toIndentedString(speedCategorySymbol)).append("\n");
    sb.append("    tyreCode: ").append(toIndentedString(tyreCode)).append("\n");
    sb.append("    brakeActuator: ").append(toIndentedString(brakeActuator)).append("\n");
    sb.append("    leverLength: ").append(toIndentedString(leverLength)).append("\n");
    sb.append("    springBrakeParking: ").append(toIndentedString(springBrakeParking)).append("\n");
    sb.append("    tyres: ").append(toIndentedString(tyres)).append("\n");
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