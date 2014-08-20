package userImport.parser;

import org.junit.Before;
import org.junit.Test;
import userImport.model.LoyaltyMember;
import userImport.model.Parameter;
import userImport.model.WebUser;
import userImport.parser.jaxbParser.WebUserXmlParser;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static userImport.Utils.getDate;

public class webUserXmlParserTest {
    WebUserParser webUserParser;

    @Before
    public void setUp() throws Exception {
        File inputXml = new File(this.getClass().getResource("/userdata.xml").toURI().getPath());
        webUserParser = new WebUserXmlParser(inputXml);

    }

    @Test
    public void testGetAll() throws Exception {

        List<WebUser> results = webUserParser.getAll();
        assertThat(results.size(),is(1));
        WebUser webUser = results.get(0);
        assertThat(webUser.getStoreId(),is(1));
        assertThat(webUser.getImportedUserId(),is("64"));
        assertThat(webUser.getFirstName(),is("SHAUN"));
        assertThat(webUser.getLastName(),is("PEYMAN"));
        assertThat(webUser.getEmailAddress(),is("shaun@ifgdfgdfg.co.nz"));
        assertThat(webUser.getOtherPhoneNumber(),is(""));
        assertThat(webUser.getMobileNumber(),is("02116859"));
        assertThat(webUser.getPassword(),is("xxx"));
        assertThat(webUser.getStreetAddress(),is("3 FOSTER CRES"));
        assertThat(webUser.getSuburb(),is("SNELLS BEACH"));
        assertThat(webUser.getCity(),is("Sydney"));
        assertThat(webUser.getCountryCode(),is("NZ"));
        assertThat(webUser.getPostCode(),is("1052"));
        assertThat(webUser.getStaffId(),is(""));
        LoyaltyMember loyaltyMember = webUser.getFirstLoyaltyMember();
        assertThat(loyaltyMember.getExternalId(), is("DW00000064"));
        assertThat(loyaltyMember.getBalance(), is(new BigDecimal(2.00).setScale(2)));
        assertThat(loyaltyMember.getPoints(), is(new BigDecimal(2.00).setScale(2)));
        assertThat(loyaltyMember.isExported(),is(true));
        assertThat(webUser.getLastLoginDate(),is(getDate("2008-12-15 18:51:25")));
        assertThat(webUser.getDateCreated(),is(getDate("2008-12-15 18:51:25")));
        assertThat(webUser.getExpressCheckoutEnabled(),is(true));
        assertThat(webUser.getDiscountPercentage(),is(new Float(2)));
        List<Parameter> parameters = webUser.getParameters();
        assertThat(parameters.size(),is(6));
        assertThat(parameters.get(0).getName(),is("EMAIL_SUB_WEEKLY_SPECIALS"));
        assertThat(parameters.get(0).getValue(),is("Y"));
    }


/*
    <DateCreated>2008-12-15 18:51:25</DateCreated >
    <LastLoginDate>2008-12-15 18:51:25</LastLoginDate>
    <LoyaltyMember>
    <ExternalId>DW00000064</ExternalId>
    <Balance>2.00</Balance>
    <Points>2.00</Points>
    </LoyaltyMember>
    <Parameters>
    <Parameter>
    <Name>EMAIL_SUB_WEEKLY_SPECIALS</Name>
    <Value>Y</Value>
    </Parameter>
    <Parameter>
    <Name> EMAIL_SUB_STORE_INFO </Name>
    <Value>Y</Value>
    </Parameter>
    <Parameter>
    <Name>EMAIL_SUB_INTEREST_SNOW</Name>
    <Value>Y</Value>
    </Parameter>
    <Parameter>
    <Name> EMAIL_SUB_INTEREST_BIKE </Name>
    <Value>Y</Value>
    </Parameter>
    <Parameter>
    <Name> EMAIL_SUB_INTEREST_WATER</Name>
    <Value>Y</Value>
    </Parameter>
    <Parameter>
    <Name> EMAIL_SUB_INTEREST_OUTDOOR</Name>
    <Value>Y</Value>
    </Parameter>
    </Parameters>
    </WebUser>*/

}