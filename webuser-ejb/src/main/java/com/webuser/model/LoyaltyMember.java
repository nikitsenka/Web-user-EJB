package com.webuser.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.Timestamp;

@Entity
@Table(name="LOYALTY_MEMBER")
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="LOYALTY_MEMBER_ID")
    public int getLoyaltyMemberId() {
        return loyaltyMemberId;
    }
    public void setLoyaltyMemberId(int loyaltyMemberId) {
        this.loyaltyMemberId = loyaltyMemberId;
    }
    @Column (name="LOYALTY_PROGRAM_ID")
    public int getLoyaltyProgramId() {
        return loyaltyProgramId;
    }
    public void setLoyaltyProgramId(int loyaltyProgramId) {
        this.loyaltyProgramId = loyaltyProgramId;
    }
    @Column (name="JOIN_CHANNEL_ID")
    public int getJoinChannelId() {
        return joinChannelId;
    }
    public void setJoinChannelId(int joinChannelId) {
        this.joinChannelId = joinChannelId;
    }
    @Column (name="USER_KEY")
    public String getUserKey() {
        return userKey;
    }
    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }
    @Column (name="MEMBERSHIP_NUMBER")
    public String getMembershipNumber() {
        return membershipNumber;
    }
    public void setMembershipNumber(String membershipNumber) {
        this.membershipNumber = membershipNumber;}
    @Column (name="EXTERNAL_ID")
    public String getExternalId() {
        return externalId;
    }
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
    @Column (name="EMAIL_ADDRESS")
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    @Column (name="DATE_CREATED")
    public Timestamp getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }
    @Column (name="DATE_DELETED")
    public Timestamp getDateDeleted() {
        return dateDeleted;
    }
    public void setDateDeleted(Timestamp dateDeleted) {
        this.dateDeleted = dateDeleted;
    }
    @Column (name="TRANS_DATE")
    public Timestamp getTransDate() {
        return transDate;
    }
    public void setTransDate(Timestamp transDate) {
        this.transDate = transDate;
    }
    @Column (name="EXPORTED")
    public boolean isExported() {
        return exported;
    }
    public void setExported(boolean exported) {
        this.exported = exported;
    }
    @Column (name="LAST_EXPORTED_DATE")
    public Timestamp getLastExportedDate() {
        return lastExportedDate;
    }
    public void setLastExportedDate(Timestamp lastExportedDate) {
        this.lastExportedDate = lastExportedDate;
    }
    @Column (name="BALANCE")
    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance == null ? new BigDecimal(0.0f, MathContext.UNLIMITED)
                : balance;}
    @Column (name="POINTS")
    public BigDecimal getPoints() {
        return points;
    }
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