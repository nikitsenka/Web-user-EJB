package com.webuser.ejb;


import com.webuser.model.LoyaltyMember;
import com.webuser.model.WebUser;

import javax.ejb.Stateless;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;

@Stateless
public class WebUserManagerBean implements WebUserManager {
    private static int requests=0;
    @Override
    public WebUser getSingleWebUserByEmailAddressAndStoreId(String emailAddress, int storeId) {
        System.out.println("*** get user ***");
        requests++;
        if (requests % 2 == 0) {
            WebUser webUser = new WebUser();
            if(requests % 4 ==0){
                webUser.setLoyaltyMembers(new HashSet(Arrays.asList(new LoyaltyMember())));
                System.out.println("return user with loyalty");
            }else{
                System.out.println("return user without loyalty");
            }
            return webUser;
        }
        System.out.println("return null");
        return null;
    }

    @Override
    public WebUser createWebUser(WebUser user, boolean hashPassword) throws InvalidUsernameFormatException, UsernameNotAvailableException, EmailAddressAlreadyRegisteredException {
        System.out.println("*** create user ***");
        printUser(user);
        return null;
    }

    @Override
    public void updateWebUser(WebUser user) throws InvalidUsernameFormatException, UsernameNotAvailableException, EmailAddressAlreadyRegisteredException {
        System.out.println("*** update user ***");
        printUser(user);
    }

    private void printUser(WebUser user) {
        System.out.println("==========================================================================");
        System.out.print("User[");
        for (Field field : user.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = null;
            try {
                value = field.get(user);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            System.out.print(name+":"+value+", ");
        }
        System.out.println("]");
    }
}
