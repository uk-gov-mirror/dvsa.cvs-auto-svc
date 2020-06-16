package clients.model;

import data.GenericData;
import org.json.JSONException;
import org.json.JSONObject;

public enum TestTypes {
    AAV2("94", "aav2"),
    AAV3("94", "aav3"),
    AAV4("94", "aav4"),
    AAV5("94", "aav5"),
    AAT1("40", "aat1"),
    AAT2("94", "aat2"),
    AAT3("94", "aat3"),
    AAT4("94", "aat4"),
    AAT5("94", "aat5"),
//    commented test types are not yet added in the test-types.json file
//    TGV2("40", "tgv2"),
//    TGV3("40", "tgv3"),
//    TGV4("40", "tgv4"),
    FFV2("95", "ffv2"),
    FFV3("95", "ffv3"),
    FFV4("95", "ffv4"),
    FFV5("95", "ffv5"),
    FFT1("41", "fft1"),
    FFT2("95", "fft2"),
    FFT3("95", "fft3"),
    FFT4("95", "fft4"),
    FFT5("95", "fft5"),
//    FGV2("40", "fgv2"),
//    FGV3("40", "fgv3"),
//    FGV4("40", "fgv4"),
    LDV("44", "ldv"),
    LEV("45", "lev"),
    NFV("47", "nfv"),
    NFT("47", "nft"),
    NVV("48", "nvv"),
    NVT("48", "nvt"),
    TIV("49", "tiv"),
    TIT("49", "tit"),
    DDV("50", "ddv"),
    DDT("50", "ddt"),
    RPV2("53", "rpv2"),
    RPV3("53", "rpv3"),
    RPV4("53", "rpv4"),
    RPV5("53", "rpv5"),
    RPT1("98", "rpt1"),
    RPT2("53", "rpt2"),
    RPT3("53", "rpt3"),
    RPT4("53", "rpt4"),
    RPT5("53", "rpt5"),
//    PGV2("40", "pgv2"),
//    PGV3("40", "pgv3"),
//    PGV4("40", "pgv4"),
    RSV2("54", "rsv2"),
    RSV3("54", "rsv3"),
    RSV4("54", "rsv4"),
    RSV5("54", "rsv5"),
    RST1("99", "rst1"),
    RST2("54", "rst2"),
    RST3("54", "rst3"),
    RST4("54", "rst4"),
    RST5("54", "rst5"),
//    PTV2("40", "tgv2"),
//    PTV3("40", "tgv3"),
//    PTV4("40", "tgv4"),
    TRV("56", "trv"),
    TRT("56", "trt"),
    RFT("57", "rft"),
    ARV("59", "arv"),
    ART("59", "art"),
    DRV("60", "drv"),
    DRT("60", "drt"),
    QKV("62", "qkv"),
    MDA("100", "mda"),
    MDU("121", "mdu"),
    QKT("101", "qkt"),
    QPV("62", "qpv"),
    QPT("62", "qpt"),
    QQV("62", "qqv"),
    QQT("62", "qqt"),
    RUV("63", "ruv"),
    RUT("63", "rut"),
    RGV2("65", "rgv2"),
    RGV3("65", "rgv3"),
    RGV4("65", "rgv4"),
    RGV5("65", "rgv5"),
    RGT1("103", "rgt1"),
    RGT2("65", "rgt2"),
    RGT3("65", "rgt3"),
    RGT4("65", "rgt4"),
    RGT5("65", "rgt5"),
    RIV2("66", "riv2"),
    RIV3("66", "riv3"),
    RIV4("66", "riv4"),
    RIV5("66", "riv5"),
    RIT1("104", "rit1"),
    RIT2("66", "rit2"),
    RIT3("66", "rit3"),
    RIT4("66", "rit4"),
    RIT5("66", "rit5"),
    RHT("67", "rht"),
    P1V2("70", "p1v2"),
    P1V3("70", "p1v3"),
    P1V4("70", "p1v4"),
    P1V5("70", "p1v5"),
    P1T1("107", "p1t1"),
    P1T2("70", "p1t2"),
    P1T3("70", "p1t3"),
    P1T4("70", "p1t4"),
    P1T5("70", "p1t5"),
    PBV2("71", "pbv2"),
    PBV3("71", "pbv3"),
    PBV4("71", "pbv4"),
    PBV5("71", "pbv5"),
    PBT1("108", "pbt1"),
    PBT2("71", "pbt2"),
    PBT3("71", "pbt3"),
    PBT4("71", "pbt4"),
    PBT5("71", "pbt5"),
    POV2("72", "pov2"),
    POV3("72", "pov3"),
    POV4("72", "pov4"),
    POV5("72", "pov5"),
    POT1("109", "pot1"),
    POT2("72", "pot2"),
    POT3("72", "pot3"),
    POT4("72", "pot4"),
    POT5("72", "pot5"),
    PAV2("73", "pav2"),
    PAV3("73", "pav3"),
    PAV4("73", "pav4"),
    PAV5("73", "pav5"),
    PAT1("110", "pat1"),
    PAT2("73", "pat2"),
    PAT3("73", "pat3"),
    PAT4("73", "pat4"),
    PAT5("73", "pat5"),
    P3V2("76", "p3v2"),
    P3V3("76", "p3v3"),
    P3V4("76", "p3v4"),
    P3V5("76", "p3v5"),
    P3T1("113", "p3t1"),
    P3T2("76", "p3t2"),
    P3T3("76", "p3t3"),
    P3T4("76", "p3t4"),
    P3T5("76", "p3t5"),
    PFV2("77", "pfv2"),
    PFV3("77", "pfv3"),
    PFV4("77", "pfv4"),
    PFV5("77", "pfv5"),
    PFT1("114", "pft1"),
    PFT2("77", "pft2"),
    PFT3("77", "pft3"),
    PFT4("77", "pft4"),
    PFT5("77", "pft5"),
    P6V2("79", "p6v2"),
    P6V3("79", "p6v3"),
    P6V4("79", "p6v4"),
    P6V5("79", "p6v5"),
    P6T1("116", "p6t1"),
    P6T2("79", "p6t2"),
    P6T3("79", "p6t3"),
    P6T4("79", "p6t4"),
    P6T5("79", "p6t5"),
    P2V2("80", "p2v2"),
    P2V3("80", "p2v3"),
    P2V4("80", "p2v4"),
    P2V5("80", "p2v5"),
    P2T1("117", "p2t1"),
    P2T2("80", "p2t2"),
    P2T3("80", "p2t3"),
    P2T4("80", "p2t4"),
    P2T5("80", "p2t5"),
    P7V2("82", "p7v2"),
    P7V3("82", "p7v3"),
    P7V4("82", "p7v4"),
    P7V5("82", "p7v5"),
    P7T1("119", "p7t1"),
    P7T2("82", "p7t2"),
    P7T3("82", "p7t3"),
    P7T4("82", "p7t4"),
    P7T5("82", "p7t5"),
    P4V2("83", "p4v2"),
    P4V3("83", "p4v3"),
    P4V4("83", "p4v4"),
    P4V5("83", "p4v5"),
    P4T1("120", "p4t1"),
    P4T2("83", "p4t2"),
    P4T3("83", "p4t3"),
    P4T4("83", "p4t4"),
    P4T5("83", "p4t5"),
    BIB("85", "bib"),
    QAV2("85", "qav2"),
    QAV3("85", "qav3"),
    QAV4("85", "qav4"),
    QAV5("85", "qav5"),
    QAT1("85", "qat1"),
    QAT2("85", "qat2"),
    QAT3("85", "qat3"),
    QAT4("85", "qat4"),
    QAT5("85", "qat5"),
    QBV("86", "qbv"),
    BID_HGV("87", "bid_hgv"),
    BID_TRL("87", "bid_trl"),
    BIF_HGV("88", "bif_hgv"),
    QCV("89", "qcv"),
    QDV("90", "qdv"),
    QJV2("122", "qjv2"),
    QJV3("122", "qjv3"),
    QJV4("122", "qjv4"),
    QJV5("122", "qjv5"),
    QJT1("91", "qjt1"),
    QJT2("122", "qjt2"),
    QJT3("122", "qjt3"),
    QJT4("122", "qjt4"),
    QJT5("122", "qjt5"),
    AAL("1", "aal"),
    AAS("1", "aas"),
    ADL("1", "adl"),
    WDL("3", "wdl"),
    WDS("3", "wds"),
    WBL("4", "wbl"),
    WBS("4", "wbs"),
    RHL("7", "rhl"),
    RPL("7", "rpl"),
    RPS("7", "rps"),
    WHL("8", "whl"),
    WHS("8", "whs"),
    RGL("10", "rgl"),
    RSL("10", "rsl"),
    RSS("10", "rss"),
    PHL("15", "phl"),
    PHS("15", "phs"),
    P1L("14", "p1l"),
    P1S("14", "p1s"),
    P8L("18", "p8l"),
    P8S("18", "p8s"),
    PML("19", "pml"),
    PMS("19", "pms"),
    P6L("21", "p6l"),
    P6S("21", "p6s"),
    P2L("22", "p2l"),
    P2S("22", "p2s"),
//    P3L("14", "p3l"),
    PGL("23", "pgl"),
    PGS("23", "pgs"),
    PRL("16", "prl"),
    PRS("16", "prs"),
    WIL("28", "wil"),
    WIS("28", "wis"),
    WEL("93", "wfl"),
    WES("93", "wfs"),
    QAL("30", "qal"),
    QAS("30", "qas"),
    QGL("30", "qgl"),
    QGS("30", "qgs"),
    QDL("31", "qdl"),
    QDS("31", "qds"),
    QCL("32", "qcl"),
    QCS("32", "qcs"),
    QBL("33", "qbl"),
    QBS("33", "qbs"),
    BIF_PSV("34", "bif_psv"),
    TEL("36", "tel"),
    TES("36", "tes"),
    NFL("38", "nfl"),
    NFS("38", "nfs"),
    LCP("39", "lcp"),
    LBP("39", "lbp"),

