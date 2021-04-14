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

import java.io.IOException;
import java.util.Objects;

/**
 * Microfilm
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-04-13T13:30:43.231Z[GMT]")
public class Microfilm {
  /**
   * Used for all vehicle types
   */
  @JsonAdapter(MicrofilmDocumentTypeEnum.Adapter.class)
  public enum MicrofilmDocumentTypeEnum {
    PSV_MISCELLANEOUS("PSV Miscellaneous"),
    AAT_TRAILER_ANNUAL_TEST("AAT - Trailer Annual Test"),
    AIV_HGV_INTERNATIONAL_APP("AIV - HGV International App"),
    COIF_MODIFICATION("COIF Modification"),
    TRAILER_COC_INT_PLATE("Trailer COC + Int Plate"),
    RCT_TRAILER_TEST_CERT_PAID("RCT - Trailer Test Cert paid"),
    HGV_COC_INT_PLATE("HGV COC + Int Plate"),
    PSV_CARRY_AUTH("PSV Carry/Auth"),
    OMO_REPORT("OMO Report"),
    AIT_TRAILER_INTERNATIONAL_APP("AIT - Trailer International App"),
    IPV_HGV_EEC_PLATE_CERT("IPV - HGV EEC Plate/Cert"),
    XCV_HGV_TEST_CERT_FREE("XCV - HGV Test Cert free"),
    AAV_HGV_ANNUAL_TEST("AAV - HGV Annual Test"),
    COIF_MASTER("COIF Master"),
    TEMPO_100_SP_ORD("Tempo 100 Sp Ord"),
    DELETED("Deleted"),
    PSV_N_ALT("PSV N/ALT"),
    XPT_TR_PLATING_CERT_PAID("XPT - Tr Plating Cert paid"),
    FFV_HGV_FIRST_TEST("FFV - HGV First Test"),
    REPL_VITESSE_100("Repl Vitesse 100"),
    TCV_HGV_TEST_CERT("TCV - HGV Test Cert"),
    ZZZ_MISCELLANEOUS("ZZZ -  Miscellaneous"),
    TEST_CERTIFICATE("Test Certificate"),
    XCT_TRAILER_TEST_CERT_FREE("XCT - Trailer Test Cert free"),
    C52_COC_AND_VTG52A("C52 - COC and VTG52A"),
    TEMPO_100_REPORT("Tempo 100 Report"),
    MAIN_FILE_AMENDMENT("Main File Amendment"),
    PSV_DOC("PSV Doc"),
    PSV_COC("PSV COC"),
    PSV_REPL_COC("PSV Repl COC"),
    TAV_COC("TAV - COC"),
    NPT_TRAILER_ALTERATION("NPT - Trailer Alteration"),
    OMO_CERTIFICATE("OMO Certificate"),
    PSV_REPL_COIF("PSV Repl COIF"),
    PSV_REPL_COF("PSV Repl COF"),
    COIF_APPLICATION("COIF Application"),
    XPV_HGV_PLATING_CERT_FREE("XPV - HGV Plating Cert Free"),
    TCT_TRAILER_TEST_CERT("TCT  - Trailer Test Cert"),
    TEMPO_100_APP("Tempo 100 App"),
    PSV_DECISION_ON_N_ALT("PSV Decision on N/ALT"),
    SPECIAL_ORDER_PSV("Special Order PSV"),
    NPV_HGV_ALTERATION("NPV - HGV Alteration"),
    NO_DESCRIPTION_FOUND("No Description Found"),
    VITESSE_100_SP_ORD("Vitesse 100 Sp Ord"),
    BRAKE_TEST_DETAILS("Brake Test Details"),
    COIF_PRODUCTIONAL("COIF Productional"),
    RDT_TEST_DISC_PAID("RDT - Test Disc Paid"),
    RCV_HGV_TEST_CERT("RCV -  HGV Test Cert"),
    FFT_TRAILER_FIRST_TEST("FFT -  Trailer First Test"),
    IPT_TRAILER_EEC_PLATE_CERT("IPT - Trailer EEC Plate/Cert"),
    XDT_TEST_DISC_FREE("XDT - Test Disc Free"),
    PRV_HGV_PLATING_CERT_PAID("PRV - HGV Plating Cert paid"),
    COF_CERT("COF Cert"),
    PRT_TR_PLATING_CERT_PAID("PRT - Tr Plating Cert paid"),
    TEMPO_100_PERMIT("Tempo 100 Permit");

    private String value;

    MicrofilmDocumentTypeEnum(String value) {
      this.value = value;
    }
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    public static MicrofilmDocumentTypeEnum fromValue(String text) {
      for (MicrofilmDocumentTypeEnum b : MicrofilmDocumentTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<MicrofilmDocumentTypeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MicrofilmDocumentTypeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MicrofilmDocumentTypeEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return MicrofilmDocumentTypeEnum.fromValue(String.valueOf(value));
      }
    }
  }  @SerializedName("microfilmDocumentType")
  private MicrofilmDocumentTypeEnum microfilmDocumentType = null;

  @SerializedName("microfilmRollNumber")
  private String microfilmRollNumber = null;

  @SerializedName("microfilmSerialNumber")
  private String microfilmSerialNumber = null;

  public Microfilm microfilmDocumentType(MicrofilmDocumentTypeEnum microfilmDocumentType) {
    this.microfilmDocumentType = microfilmDocumentType;
    return this;
  }

   /**
   * Used for all vehicle types
   * @return microfilmDocumentType
  **/
    public MicrofilmDocumentTypeEnum getMicrofilmDocumentType() {
    return microfilmDocumentType;
  }

  public void setMicrofilmDocumentType(MicrofilmDocumentTypeEnum microfilmDocumentType) {
    this.microfilmDocumentType = microfilmDocumentType;
  }

  public Microfilm microfilmRollNumber(String microfilmRollNumber) {
    this.microfilmRollNumber = microfilmRollNumber;
    return this;
  }

   /**
   * Used for all vehicle types
   * @return microfilmRollNumber
  **/
    public String getMicrofilmRollNumber() {
    return microfilmRollNumber;
  }

  public void setMicrofilmRollNumber(String microfilmRollNumber) {
    this.microfilmRollNumber = microfilmRollNumber;
  }

  public Microfilm microfilmSerialNumber(String microfilmSerialNumber) {
    this.microfilmSerialNumber = microfilmSerialNumber;
    return this;
  }

   /**
   * Used for all vehicle types
   * @return microfilmSerialNumber
  **/
    public String getMicrofilmSerialNumber() {
    return microfilmSerialNumber;
  }

  public void setMicrofilmSerialNumber(String microfilmSerialNumber) {
    this.microfilmSerialNumber = microfilmSerialNumber;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Microfilm microfilm = (Microfilm) o;
    return Objects.equals(this.microfilmDocumentType, microfilm.microfilmDocumentType) &&
        Objects.equals(this.microfilmRollNumber, microfilm.microfilmRollNumber) &&
        Objects.equals(this.microfilmSerialNumber, microfilm.microfilmSerialNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(microfilmDocumentType, microfilmRollNumber, microfilmSerialNumber);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Microfilm {\n");
    
    sb.append("    microfilmDocumentType: ").append(toIndentedString(microfilmDocumentType)).append("\n");
    sb.append("    microfilmRollNumber: ").append(toIndentedString(microfilmRollNumber)).append("\n");
    sb.append("    microfilmSerialNumber: ").append(toIndentedString(microfilmSerialNumber)).append("\n");
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