Control aspects of session replication for certain CAS features, such as OAuth or OpenID Connect authentication,
Delegated Authentication, etc allowing session and authentication profile data to be kept with the client as a cookie.

{% include {{ version }}/cookie-configuration.md configKey="cas.session-replication.cookie" %}

```properties
# cas.session-replication.auto-configure-cookie-path=true
```
