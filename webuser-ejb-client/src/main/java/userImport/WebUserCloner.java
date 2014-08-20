package userImport;


import com.webuser.model.LoyaltyMember;
import userImport.model.Parameter;
import userImport.model.WebUser;

import java.util.*;

public class WebUserCloner {
    public com.webuser.model.WebUser copyWebUser(WebUser webUser) {
        com.webuser.model.WebUser newWebUser = new com.webuser.model.WebUser();
        copyAllFields(webUser,newWebUser);
        return newWebUser;
    }

    private void copyAllFields(WebUser from, com.webuser.model.WebUser to) {
        to.setAcceptAuctionTermsAndConditions(from.getAcceptAuctionTermsAndConditions());
        to.setAddressId(from.getAddressId());
        to.setCardNumber(from.getCardNumber());
        to.setCity(from.getCity());
        to.setCompanyName(from.getCompanyName());
        to.setCompanyNumber(from.getCompanyNumber());
        to.setCountryCode(from.getCountryCode());
        to.setCustomerCode(from.getCustomerCode());
        to.setCompanyNumber(from.getCompanyNumber());
        to.setDateCreated(from.getDateCreated());
        to.setDateOfBirth(from.getDateOfBirth());
        to.setDealerId(from.getDealerId());
        to.setDiscountPercentage(from.getDiscountPercentage());
        to.setDiscountType(from.getDiscountType());
        to.setEmailAddress(from.getEmailAddress());
        to.setExpressCheckoutEnabled(from.getExpressCheckoutEnabled());
        to.setFacebookId(from.getFacebookId());
        to.setFailedCheckoutPwAttempts(from.getFailedCheckoutPwAttempts());
        to.setFax(from.getFax());
        to.setFirstName(from.getFirstName());
        to.setGstNumber(from.getGstNumber());
        to.setImportedUserId(from.getImportedUserId());
        to.setInvalidLoginAttempts(from.getInvalidLoginAttempts());
        to.setInvalidSecretAttempts(from.getInvalidSecretAttempts());
        to.setJoinChannelId(from.getJoinChannelId());
        to.setLastFailedCheckoutPwDate(from.getLastFailedCheckoutPwDate());
        to.setLastInvalidLoginDate(from.getLastInvalidLoginDate());
        to.setLastInvalidSecretDate(from.getLastInvalidSecretDate());
        to.setLastLoginDate(from.getLastLoginDate());
        to.setLastName(from.getLastName());
        to.setLastPasswordChangedDate(from.getLastPasswordChangedDate());
        to.setMobileNumber(from.getMobileNumber());
        to.setNewsLetterSubscribe(from.getNewsLetterSubscribe());
        to.setOtherPhoneNumber(from.getOtherPhoneNumber());
        to.setPassword(from.getPassword());
        to.setPasswordFormat(from.getPasswordFormat());
        to.setPasswordResetExpiryDate(from.getPasswordResetExpiryDate());
        to.setPasswordResetToken(from.getPasswordResetToken());
        to.setPasswordSalt(from.getPasswordSalt());
        to.setPostCode(from.getPostCode());
        to.setSalesAreaCode(from.getSalesAreaCode());
        to.setSecretAnswer(from.getSecretAnswer());
        to.setSecretQuestion(from.getSecretQuestion());
        to.setStaffId(from.getStaffId());
        to.setStatus(from.getStatus());
        to.setStoreId(from.getStoreId());
        to.setStreetAddress(from.getStreetAddress());
        to.setStreetAddress2(from.getStreetAddress2());
        to.setSuburb(from.getSuburb());
        to.setUserKey(from.getUserKey());
        to.setUsername(from.getUsername());
        to.setWebuserTypeId(from.getWebuserTypeId());
        copyLoyaltyMembers(from, to);
        Map<String, String> parameters = new LinkedHashMap<String, String>();
        List<Parameter> fromParameters = from.getParameters();
        if (fromParameters != null) {
            for(Parameter parameter: fromParameters){
                parameters.put(parameter.getName(),parameter.getValue());
            }
        }
        to.setParameters(parameters);
    }

    public void copyLoyaltyMembers(WebUser from, com.webuser.model.WebUser to) {
        Set<LoyaltyMember> loyaltyMembers = new HashSet<LoyaltyMember>();
        Set<userImport.model.LoyaltyMember> fromLoyaltyMembers = from.getLoyaltyMembers();
        if (fromLoyaltyMembers != null) {
            for(userImport.model.LoyaltyMember loyaltyMember: fromLoyaltyMembers){
                LoyaltyMember newLoyaltyMember = new LoyaltyMember();
                newLoyaltyMember.setLoyaltyMemberId(loyaltyMember.getLoyaltyMemberId());
                newLoyaltyMember.setLoyaltyProgramId(loyaltyMember.getLoyaltyProgramId());
                newLoyaltyMember.setJoinChannelId(loyaltyMember.getJoinChannelId());
                newLoyaltyMember.setUserKey(loyaltyMember.getUserKey());
                newLoyaltyMember.setMembershipNumber(loyaltyMember.getMembershipNumber());
                newLoyaltyMember.setExternalId(loyaltyMember.getExternalId());
                newLoyaltyMember.setExported(loyaltyMember.isExported());
                newLoyaltyMember.setEmailAddress(loyaltyMember.getEmailAddress());
                newLoyaltyMember.setDateCreated(loyaltyMember.getDateCreated());
                newLoyaltyMember.setDateDeleted(loyaltyMember.getDateDeleted());
                newLoyaltyMember.setTransDate(loyaltyMember.getTransDate());
                newLoyaltyMember.setBalance(loyaltyMember.getBalance());
                newLoyaltyMember.setPoints(loyaltyMember.getPoints());
                newLoyaltyMember.setLastExportedDate(loyaltyMember.getLastExportedDate());
                loyaltyMembers.add(newLoyaltyMember);
            }
        }
        to.setLoyaltyMembers(loyaltyMembers);
    }

}
