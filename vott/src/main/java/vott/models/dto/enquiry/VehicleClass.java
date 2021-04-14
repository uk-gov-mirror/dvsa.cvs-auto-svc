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


import java.util.Objects;

/**
 * VehicleClass
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-04-13T17:16:44.237Z[GMT]")
public class VehicleClass {
  @SerializedName("code")
  private String code = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("vehicleType")
  private String vehicleType = null;

  @SerializedName("vehicleSize")
  private String vehicleSize = null;

  @SerializedName("vehicleConfiguration")
  private String vehicleConfiguration = null;

  @SerializedName("euVehicleCategory")
  private String euVehicleCategory = null;

  public VehicleClass code(String code) {
    this.code = code;
    return this;
  }

   /**
   * ALL
   * @return code
  **/
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public VehicleClass description(String description) {
    this.description = description;
    return this;
  }

   /**
   * ALL
   * @return description
  **/
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public VehicleClass vehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
    return this;
  }

   /**
   * ALL
   * @return vehicleType
  **/
  public String getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
  }

  public VehicleClass vehicleSize(String vehicleSize) {
    this.vehicleSize = vehicleSize;
    return this;
  }

   /**
   * PSV
   * @return vehicleSize
  **/
  public String getVehicleSize() {
    return vehicleSize;
  }

  public void setVehicleSize(String vehicleSize) {
    this.vehicleSize = vehicleSize;
  }

  public VehicleClass vehicleConfiguration(String vehicleConfiguration) {
    this.vehicleConfiguration = vehicleConfiguration;
    return this;
  }

   /**
   * ALL
   * @return vehicleConfiguration
  **/
  public String getVehicleConfiguration() {
    return vehicleConfiguration;
  }

  public void setVehicleConfiguration(String vehicleConfiguration) {
    this.vehicleConfiguration = vehicleConfiguration;
  }

  public VehicleClass euVehicleCategory(String euVehicleCategory) {
    this.euVehicleCategory = euVehicleCategory;
    return this;
  }

   /**
   * HGV/PSV
   * @return euVehicleCategory
  **/
  public String getEuVehicleCategory() {
    return euVehicleCategory;
  }

  public void setEuVehicleCategory(String euVehicleCategory) {
    this.euVehicleCategory = euVehicleCategory;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleClass vehicleClass = (VehicleClass) o;
    return Objects.equals(this.code, vehicleClass.code) &&
        Objects.equals(this.description, vehicleClass.description) &&
        Objects.equals(this.vehicleType, vehicleClass.vehicleType) &&
        Objects.equals(this.vehicleSize, vehicleClass.vehicleSize) &&
        Objects.equals(this.vehicleConfiguration, vehicleClass.vehicleConfiguration) &&
        Objects.equals(this.euVehicleCategory, vehicleClass.euVehicleCategory);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, description, vehicleType, vehicleSize, vehicleConfiguration, euVehicleCategory);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VehicleClass {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    vehicleType: ").append(toIndentedString(vehicleType)).append("\n");
    sb.append("    vehicleSize: ").append(toIndentedString(vehicleSize)).append("\n");
    sb.append("    vehicleConfiguration: ").append(toIndentedString(vehicleConfiguration)).append("\n");
    sb.append("    euVehicleCategory: ").append(toIndentedString(euVehicleCategory)).append("\n");
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
