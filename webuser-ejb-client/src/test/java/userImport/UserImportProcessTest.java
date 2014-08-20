package userImport;

import com.webuser.ejb.WebUserManager;
import com.webuser.model.LoyaltyMember;
import org.junit.Before;
import org.junit.Test;
import userImport.model.Parameter;
import userImport.model.WebUser;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static userImport.Utils.getDate;

public class UserImportProcessTest {

    private ImportUserConfig userConfig;
    private WebUserManager webUserManagerMock;

    @Before
    public void setUp() throws Exception {
        userConfig = new ImportUserConfig();
        userConfig.setPasswordFormat(new Integer(0));
        webUserManagerMock = mock(WebUserManager.class);
    }

    @Test
    public void performUserImportCallsCreateNewIfUserNotExist() throws Exception {
        WebUser webUser = new WebUser();
        int storeId = 1;
        String email = "email";
        webUser.setStoreId(storeId);
        webUser.setEmailAddress(email);
        com.webuser.model.WebUser newUserForManager = new com.webuser.model.WebUser();
        when(webUserManagerMock.getSingleWebUserByEmailAddressAndStoreId(email, storeId)).thenReturn(null);
        when(webUserManagerMock.createWebUser(any(com.webuser.model.WebUser.class), eq(false)))
                .thenReturn(newUserForManager);
        UserImportProcess.performUserImport(userConfig, webUserManagerMock, webUser);
        verify(webUserManagerMock).createWebUser(any(com.webuser.model.WebUser.class), eq(false));
    }

    @Test
    public void performUserImportCallsUpdateIfUserExist() throws Exception {
        WebUser webUser = new WebUser();
        int storeId = 1;
        String email = "email";
        webUser.setStoreId(storeId);
        webUser.setEmailAddress(email);
        com.webuser.model.WebUser userFromManager = new com.webuser.model.WebUser();
        when(webUserManagerMock.getSingleWebUserByEmailAddressAndStoreId(email, storeId)).thenReturn(userFromManager);
        UserImportProcess.performUserImport(userConfig, webUserManagerMock, webUser);
        verify(webUserManagerMock).updateWebUser(userFromManager);
    }

    @Test
    public void performUserImportCreatesLoyaltyMemberIfNotExist() throws Exception {
        WebUser webUser = new WebUser();
        int storeId = 1;
        String email = "email";
        webUser.setStoreId(storeId);
        webUser.setEmailAddress(email);

        HashSet<userImport.model.LoyaltyMember> loyaltyMembers = getLoyaltyMembersFixture();
        webUser.setLoyaltyMembers(loyaltyMembers);

        com.webuser.model.WebUser userFromManager = new com.webuser.model.WebUser();
        when(webUserManagerMock.getSingleWebUserByEmailAddressAndStoreId(email, storeId)).thenReturn(userFromManager);
        com.webuser.model.WebUser result = UserImportProcess.performUserImport(userConfig, webUserManagerMock, webUser);
        Set<LoyaltyMember> resultLoyaltyMembers = result.getLoyaltyMembers();
        assertThat(resultLoyaltyMembers.size(), is(1));
        LoyaltyMember resultLoyaltyMember = resultLoyaltyMembers.iterator().next();
        assertThat(resultLoyaltyMember.getExternalId(), is("DW00000064"));
        assertThat(resultLoyaltyMember.getBalance(), is(new BigDecimal(2.00).setScale(2)));
        assertThat(resultLoyaltyMember.getPoints(), is(new BigDecimal(2.00).setScale(2)));
        assertThat(resultLoyaltyMember.isExported(),is(true));
    }

    @Test
    public void performUserImportUpdatesIdAndParametersIfUserExist() throws Exception {
        WebUser webUser = new WebUser();
        int storeId = 1;
        String email = "email";
        webUser.setStoreId(storeId);
        webUser.setEmailAddress(email);
        Parameter parameter = new Parameter();
        parameter.setName("PAR_NAME");
        parameter.setValue("PAR_VALUE");
        webUser.setParameters(Arrays.asList(parameter));
        com.webuser.model.WebUser userFromManager = new com.webuser.model.WebUser();
        when(webUserManagerMock.getSingleWebUserByEmailAddressAndStoreId(email, storeId)).thenReturn(userFromManager);
        com.webuser.model.WebUser result = UserImportProcess.performUserImport(userConfig, webUserManagerMock, webUser);
        assertThat(result.getStoreId(),is(storeId));
        assertThat(result.getParameter("PAR_NAME"),is("PAR_VALUE"));
    }

    @Test
    public void performUserImportSetsThePropertiesIfUserNotExist() throws Exception {
        userConfig.setJoinChannelId("JoinChannelId");
        userConfig.setPasswordFormat(1);
        WebUser webUser = new WebUser();
        int storeId = 1;
        String email = "email";
        webUser.setStoreId(2);
        webUser.setEmailAddress(email);
        webUser.setJoinChannelId("");
        webUser.setPasswordFormat(0);
        when(webUserManagerMock.getSingleWebUserByEmailAddressAndStoreId(email, storeId)).thenReturn(null);
        com.webuser.model.WebUser result = UserImportProcess.performUserImport(userConfig, webUserManagerMock, webUser);
        assertThat(result.getJoinChannelId(), is("JoinChannelId"));
        assertThat(result.getPasswordFormat(),is(1));
    }
    @Test
    public void performUserImportSetsTheUserNameAndEmailIfUserNotExist() throws Exception {
        WebUser webUser = new WebUser();
        int storeId = 1;
        String email = "email";
        webUser.setStoreId(storeId);
        webUser.setEmailAddress(email);
        webUser.setUsername("UserName");
        com.webuser.model.WebUser newUserForManager = new com.webuser.model.WebUser();
        when(webUserManagerMock.getSingleWebUserByEmailAddressAndStoreId(email, storeId)).thenReturn(null);
        when(webUserManagerMock.createWebUser(any(com.webuser.model.WebUser.class), eq(false)))
                .thenReturn(newUserForManager);
        com.webuser.model.WebUser result = UserImportProcess.performUserImport(userConfig, webUserManagerMock, webUser);
        assertThat(result.getEmailAddress(),is("UserName"));
    }

