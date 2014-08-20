package userImport.model;

import userImport.parser.jaxbParser.TimestampAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Timestamp;

@XmlRootElement(name = "LoyaltyMember")
public class LoyaltyMember implements java.io.Serializable {
    private static final long serialVersionUID = -7132732818181465L;
    private int loyaltyMemberId;
    private int loyaltyProgramId;
    private int joinChannelId;
    private String userKey;
    private String membershipNumber;
    private String externalId;
    private String emailAddress;
    private Timestamp dateCreated;
    private Timestamp dateDeleted;
    private Timestamp transDate;
    private boolean exported;
    private Timestamp lastExportedDate;
    private BigDecimal balance;
    private BigDecimal points;

    public LoyaltyMember() {
        balance = new BigDecimal(0.0f, MathContext.UNLIMITED);
    }
    public int getLoyaltyMemberId() {
        return loyaltyMemberId;
    }
    @XmlElement(name = "LoyaltyMemberId")
    public void setLoyaltyMemberId(int loyaltyMemberId) {
        this.loyaltyMemberId = loyaltyMemberId;
    }


    public int getLoyaltyProgramId() {
        return loyaltyProgramId;
    }
    @XmlElement(name = "LoyaltyProgramId")
    public void setLoyaltyProgramId(int loyaltyProgramId) {
        this.loyaltyProgramId = loyaltyProgramId;
    }

    public int getJoinChannelId() {
        return joinChannelId;
    }
    @XmlElement(name = "JoinChannelId")
    public void setJoinChannelId(int joinChannelId) {
        this.joinChannelId = joinChannelId;
    }

    public String getUserKey() {
        return userKey;
    }
    @XmlElement(name = "UserKey")
    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }
    @XmlElement(name = "MembershipNumber")
    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;}
    public String getExternalId() {
        return externalId;
    }
    @XmlElement(name = "ExternalId")
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    @XmlElement(name = "EmailAddress")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }
    @XmlElement(name = "DateCreated")
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getDateDeleted() {
        return dateDeleted;
    }
    @XmlElement(name = "DateDeleted")
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    public void setDateDeleted(Timestamp dateDeleted) {
        this.dateDeleted = dateDeleted;
    }

    public Timestamp getTransDate() {
        return transDate;
    }
    @XmlElement(name = "TransDate")
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    public void setTransDate(Timestamp transDate) {
        this.transDate = transDate;
    }

    public boolean isExported() {
        return exported;
    }
    @XmlElement(name = "Exported")
    public void setExported(boolean exported) {
        this.exported = exported;
    }
    public Timestamp getLastExportedDate() {
        return lastExportedDate;
    }
    @XmlElement(name = "LastExportedDate")
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    public void setLastExportedDate(Timestamp lastExportedDate) {
        this.lastExportedDate = lastExportedDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    @XmlElement(name = "Balance")
    public void setBalance(BigDecimal balance) {
        this.balance = balance == null ? new BigDecimal(0.0f, MathContext.UNLIMITED)
                : balance;}

    public BigDecimal getPoints() {
        return points;
    }
    @XmlElement(name = "Points")
    public void setPoints(BigDecimal points) {
        this.points = points == null ? new BigDecimal(0.0f, MathContext.UNLIMITED)
                : balance;
    }
    @Override
    public String toString() {
        return "LoyaltyMember [loyaltyMemberId=" + loyaltyMemberId
                + ", loyaltyProgramId=" + loyaltyProgramId + ",joinChannelId="
                + joinChannelId + ", userKey=" + userKey
                + ", membershipNumber=" + membershipNumber + ", externalId="
                + externalId + ", emailAddress=" + emailAddress
                + ", dateCreated=" + dateCreated + ", dateDeleted="
                + dateDeleted + ", transDate=" + transDate + ", exported="
                + exported + ", lastExportedDate=" + lastExportedDate
                + ", balance=" + balance + "]";
    }
}