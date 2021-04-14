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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.time.LocalDate;

import java.io.IOException;
import java.util.Objects;

/**
 * AdrDetailsTankTankDetailsTc2Details
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-04-13T13:30:43.231Z[GMT]")
public class AdrDetailsTankTankDetailsTc2Details {
  /**
   * Optional. Applicable only if vehicleDetails.type contains the word ‘tank’ or ‘battery’.
   */
  @JsonAdapter(Tc2TypeEnum.Adapter.class)
  public enum Tc2TypeEnum {
    INITIAL("initial");

    private String value;

    Tc2TypeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static Tc2TypeEnum fromValue(String text) {
      for (Tc2TypeEnum b : Tc2TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<Tc2TypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final Tc2TypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public Tc2TypeEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return Tc2TypeEnum.fromValue(String.valueOf(value));
      }
    }
  }  @SerializedName("tc2Type")
  private Tc2TypeEnum tc2Type = null;

  @SerializedName("tc2IntermediateApprovalNo")
  private String tc2IntermediateApprovalNo = null;

  @SerializedName("tc2IntermediateExpiryDate")
  private LocalDate tc2IntermediateExpiryDate = null;

  public AdrDetailsTankTankDetailsTc2Details tc2Type(Tc2TypeEnum tc2Type) {
    this.tc2Type = tc2Type;
    return this;
  }

   /**
   * Optional. Applicable only if vehicleDetails.type contains the word ‘tank’ or ‘battery’.
   * @return tc2Type
  **/
    public Tc2TypeEnum getTc2Type() {
    return tc2Type;
  }

  public void setTc2Type(Tc2TypeEnum tc2Type) {
    this.tc2Type = tc2Type;
  }

  public AdrDetailsTankTankDetailsTc2Details tc2IntermediateApprovalNo(String tc2IntermediateApprovalNo) {
    this.tc2IntermediateApprovalNo = tc2IntermediateApprovalNo;
    return this;
  }

   /**
   * Optional. Applicable only if vehicleDetails.type contains the word ‘tank’ or ‘battery’.
   * @return tc2IntermediateApprovalNo
  **/
    public String getTc2IntermediateApprovalNo() {
    return tc2IntermediateApprovalNo;
  }

  public void setTc2IntermediateApprovalNo(String tc2IntermediateApprovalNo) {
    this.tc2IntermediateApprovalNo = tc2IntermediateApprovalNo;
  }

  public AdrDetailsTankTankDetailsTc2Details tc2IntermediateExpiryDate(LocalDate tc2IntermediateExpiryDate) {
    this.tc2IntermediateExpiryDate = tc2IntermediateExpiryDate;
    return this;
  }

   /**
   * Optional. Date(YYYY-MM-DD). Applicable only if vehicleDetails.type contains the word ‘tank’ or ‘battery’.
   * @return tc2IntermediateExpiryDate
  **/
    public LocalDate getTc2IntermediateExpiryDate() {
    return tc2IntermediateExpiryDate;
  }

  public void setTc2IntermediateExpiryDate(LocalDate tc2IntermediateExpiryDate) {
    this.tc2IntermediateExpiryDate = tc2IntermediateExpiryDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdrDetailsTankTankDetailsTc2Details adrDetailsTankTankDetailsTc2Details = (AdrDetailsTankTankDetailsTc2Details) o;
    return Objects.equals(this.tc2Type, adrDetailsTankTankDetailsTc2Details.tc2Type) &&
        Objects.equals(this.tc2IntermediateApprovalNo, adrDetailsTankTankDetailsTc2Details.tc2IntermediateApprovalNo) &&
        Objects.equals(this.tc2IntermediateExpiryDate, adrDetailsTankTankDetailsTc2Details.tc2IntermediateExpiryDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tc2Type, tc2IntermediateApprovalNo, tc2IntermediateExpiryDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdrDetailsTankTankDetailsTc2Details {\n");
    
    sb.append("    tc2Type: ").append(toIndentedString(tc2Type)).append("\n");
    sb.append("    tc2IntermediateApprovalNo: ").append(toIndentedString(tc2IntermediateApprovalNo)).append("\n");
    sb.append("    tc2IntermediateExpiryDate: ").append(toIndentedString(tc2IntermediateExpiryDate)).append("\n");
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