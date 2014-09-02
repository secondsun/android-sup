package sup.aerogear.jboss.org.sup.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Pair;

import org.jboss.aerogear.android.impl.authz.AuthzConfig;
import org.jboss.aerogear.android.impl.authz.oauth2.OAuth2AuthzModule;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import sup.aerogear.jboss.org.sup.util.Constants;

/**
 * Created by summers on 8/29/14.
 */
public class CreateAccountFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AuthzConfig authzConfig = null;
        try {
            authzConfig = new AuthzConfig(new URL(Constants.AUTHZ_URL), "restMod");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        authzConfig.setAuthzEndpoint(Constants.AUTHZ_ENDPOINT);
        authzConfig.setAccessTokenEndpoint(Constants.AUTHZ_TOKEN_ENDPOINT);
        authzConfig.setAccountId(Constants.AUTHZ_ACCOUNT_ID);
        authzConfig.setClientId(Constants.AUTHZ_CLIENT_ID);
        authzConfig.setClientSecret(Constants.AUTHZ_CLIENT_SECRET);
        authzConfig.setRedirectURL(Constants.AUTHZ_REDIRECT_URL);

        //The offline access type causes google's APIs to provide a refresh token
        authzConfig.getAdditionalAuthorizationParams().add(Pair.create("access_type", "offline"));

        //approval_prompt will cause Google's services to re-request authorization if the scopes change
        authzConfig.getAdditionalAuthorizationParams().add(Pair.create("approval_prompt", "force"));
        authzConfig.setScopes(new ArrayList<String>() {{
            add("https://www.googleapis.com/auth/drive");
        }});

        final OAuth2AuthzModule module = new Authorizer().authz(authzConfig);

    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
