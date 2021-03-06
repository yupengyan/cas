---
layout: default
title: CAS - Web Flow Acceptable Usage Policy
category: Webflow Management
---

{% include variables.html %}

# Custom Acceptable Usage Policy

If you wish to design your own storage mechanism, you may follow the below approach:

```java
package org.apereo.cas.custom;

@Configuration("myUsagePolicyConfiguration")
@EnableConfigurationProperties(CasConfigurationProperties.class)
public class MyUsagePolicyConfiguration {

    @Bean
    public AcceptableUsagePolicyRepository acceptableUsagePolicyRepository() {
      ...
    }

}
```

[See this guide](../configuration/Configuration-Management-Extensions.html) to learn more about how to register configurations into the CAS runtime.
