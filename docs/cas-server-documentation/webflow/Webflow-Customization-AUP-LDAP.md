---
layout: default
title: CAS - Web Flow Acceptable Usage Policy
category: Webflow Management
---

{% include variables.html %}

# LDAP Acceptable Usage Policy

Alternatively, CAS can be configured to use LDAP as the storage mechanism. Upon
accepting the policy, the result will be stored back into LDAP and remembered
via the same attribute. Support is enabled by including the following dependency in the WAR overlay:

{% include casmodule.html group="org.apereo.cas" module="cas-server-support-aup-ldap" %}

{% include {{ version }}/ldap-configuration.md configKey="cas.acceptable-usage-policy.ldap[0]" %}
