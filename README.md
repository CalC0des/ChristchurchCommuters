# Christchurch Commuters
A native Android app for people that want to explore Christchurch's Metro system in a responsive, quick and mobile way.<br>
A collaborative project by Callum Whitehead, Harry Ellis, Ezeckiel Mautoatasi, Nathan Briggs
## Getting started
**URLS to generate API keys:**<br>
Metro API key: Sign up for the Metro API and subscribe here - https://apidevelopers.metroinfo.co.nz/<br>
Maps API Key: Follow the steps here to generate a key - https://developers.google.com/maps/documentation/routes/cloud-setup<br>

**In local.properties insert the following**<br>
```
METRO_API_KEY=***INSERT YOUR KEY HERE***<br>
METRO_API_URL="https://apis.metroinfo.co.nz/rti/gtfsrt/v1/trip-updates.pb"<br>
MAPS_API_KEY=***INSERT YOUR KEY HERE***<br>
ROUTES_API_URL="https://routes.googleapis.com/directions/v2:computeRoutes"
```
