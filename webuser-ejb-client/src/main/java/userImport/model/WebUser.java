package userImport.model;

import org.apache.log4j.Logger;
import userImport.parser.jaxbParser.BooleanAdapter;
import userImport.parser.jaxbParser.DateAdapter;
import userImport.parser.jaxbParser.TimestampAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@XmlRootElement(name = "WebUser")
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
    private String customerCode;
    private String salesAreaCode;
    private Integer storeId;
    private Float discountPercent;
    private java.sql.Date dateOfBirth;
    private String newsLetterSubscribe;
    private String gstNumber;
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
    private List<userImport.model.Parameter> Parameters;

    public String getAddressId() {
        return addressId;
    }
    @XmlElement(name = "AddressId")
    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getFacebookId() {
        return facebookId;
    }
    @XmlElement(name = "FacebookId")
    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public Timestamp getLastLoginDate() {
        return lastLoginDate;
    }
    @XmlElement(name = "LastLoginDate")
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Timestamp getLastPasswordChangedDate() {
        return lastPasswordChangedDate;
    }
    @XmlElement(name = "LastPasswordChangedDate")
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    public void setLastPasswordChangedDate(Timestamp lastPasswordChangedDate) {
        this.lastPasswordChangedDate = lastPasswordChangedDate;
    }
    public int getPasswordFormat() {
        return passwordFormat;
    }

    public void setPasswordFormat(int passwordFormat) {
        this.passwordFormat = passwordFormat;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }
    @XmlElement(name = "PasswordSalt")
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public int getFailedCheckoutPwAttempts() {
        return failedCheckoutPwAttempts;
    }
    public void setFailedCheckoutPwAttempts(int failedCheckoutPwAttempts) {
        this.failedCheckoutPwAttempts = failedCheckoutPwAttempts;
    }

    public Timestamp getLastFailedCheckoutPwDate() {
        return lastFailedCheckoutPwDate;
    }
    @XmlElement(name = "LastFailedCheckoutPwDate")
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    public void setLastFailedCheckoutPwDate(Timestamp lastFailedCheckoutPwDate) {
        this.lastFailedCheckoutPwDate = lastFailedCheckoutPwDate;
    }
    public Boolean getExpressCheckoutEnabled() {
        return expressCheckoutEnabled;
    }
    @XmlElement(name="ExpressCheckoutEnabled")
    @XmlJavaTypeAdapter(BooleanAdapter.class)
    public void setExpressCheckoutEnabled(Boolean expressCheckoutEnabled) {
        this.expressCheckoutEnabled = expressCheckoutEnabled;
    }

    public Set<LoyaltyMember> getLoyaltyMembers() {
        return loyaltyMembers;
    }
    @XmlElement(name="LoyaltyMember")
    public void setLoyaltyMembers(Set<LoyaltyMember> loyaltyMembers) {
        this.loyaltyMembers = loyaltyMembers;
    }

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
    public String getFax() {
        return fax;
    }
    @XmlElement(name = "Fax")
    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }
    @XmlElement(name = "CompanyNumber")
    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getGstNumber() {
        return gstNumber;
    }
    @XmlElement(name = "GstNumber")
    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getCity() {
        return city;
    }
    @XmlElement(name = "City")
    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }
    @XmlElement(name = "CompanyName")
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountryCode() {
        return countryCode;
    }
    @XmlElement(name = "CountryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }
    @XmlElement(name = "DateCreated")
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }


    public Timestamp getLastInvalidLoginDate() {
        return lastInvalidLoginDate;
    }
    @XmlElement(name = "LastInvalidLoginDate")
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    public void setLastInvalidLoginDate(Timestamp lastInvalidLoginDate) {
        this.lastInvalidLoginDate = lastInvalidLoginDate;
    }

    public int getInvalidLoginAttempts() {
        return invalidLoginAttempts;
    }

    public void setInvalidLoginAttempts(int invalidLoginAttempts) {
        this.invalidLoginAttempts = invalidLoginAttempts;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
    @XmlElement(name = "Email")
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }
    @XmlElement(name = "FirstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    @XmlElement(name = "LastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
    @XmlElement(name = "MobileNumber")
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getOtherPhoneNumber() {
        return otherPhoneNumber;
    }
    @XmlElement(name = "OtherPhoneNumber")
    public void setOtherPhoneNumber(String otherPhoneNumber) {
        this.otherPhoneNumber = otherPhoneNumber;
    }

    public String getPassword() { return password;
    }
    @XmlElement(name = "Password")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPostCode() {
        return postCode;
    }
    @XmlElement(name = "PostCode")
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }
    @XmlElement(name = "StreetAddress")
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getSuburb() {
        return suburb;
    }
    @XmlElement(name = "Suburb")
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }
    public String getUserKey() {
        return userKey;
    }
    @XmlElement(name = "UserKey")
    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public String getUsername() {
        return username;
    }
    @XmlElement(name = "Username")
    public void setUsername(String username) {
        this.username = username;
    }


    public String getCustomerCode() {
        return customerCode;
    }
    @XmlElement(name = "CustomerCode")
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getSalesAreaCode() {
        return salesAreaCode;
    }
    @XmlElement(name = "SalesAreaCode")
    public void setSalesAreaCode(String salesAreaCode) {
        this.salesAreaCode = salesAreaCode;
    }
    /**
     * The store that this web user is registered to
     *
     * @return
     */

    public Integer getStoreId() {
        return storeId;
    }
    @XmlElement(name = "StoreId")
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Float getDiscountPercentage() {
        if (discountPercent != null)
            return discountPercent;
        else
            return Float.valueOf(0); }
    @XmlElement(name = "DiscountPercent")
    public void setDiscountPercentage(Float discountPercent) {
        if (discountPercent != null)
            this.discountPercent = discountPercent;
        else
            this.discountPercent = Float.valueOf(0);
    }

    public java.sql.Date getDateOfBirth() {
        return dateOfBirth;
    }
    @XmlElement(name = "DateOfBirth")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDateOfBirth(java.sql.Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNewsLetterSubscribe() {
        return newsLetterSubscribe;
    }
    @XmlElement(name = "NewsLetterSubscribe")
    public void setNewsLetterSubscribe(String newsLetterSubscribe) {
        this.newsLetterSubscribe = newsLetterSubscribe;
    }

    public String getStatus() {
        return status;
    }
    @XmlElement(name = "Status")
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }
    @XmlElement(name = "StreetAddress2")
    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public Integer getWebuserTypeId() {
        return webuserTypeId;
    }
    @XmlElement(name = "WebuserTypeId")
    public void setWebuserTypeId(Integer webuserTypeId) {
        this.webuserTypeId = webuserTypeId;
    }

    public Integer getDealerId() {
        return dealerId; }
    @XmlElement(name = "DealerId")
    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }
    @XmlElement(name = "SecretQuestion")
    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    @XmlElement(name = "SecretAnswer")
    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }

    public int getInvalidSecretAttempts() {
        return invalidSecretAttempts;
    }
    @XmlElement(name = "InvalidSecretAttempts")
    public void setInvalidSecretAttempts(int invalidSecretAttempts) {
        this.invalidSecretAttempts = invalidSecretAttempts;
    }

    public Timestamp getLastInvalidSecretDate() {
        return lastInvalidSecretDate;
    }
    @XmlElement(name = "LastInvalidSecretDate")
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    public void setLastInvalidSecretDate(Timestamp lastInvalidSecretDate) {
        this.lastInvalidSecretDate = lastInvalidSecretDate;
    }

    public Boolean getAcceptAuctionTermsAndConditions() {
        return acceptAuctionTermsAndConditions;
    }

    public void setAcceptAuctionTermsAndConditions(
            Boolean acceptAuctionTermsAndConditions) {
        this.acceptAuctionTermsAndConditions = acceptAuctionTermsAndConditions;
    }

    public boolean isAcceptAuctionTermsAndConditions() {
        return acceptAuctionTermsAndConditions == null ? false : acceptAuctionTermsAndConditions;
    }
    public Timestamp getPasswordResetExpiryDate() {
        return passwordResetExpiryDate;}
    @XmlElement(name = "ExpiryDate")
    @XmlJavaTypeAdapter(TimestampAdapter.class)
    public void setPasswordResetExpiryDate(Timestamp expiryDate) {
        passwordResetExpiryDate = expiryDate;
    }

    public String getPasswordResetToken() {
        return passwordResetToken;
    }
    @XmlElement(name = "Token")
    public void setPasswordResetToken(String token) {
        passwordResetToken = token;
    }

    public String getStaffId() {
        return staffId;
    }
    @XmlElement(name = "StaffId")
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    @XmlElement(name = "CardNumber")
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getDiscountType() {
        return discountType;
    }
    @XmlElement(name = "DiscountType")
    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getJoinChannelId() {
        return joinChannelId;
    }
    @XmlElement(name = "JoinChannelId")
    public void setJoinChannelId (String joinChannelId) {
        this.joinChannelId = joinChannelId;
    }

    public String getImportedUserId() {
        return importedUserId;
    }
    @XmlElement(name = "ImportedUserId")
    public void setImportedUserId (String importedUserId) {
        this.importedUserId = importedUserId;
    }
    @XmlElementWrapper(name="Parameters")
    @XmlElement(name="Parameter")
    public void setParameters(List<Parameter> parameters) {
        this.Parameters = parameters;
    }
    public List<Parameter> getParameters() {
        return Parameters;
    }
}