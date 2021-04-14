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

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Used only for TRL
 */
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-04-13T13:30:43.231Z[GMT]")
public class AxleBrakeProperties {
  @SerializedName("brakeActuator")
  private BigDecimal brakeActuator = null;

  @SerializedName("leverLength")
  private BigDecimal leverLength = null;

  @SerializedName("springBrakeParking")
  private Boolean springBrakeParking = null;

  public AxleBrakeProperties brakeActuator(BigDecimal brakeActuator) {
    this.brakeActuator = brakeActuator;
    return this;
  }

   /**
   * Get brakeActuator
   * maximum: 999
   * @return brakeActuator
  **/
    public BigDecimal getBrakeActuator() {
    return brakeActuator;
  }

  public void setBrakeActuator(BigDecimal brakeActuator) {
    this.brakeActuator = brakeActuator;
  }

  public AxleBrakeProperties leverLength(BigDecimal leverLength) {
    this.leverLength = leverLength;
    return this;
  }

   /**
   * Get leverLength
   * maximum: 999
   * @return leverLength
  **/
    public BigDecimal getLeverLength() {
    return leverLength;
  }

  public void setLeverLength(BigDecimal leverLength) {
    this.leverLength = leverLength;
  }

  public AxleBrakeProperties springBrakeParking(Boolean springBrakeParking) {
    this.springBrakeParking = springBrakeParking;
    return this;
  }

   /**
   * Get springBrakeParking
   * @return springBrakeParking
  **/
    public Boolean isSpringBrakeParking() {
    return springBrakeParking;
  }

  public void setSpringBrakeParking(Boolean springBrakeParking) {
    this.springBrakeParking = springBrakeParking;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AxleBrakeProperties axleBrakeProperties = (AxleBrakeProperties) o;
    return Objects.equals(this.brakeActuator, axleBrakeProperties.brakeActuator) &&
        Objects.equals(this.leverLength, axleBrakeProperties.leverLength) &&
        Objects.equals(this.springBrakeParking, axleBrakeProperties.springBrakeParking);
  }

  @Override
  public int hashCode() {
    return Objects.hash(brakeActuator, leverLength, springBrakeParking);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AxleBrakeProperties {\n");
    
    sb.append("    brakeActuator: ").append(toIndentedString(brakeActuator)).append("\n");
    sb.append("    leverLength: ").append(toIndentedString(leverLength)).append("\n");
    sb.append("    springBrakeParking: ").append(toIndentedString(springBrakeParking)).append("\n");
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