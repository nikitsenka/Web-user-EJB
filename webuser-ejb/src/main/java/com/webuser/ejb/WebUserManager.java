package com.webuser.ejb;




import com.webuser.model.WebUser;

import javax.ejb.Remote;

@Remote
public interface WebUserManager {
    WebUser getSingleWebUserByEmailAddressAndStoreId(String emailAddress, int storeId);
    /**
     * Creates a new web user in the registration system
     * @param user details of the user to create
     * @return the created user object with a populated userkey field
     * @throws InvalidUsernameFormatException if the username is in an invalid format.
    e.g. it contains spaces
     * @throws UsernameNotAvailableException if the username is taken or otherwise
    unavailable
     * @throws EmailAddressAlreadyRegisteredException the email address is already
    registered in the database
     */
    WebUser createWebUser(WebUser user, boolean hashPassword) throws
            InvalidUsernameFormatException, UsernameNotAvailableException,
            EmailAddressAlreadyRegisteredException;
    /**
     * Update web user
     * @param user details of the user to update including UserID
     * @throws InvalidUsernameFormatException if the username is in an invalid format. e.g.
    it contains spaces
     * @throws UsernameNotAvailableException if the username is taken or otherwise
    unavailable
     * @throws EmailAddressAlreadyRegisteredException the email address is already registered
    in the database
     */
    void updateWebUser(WebUser user) throws InvalidUsernameFormatException,
            UsernameNotAvailableException, EmailAddressAlreadyRegisteredException;
}