    @Test
    public void performUserImportCreatesUserWithAllDataIfUserNotExist() throws Exception {
        WebUser webUser = getWebUserWithAllData();
        int storeId = 1;
        String email = "email";
        com.webuser.model.WebUser newUserForManager = new com.webuser.model.WebUser();
        when(webUserManagerMock.getSingleWebUserByEmailAddressAndStoreId(email, storeId)).thenReturn(null);
        when(webUserManagerMock.createWebUser(any(com.webuser.model.WebUser.class), eq(false)))
                .thenReturn(newUserForManager);
        com.webuser.model.WebUser result = UserImportProcess.performUserImport(userConfig, webUserManagerMock, webUser);
        assertThat(result.getStoreId(),is(1));
        assertThat(result.getImportedUserId(),is("64"));
        assertThat(result.getFirstName(),is("SHAUN"));
        assertThat(result.getLastName(),is("PEYMAN"));
        assertThat(result.getEmailAddress(),is("email"));
        assertThat(result.getOtherPhoneNumber(),is(""));
        assertThat(result.getMobileNumber(),is("02116859"));
        assertThat(result.getPassword(),is("xxx"));
        assertThat(result.getStreetAddress(),is("3 FOSTER CRES"));
        assertThat(result.getSuburb(),is("SNELLS BEACH"));
        assertThat(result.getCity(),is("Sydney"));
        assertThat(result.getCountryCode(),is("asd"));
        assertThat(result.getPostCode(),is("1052"));
        assertThat(result.getStaffId(),is(""));

        LoyaltyMember loyaltyMember = result.getFirstLoyaltyMember();
        assertThat(loyaltyMember.getExternalId(), is("DW00000064"));
        assertThat(loyaltyMember.getBalance(), is(new BigDecimal(2.00).setScale(2)));
        assertThat(loyaltyMember.getPoints(), is(new BigDecimal(2.00).setScale(2)));
        assertThat(loyaltyMember.isExported(),is(true));
        assertThat(result.getLastLoginDate(),is(getDate("2008-12-15 18:51:25")));
        assertThat(result.getDateCreated(),is(getDate("2008-12-15 18:51:25")));
        assertThat(result.getExpressCheckoutEnabled(),is(true));
        assertThat(result.getDiscountPercentage(),is(new Float(2)));
        Map<String, String> parameters = result.getParameters();
        assertThat(parameters.size(),is(1));
        assertThat(parameters.get("EMAIL_SUB_WEEKLY_SPECIALS"),is("Y"));

    }

    public WebUser getWebUserWithAllData() throws ParseException {
        WebUser webUser = new WebUser();
        webUser.setStoreId(1);
        webUser.setUsername("email");
        webUser.setImportedUserId("64");
        webUser.setFirstName("SHAUN");
        webUser.setLastName("PEYMAN");
        webUser.setEmailAddress("email");
        webUser.setOtherPhoneNumber("");
        webUser.setMobileNumber("02116859");
        webUser.setPassword("xxx");
        webUser.setStreetAddress("3 FOSTER CRES");
        webUser.setSuburb("SNELLS BEACH");
        webUser.setCity("Sydney");
        webUser.setCountryCode("asd");
        webUser.setPostCode("1052");
        webUser.setStaffId("");
        HashSet<userImport.model.LoyaltyMember> loyaltyMembers = getLoyaltyMembersFixture();
        webUser.setLoyaltyMembers(loyaltyMembers);
        webUser.setLastLoginDate(getDate("2008-12-15 18:51:25"));
        webUser.setDateCreated(getDate("2008-12-15 18:51:25"));
        webUser.setExpressCheckoutEnabled(true);
        webUser.setDiscountPercentage(new Float(2));
        List<Parameter> parameters = new ArrayList<Parameter>();
        Parameter parameter = new Parameter();
        parameter.setName("EMAIL_SUB_WEEKLY_SPECIALS");
        parameter.setValue("Y");
        parameters.add(parameter);
        webUser.setParameters(parameters);
        return webUser;
    }
    private HashSet<userImport.model.LoyaltyMember> getLoyaltyMembersFixture() {
        HashSet<userImport.model.LoyaltyMember> loyaltyMembers = new HashSet<userImport.model.LoyaltyMember>();
        userImport.model.LoyaltyMember loyaltyMember = new userImport.model.LoyaltyMember();
        loyaltyMember.setExternalId("DW00000064");
        loyaltyMember.setBalance(new BigDecimal(2.00).setScale(2));
        loyaltyMember.setPoints(new BigDecimal(2.00).setScale(2));
        loyaltyMember.setExported(true);
        loyaltyMembers.add(loyaltyMember);
        return loyaltyMembers;
    }

}