Test how properties work in Spring Boot.

Spring version 2.7.6 (same as norse-application).

## Profiles that can be used

You’re supposed to use the profiles in `groups.properties`: each group
is a profile.

These are supposed to simulate different prod and dev profiles.

They are “self-contained”, i.e. you don’t have to run the application
with any other Spring profiles.

## Demonstration: properties that work

See the `t` properties (e.g. `application-t-dev-config.properties`).

Run `t-dev` or `t-prod`.

## Demonstration: properties that do not work

See the `fail` properties (e.g. `application-fail-prod.properties`).
