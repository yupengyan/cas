package org.apereo.cas.adaptors.radius.authentication;

import org.apereo.cas.authentication.AbstractMultifactorAuthenticationProvider;

/**
 * The authentication provider for yubikey.
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
public class RadiusMultifactorAuthenticationProvider extends AbstractMultifactorAuthenticationProvider {

    private static final long serialVersionUID = 4789727148634156909L;
    
    private final RadiusTokenAuthenticationHandler radiusAuthenticationHandler;

    public RadiusMultifactorAuthenticationProvider(final RadiusTokenAuthenticationHandler radiusAuthenticationHandler) {
        this.radiusAuthenticationHandler = radiusAuthenticationHandler;
    }

    @Override
    protected boolean isAvailable() {
        return this.radiusAuthenticationHandler.canPing();
    }

    @Override
    public String getFriendlyName() {
        return "RADIUS (RSA,WiKID)";
    }
}
