package com.webuser.model;
import org.apache.log4j.Logger;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Entity
@Table(name = "WEBUSER")
public class WebUser implements java.io.Serializable {
    private static final long serialVersionUID = 2424534564894000L;
    private static final Logger logger = Logger.getLogger(WebUser.class);

    private String userKey;
    private String username;
    private String password;
    private Timestamp dateCreated;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String otherPhoneNumber;
    private String streetAddress;
    private String suburb;
    private String city;
    private String companyName;
    private String postCode;
    private String countryCode;
    private Map<String, String> parameters;
    private String customerCode;
    private String salesAreaCode;
    private Integer storeId;
    private Float discountPercent;
    private java.sql.Date dateOfBirth;
    private String newsLetterSubscribe; private String gstNumber;
    private String companyNumber;
    private String fax;
    private String status;
    private String streetAddress2;
    private Set<LoyaltyMember> loyaltyMembers;
    private Integer dealerId;

    private int invalidLoginAttempts=0;

    private Timestamp lastInvalidLoginDate;

    private String secretQuestion;
    private String secretAnswer;
    private int invalidSecretAttempts;
    private Timestamp lastInvalidSecretDate;
    private Dealer dealer;
    private Boolean expressCheckoutEnabled;
    private Timestamp lastLoginDate;
    private Timestamp lastPasswordChangedDate;
    private int passwordFormat;
    private String passwordSalt;
    private int failedCheckoutPwAttempts;
    private Timestamp lastFailedCheckoutPwDate;
    private Boolean acceptAuctionTermsAndConditions;
    private Integer dealLocationId;
    private String facebookId;
    private Timestamp passwordResetExpiryDate;
    private String passwordResetToken;

    private String staffId;
    private String cardNumber;
    private String discountType;
    private String addressId;
    private Integer webuserTypeId;
    private String joinChannelId;
    private String importedUserId;