    YF4("125", "yf4"),
    YL4("125", "yl4"),
    YF7("125", "yf7"),
    YL7("125", "yf7"),
    YAS("126", "yas"),
    YEL("126", "yel"),
    YJL("126", "yjl"),
    YAV("186", "yav"),
    YEV("186", "yev"),
    YAT("186", "yat"),
    YET("186", "yet"),
    YJT("186", "yjt"),
    YNT("186", "ynt"),
    YA4("187", "ya4"),
    YA7("187", "ya7"),
    YDS("128", "yds"),
    YHL("128", "yhl"),
    YML("128", "yml"),
    YDV("188", "ydv"),
    YHV("188", "yhv"),
    YDT("188", "ydt"),
    YHT("188", "yht"),
    YMT("188", "ymt"),
    YRT("188", "yrt"),
    YE4("189", "ye4"),
    YE7("189", "ye7"),
    YK7("129", "yk7"),
    YQ7("129", "yq7"),
    YK4("129", "yk4"),
    YQ4("129", "yq4"),
    YXZ("130", "yxz"),
    
    EA1("133", "ea1"),
    ED1("134", "ed1"),
    EA2("134", "ea2"),
    EA3("134", "ea3"),
    EA4("134", "ea4"),
    EG4("134", "eg4"),
    ED3("135", "ed3"),
    ED4("135", "ed4"),
    EJ4("135", "ej4"),
    QT1("136", "qt1"),
    QT2("136", "qt2"),
    QT3("136", "qt3"),
    QT4("136", "qt4"),
    EAA("138", "eaa"),
    EAB("139", "eab"),
    EAC("139", "eac"),
    EAD("139", "ead"),
    EAF("139", "eaf"),
    EAH("139", "eah"),
    EAE("140", "eae"),
    EAG("140", "eag"),
    EAI("140", "eai"),
    CEL("142", "cel"),
    CES("142", "ces"),
    CFL("143", "cfl"),
    CFS("143", "cfs"),
    GAL("144", "gal"),
    GAS("144", "gas"),
    CHL("146", "chl"),
    CHS("146", "chs"),
    CGL("147", "cgl"),
    CGS("147", "cgs"),
    FAL("148", "fal"),
    FAS("148", "fas"),
    SEVEN_LL("150", "7ll"),
    SEVEN_OL("151", "7ol"),
    YYS("153", "yys"),
    YWL("153", "ywl"),
    YYL("153", "yyl"),
    YJV("190", "yjv"),
    YLV("190", "ylv"),
    YST("190", "yst"),
    YUT("190", "yut"),
    YWT("190", "ywt"),
    YYT("190", "yyt"),
    YD4("191", "yd4"),
    YD7("191", "yd7"),
    YJ4("154", "yj4"),
    YP4("154", "yp4"),
    YP7("154", "yp7"),
    YJ7("154", "yj7"),
    YG4("158", "yg4"),
    YM4("158", "ym4"),
    YG7("158", "yg7"),
    YM7("158", "ym7"),
    YH4("159", "yh4"),
    YN4("159", "yn4"),
    YN7("159", "yn7"),
    YH7("159", "yh7"),
    YBS("161", "ybs"),
    YFL("161", "yfl"),
    YKL("161", "ykl"),
    YBV("192", "ybv"),
    YFV("192", "yfv"),
    YBT("192", "ybt"),
    YFT("192", "yft"),
    YKT("192", "ykt"),
    YPT("192", "ypt"),
    YB4("193", "yb4"),
    YB7("193", "yb7"),
    YCS("162", "ycs"),
    YGL("162", "ygl"),
    YLL("162", "yll"),
    YCV("194", "ycv"),
    YGV("194", "ygv"),
    YCT("194", "yct"),
    YGT("194", "ygt"),
    YLT("194", "ylt"),
    YQT("194", "yqt"),
    YC4("195", "yc4"),
    YC7("195", "yc7"),
    YUZ("163", "yuz"),
    EB1("166", "eb1"),
    EC1("167", "ec1"),
    EB2("169", "eb2"),
    EE1("169", "ee1"),
    EB3("169", "eb3"),
    EB4("169", "eb4"),
    EH4("169", "eh4"),
    EC2("170", "ec2"),
    EF1("170", "ef1"),
    EC3("170", "ec3"),
    EC4("170", "ec4"),
    EI4("170", "ei4"),
    EE3("172", "ee3"),
    EE4("172", "ee4"),
    EK4("172", "ek4"),
    EL4("173", "el4"),
    EF3("173", "ef3"),
    EF4("173", "ef4"),
    CKL("175", "ckl"),
    CKS("175", "cks"),
    CRL("176", "crl"),
    CRS("176", "crs"),
    CML("177", "cml"),
    CMS("177", "cms"),
    GIL("178", "gil"),
    GIS("178", "gis"),
    TTL("179", "ttl"),
    TTS("179", "tts"),
    SEVEN_FL("181", "7fl"),
    SEVEN_IL("182", "7il"),
    YZS("184", "yzs"),
    YXL("184", "yxl"),
    YZL("184", "yzl"),
    YKV("196", "ykv"),
    YMV("196", "ymv"),
    YTT("196", "ytt"),
    YVT("196", "yvt"),
    YXT("196", "yxt"),
    YZT("196", "yzt"),
    YR4("197", "yr4"),
    YR7("197", "yr7"),
    YS4("185", "ys4"),
    YT4("185", "yt4"),
    YT7("185", "yt7"),
    YS7("185", "ys7");

    private final String id;
    private final String testCode;

    TestTypes(String id, String testCode) {
        this.id = id;
        this.testCode = testCode;
    }

    public String getTestCode() {
        return testCode;
    }

    public String getClassification() {
        return GenericData.readJsonValueFromFile("test-type.json", "$..[?(@.id =='" +
                    getId() + "')].testTypeClassification");
    }

    public String getId() {
        return id;
    }
}
