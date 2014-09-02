package sup.aerogear.jboss.org.sup.util;

/**
 * Created by summers on 8/26/14.
 */
public final class Constants {
    public static final String AUTHZ_URL = "https://auth-coffeeregister.rhcloud.com";
    public static final String AUTHZ_ENDPOINT = "";
    public static final String AUTHZ_TOKEN_ENDPOINT = "/auth/realms/sup/tokens/access/codes";
    public static final String AUTHZ_ACCOUNT_ID = "Android";
    public static final String AUTHZ_CLIENT_ID = "sup_server";
    public static final String AUTHZ_CLIENT_SECRET = "";
    public static final String AUTHZ_REDIRECT_URL = "urn:ietf:wg:oauth:2.0:oob";

    private Constants(){}

    public static final String SUP_ACCOUNT_TYPE = "org.jboss.aerogear.sup";
    public static final String AUTH_TOKEN_TYPE = "org.jboss.aerogear.sup.AUTH_TOKEN_TYPE";

}