    @Column(name="ADDRESS_ID")
    public String getAddressId() {
        return addressId;
    }
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
    @Column (name="FACEBOOK_ID")
    public String getFacebookId() {
        return facebookId;
    }public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }
    @Column (name="LAST_LOGIN_DATE")
    public Timestamp getLastLoginDate() {
        return lastLoginDate;
    }
    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
    @Column (name="LAST_PASSWORD_CHANGED_DATE")
    public Timestamp getLastPasswordChangedDate() {
        return lastPasswordChangedDate;
    }
    public void setLastPasswordChangedDate(Timestamp lastPasswordChangedDate) {
        this.lastPasswordChangedDate = lastPasswordChangedDate;
    }
    @Column (name="PASSWORD_FORMAT")
    public int getPasswordFormat() {
        return passwordFormat;
    }
    public void setPasswordFormat(int passwordFormat) {
        this.passwordFormat = passwordFormat;
    }
    @Column (name="PASSWORD_SALT")
    public String getPasswordSalt() {
        return passwordSalt;
    }
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }
    @Column (name="FAILED_CHECKOUT_PW_ATTEMPTS")
    public int getFailedCheckoutPwAttempts() {
        return failedCheckoutPwAttempts;
    }
    public void setFailedCheckoutPwAttempts(int failedCheckoutPwAttempts) {
        this.failedCheckoutPwAttempts = failedCheckoutPwAttempts;
    }
    @Column (name="LAST_FAILED_CHECKOUT_PW_DATE")
    public Timestamp getLastFailedCheckoutPwDate() {
        return lastFailedCheckoutPwDate;
    }
    public void setLastFailedCheckoutPwDate(Timestamp lastFailedCheckoutPwDate) {
        this.lastFailedCheckoutPwDate = lastFailedCheckoutPwDate;
    }
    @Column (name="EXPRESS_CHECKOUT_ENABLED")
    public Boolean getExpressCheckoutEnabled() {
        return expressCheckoutEnabled;
    } public void setExpressCheckoutEnabled(Boolean expressCheckoutEnabled) {
        this.expressCheckoutEnabled = expressCheckoutEnabled;
    }

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_KEY", referencedColumnName = "USER_KEY", insertable = false, updatable = false)
    public Set<LoyaltyMember> getLoyaltyMembers() {
        return loyaltyMembers;
    }
    public void setLoyaltyMembers(Set<LoyaltyMember> loyaltyMembers) {
        this.loyaltyMembers = loyaltyMembers;
    }
    @Transient
    public LoyaltyMember getFirstLoyaltyMember() {
        // this is not the real first program !!! just randomly pick one.
        if (loyaltyMembers == null || loyaltyMembers.size() == 0) {
            return null;
        }
        while (loyaltyMembers.iterator().hasNext()) {
            LoyaltyMember member = loyaltyMembers.iterator().next();
            if (member.getDateDeleted() == null) {
                return member;
            }
        }
        return null;
    }
    public enum UserStatus {
        Enabled("E"), Disabled("D"), Purchased("P");
        private String value;
        UserStatus(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    @Column(name = "FAX")
    public String getFax() {
        return fax;
    }
    public void setFax(String fax) {
        this.fax = fax;
    }
    @Column(name = "COMPANY_NUMBER")
    public String getCompanyNumber() {
        return companyNumber;
    } public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }
    @Column(name = "GST_NUMBER")
    public String getGstNumber() {
        return gstNumber;
    }
    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }
    @Column(name = "CITY", length = 50, nullable = false)
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    @Column(name = "COMPANY_NAME", length = 100, nullable = false)
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    @Column(name = "COUNTRYCODE", length = 3, nullable = false)
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    @Column(name = "DATE_CREATED", nullable = false)
    public Timestamp getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Column(name = "LAST_INVALID_LOGIN_DATE")
    public Timestamp getLastInvalidLoginDate() {
        return lastInvalidLoginDate;
    }
    public void setLastInvalidLoginDate(Timestamp lastInvalidLoginDate) {
        this.lastInvalidLoginDate = lastInvalidLoginDate;
    }
    @Column(name = "INVALID_LOGIN_ATTEMPTS", nullable = false)
    public int getInvalidLoginAttempts() {
        return invalidLoginAttempts;
    }
    public void setInvalidLoginAttempts(int invalidLoginAttempts) {
        this.invalidLoginAttempts = invalidLoginAttempts;
    }
    @Column(name = "EMAIL_ADDRESS", length = 200, nullable = false)
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    @Column(name = "FIRST_NAME", length = 50, nullable = false)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "LAST_NAME", length = 50, nullable = false)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Column(name = "MOBILE_NUMBER", length = 20, nullable = false)
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    @Column(name = "OTHER_PHONE_NUMBER", length = 20, nullable = false)
    public String getOtherPhoneNumber() {
        return otherPhoneNumber;
    }
    public void setOtherPhoneNumber(String otherPhoneNumber) {
        this.otherPhoneNumber = otherPhoneNumber;
    }
    @Column(name = "PASSWORD", length = 50, nullable = false)
    public String getPassword() { return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "POST_CODE", length = 10, nullable = false)
    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    @Column(name = "STREET_ADDRESS", length = 200, nullable = false)
    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    @Column(name = "SUBURB", length = 100, nullable = false)
    public String getSuburb() {
        return suburb;
    }
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
    @Id
    @Column(name = "USER_KEY", length = 50, nullable = false)
    public String getUserKey() {
        return userKey;
    }
    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }
    @Column(name = "USERNAME", length = 50, nullable = false)
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    @Transient
    public Map<String, String> getParameters() {
        return parameters;
    } public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
    @Transient
    public String getParameter(String key) {
        if (parameters == null)
            return null;
        return parameters.get(key);
    }
    public void setParameter(String key, String value) {
        if (parameters == null)
            parameters = new HashMap<String, String>();
        parameters.put(key, value);
    }
    @Column(name = "CUSTOMERCODE", length = 8, nullable = true)
    public String getCustomerCode() {
        return customerCode;
    }
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
    @Column(name = "SALES_AREA_CODE", length = 10, nullable = true)
    public String getSalesAreaCode() {
        return salesAreaCode;
    }
    public void setSalesAreaCode(String salesAreaCode) {
        this.salesAreaCode = salesAreaCode;
    }
    /**
     * The store that this web user is registered to
     *
     * @return
     */
    @Column(name = "STORE_ID")
    public Integer getStoreId() {
        return storeId;
    }
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
    @Column(name = "DISCOUNT_PERCENT")
    public Float getDiscountPercentage() {
        if (discountPercent != null)
            return discountPercent;
        else
            return Float.valueOf(0); }
    public void setDiscountPercentage(Float discountPercent) {
        if (discountPercent != null)
            this.discountPercent = discountPercent;
        else
            this.discountPercent = Float.valueOf(0);
    }
    @Column(name = "DATE_OF_BIRTH", nullable = true)
    public java.sql.Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(java.sql.Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    @Column(name = "NEWSLETTER_SUBSCRIBE")
    public String getNewsLetterSubscribe() {
        return newsLetterSubscribe;
    }
    public void setNewsLetterSubscribe(String newsLetterSubscribe) {
        this.newsLetterSubscribe = newsLetterSubscribe;
    }
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    @Column(name = "STREET_ADDRESS_2")
    public String getStreetAddress2() {
        return streetAddress2;
    }
    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }
    @Column(name = "WEBUSER_TYPE_ID")
    public Integer getWebuserTypeId() {
        return webuserTypeId;
    }
    public void setWebuserTypeId(Integer webuserTypeId) {
        this.webuserTypeId = webuserTypeId;
    }
    @Column(name = "DEALER_ID")
    public Integer getDealerId() {
        return dealerId; }
    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    @Column (name="SECRET_QUESTION")
    public String getSecretQuestion() {
        return secretQuestion;
    }
    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }
    @Column (name="SECRET_ANSWER")
    public String getSecretAnswer() {
        return secretAnswer;
    }
    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }
    @Column (name="INVALID_SECRET_ATTEMPTS")
    public int getInvalidSecretAttempts() {
        return invalidSecretAttempts;
    }
    public void setInvalidSecretAttempts(int invalidSecretAttempts) {
        this.invalidSecretAttempts = invalidSecretAttempts;
    }
    @Column (name="LAST_INVALID_SECRET_DATE")
    public Timestamp getLastInvalidSecretDate() {
        return lastInvalidSecretDate;
    }
    public void setLastInvalidSecretDate(Timestamp lastInvalidSecretDate) {
        this.lastInvalidSecretDate = lastInvalidSecretDate;
    }
    @Column (name="ACCEPT_AUCTION_TERMSCONDITION")
    public Boolean getAcceptAuctionTermsAndConditions() {
        return acceptAuctionTermsAndConditions;
    }
    public void setAcceptAuctionTermsAndConditions(
            Boolean acceptAuctionTermsAndConditions) {
        this.acceptAuctionTermsAndConditions = acceptAuctionTermsAndConditions;
    }
    @Transient
    public boolean isAcceptAuctionTermsAndConditions() {
        return acceptAuctionTermsAndConditions == null ? false : acceptAuctionTermsAndConditions;
    }
    @Column (name="PASSWORD_RESET_EXPIRY_DATE")
    public Timestamp getPasswordResetExpiryDate() {
        return passwordResetExpiryDate;}
    public void setPasswordResetExpiryDate(Timestamp expiryDate) {
        passwordResetExpiryDate = expiryDate;
    }
    @Column (name="PASSWORD_RESET_TOKEN")
    public String getPasswordResetToken() {
        return passwordResetToken;
    }
    public void setPasswordResetToken(String token) {
        passwordResetToken = token;
    }
    @Column (name="STAFF_ID")
    public String getStaffId() {
        return staffId;
    }
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    @Column (name="CARD_NUMBER")
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    @Column (name="DISCOUNT_TYPE")
    public String getDiscountType() {
        return discountType;
    }
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }
    @Column (name=" JOIN_CHANNEL_ID ")
    public String getJoinChannelId() {
        return joinChannelId;
    }
    public void setJoinChannelId (String joinChannelId) {
        this.joinChannelId = joinChannelId;
    }
    @Column (name="IMPORTED_USER_ID")
    public String getImportedUserId() {
        return importedUserId;
    }public void setImportedUserId (String importedUserId) {
        this.importedUserId = importedUserId;
    }
}