### User Requirements 
- [ ] Anforderungs-ID: 1
	- Title: Login
	- Description: A user should be able to login with predefined user credentials
	- Priority: low
	- Category: Authentication
	- Acceptance-Criteria:
		1. The application should generated credentials on first start
		2. The user should be able to login and be redirected to dashboard
		3. The user should see a login form
		4. A Login endpoint needs to be implemented
- [ ] Anforderungs-ID: 2
	- Title: Logout
	- Description: A user should be able to logout of the ZenTank application
	- Priority: low
	- Category: Authentication
	- Acceptance-Criteria:
		1. The user should be able to logout via click on the logout button
		2. A Logout endpoint needs to be implemented
- [ ] Anforderungs-ID: 3
	- Title: Credential Change
	- Description: The user should be able to change the generated password for better security
	- Priority: low
	- Category: Authentication
	- Acceptance-Criteria:
		1. The user should be able to change the password with a new self defined password
		2. The application should help the user with tips for secure passwords
		3. A password-change endpoint needs to be implemented
		4. The user should have a password change form in the settings section
- [ ] Anforderungs-ID: 4
	- Title: Password Forgotten
	- Description: If a user can't login he should be able to reset his password to gain access again
	- Priority: low
	- Category: Authentication
	- Acceptance-Criteria:
		1. The user should be able to reset his password with an email address
		2. The application should send the user a validation email
		3. The user should have a password reset form linked to the login form
		4. A password reset endpoint needs to be implemented
- [ ] Anforderungs-ID: 5
	- Title: A user should be able to automate temperature regulation
	- Description: The user should be able to create a task that automates temperature regulation for optimal water temperature
	- Priority: middle
	- Category: Temperature Control
	- Acceptance-Criteria:
		1. The user should be able to monitor temperatures as a chart in the dashboard
		2. The user should be able to be alerted with temperatures out of a defined range
		3. The user should be able to let a heater or cooler be triggered on temperature readings
		4. Temperature readings should be taken every 5 seconds
- [ ] Anforderungs-ID: 6
	- Title: A user should be able to automate lighting
	- Description: The user should be able to create a task that automates lighting
	- Priority: middle
	- Category: Light Control
	- Acceptance-Criteria:
		1. The user should be able to automate light dimming or on/off state toggling on defined times
		2. The user should be able to automate light intensity and spectrum for different tank requirements
		3. The user should be alerted when the lights won't shut off
		4. Light readings should be taken every 5 seconds
- [ ] Anforderungs-ID: 7
	- Title: A user should be able to automate lighting simulations
	- Description: The user should be able to simulate day-night cycles
	- Priority: middle
	- Category: Light Control
	- Acceptance-Criteria:
		1. The user should be able to simulate a day night cycle with variable light intensity and color
		2. The user should be able to simulate certain weather conditions through light for a more realistic ecosystem
- [ ] Anforderungs-ID: 8
	- Title: pH measurement
	- Description: It should be possible to measure the current pH value in the water
	- Priority: middle
	- Category: PH
	- Acceptance-Criteria:
		1. The user should be able to measure pH in an automated fashion every 5 seconds
		2. The user should be able to see the pH values as a chart on the dashboard
		3. The user should be able to automatically trigger dosing of pH altering chemicals on certain pH values
- [ ] Anforderungs-ID: 9
	- Title: Salinity Measurement
	- Description: It should be possible to measure salinity of water through conductivity measurement
	- Priority: middle
	- Category: Salinity
	- Acceptance-Criteria:
		1. The user should be able to measure salinity in an automated fashion every 5 seconds
		2. The user should be able to see the salinity values as a chart on the dashboard
		3. The user should be able to automatically trigger dosing of salinity altering chemicals on certain salinity values
- [ ] Anforderungs-ID: 10
	- Title: Water Level
	- Description: It should be possible to alter water level automatically
	- Priority: middle
	- Category: ATO
	- Acceptance-Criteria:
		1. The user should be able to automatically measure the water level in the tank
		2. The user should be able to automatically top of the water in the tank if the level is deviating from the standard value
		3. The user should be able to automatically do water changes on a defined schedule
		4. The user should be able to automatically measure the water level in the sump tank if he chooses to do so
- [ ] Anforderungs-ID: 11
	- Title: Water Flow Management
	- Description: It should be able to control water flow
	- Priority: middle
	- Category: Waves
	- Acceptance-Criteria:
		1. The user should be able to automate water circulation
		2. The user should be able to create water movement patterns
		3. The user should be able to adjust flow rates to mimic natural environments
		4. The user should be able to measure water flow
		5. The user should be able to see water flow in a chart on the dashboard
- [ ] Anforderungs-ID: 12
	- Title:Dosing Pump Control
	- Description: It should possible to control dosing pumps automatically
	- Priority: middle
	- Category: Dosing
	- Acceptance-Criteria:
		1. The user should be able to dose supplements, trace elements and additives precisely in the water, automated
		2. The user should be able to schedule dosing based on water parameters
		3. The user should be able to schedule dosing based on user defined settings
		4. The user should be able to see the fluid level left of the dosing bottles in a chart on the dashboard
		5. The user should be able to see the dosing intervals and if they were done correctly in a chart on the dashboard
- [ ] Anforderungs-ID:  13
	- Title: Auto Feeding
	- Description: It should be possible to automatically feed animals
	- Priority: middle
	- Category: Feeding
	- Acceptance-Criteria:
		1. The user should be able to feed all Aquarium and Terrarium animals at scheduled intervals automatically
		2. The user should be able to adjust feeding amounts and frequencies to prevent overfeeding
		3. The user should be able to select predefined feeding modes if he is not sure about how he should configure feeding
- [ ] Anforderungs-ID: 14
	- Title: Timing & Scheduling
	- Description: It should be possible to time certain features in ZenTank
	- Priority: High
	- Category: Timing
	- Acceptance-Criteria:
		1. The user should be able to set up timers for certain aquarium tasks and events (CRUDL)
		2. The user should be able to configure timers via CRON pattern
		3. The user should be able to configure timers via Timer pattern
		4. The user should be able to attach timers to tasks
- [ ] Anforderungs-ID: 15
	- Title: Macros & Task-chains
	- Description: It should be possible to create macros that describe task-chains
	- Priority: middle
	- Category: Macros
	- Acceptance-Criteria:
		1. The user should be able to create macros (CRUDL)
		2. The user should be able to to set up macro chains that automate full processes like water changes
		3. The user should be able to select from predefined macros to make his life easier
- [ ] Anforderungs-ID: 16
	- Title: Dashboarding
	- Description: It should be possible to dashboard all the data
	- Priority: middle
	- Category: Dashboard
	- Acceptance-Criteria:
		1. The user should be able to create his own dashboard from dashboard components
		2. The user should be able to drag&drop dashboard components on the dashboard
		3. The user should be able to edit his dashboard at anytime
		4. The user should be able to choose from the charts components to show how his data is displayed
		5. The user should be able to choose from predefined templates
- [ ] Anforderungs-ID: 17
	- Title: Customization
	- Description: It should be possible to customize ZenTank
	- Priority: middle
	- Category: Customization
	- Acceptance-Criteria:
		1. The user should be able to add (CRUDL) additional Drivers to the predefined ones if he wants (Raspberry Pi and ZenTank are predefined)
		2. The user should be able to add (CRUDL) additional Inlets, Outlets, Analog-Inputs and Jacks if he wants
		3. The user should be able to integrate third party hardware or DIY projects if he wants
		4. The user should be able to change the color theme of his UI
		5. The user should be able to change the URL and name of ZenTank
- [ ] Anforderungs-ID: 18
	- Title: Alerting
	- Description: It should be possible to get alerts if needed
	- Priority: middle
	- Category: Alerts
	- Acceptance-Criteria:
		1. The user should be able to configure alerts via Email in ZenTank
		2. The user should be able to configure alerts via SMS in ZenTank
		3. The user should be able to set up alerts (CRUDL)
		4. The user should be able to attach alters to tasks
- [ ] Anforderungs-ID: 19
	- Title: Internationalization
	- Description: It should be possible to use ZenTank in different languages
	- Priority: high
	- Category: Internationalization
	- Acceptance-Criteria:
		1. The user should be able to use ZenTank in German
		2. The user should be able to use ZenTank in English
		3. The user should be able to use ZenTank in Chinese
		4. The user should be able to use ZenTank in Japanese
		5. The user should be able to use ZenTank in Spanish
		6. The internationalization module should be customizable and easily expanded for more languages (i18next)
- [ ] Anforderungs-ID: 20
	- Title: Remote Access
	- Description: It should be possible to use ZenTank remotely
	- Priority: middle
	- Category: Remote Access
	- Acceptance-Criteria:
		1. The user should be able to access ZenTank from any device with a web browser (only home network)
		3. The user should be able to access ZenTank from any device with a [VNC](https://reef-pi.github.io/additional-documentation/remote/) client (remote)
- [ ] Anforderungs-ID: 21
	- Title: Logging & Monitoring
	- Description: It should be possible to do logging and monitoring
	- Priority: middle
	- Category: Logging & Monitoring
	- Acceptance-Criteria:
		1. The user should be able to see application logs to see if he ran into an issue
		2. The user should be able to monitor the applications health via Grafana and Prometheus
- [ ] Anforderungs-ID: 22
	- Title: Cameras
	- Description: It should be possible to integrate cameras
	- Priority: middle
	- Category: Camera
	- Acceptance-Criteria:
		1. The user should be able to monitor his tanks via camera over ethernet as live stream in 1080p if he chooses to do so
		2. The user should be able to set up a camera stream component on the dashboard
- [ ] Anforderungs-ID: 23
	- Title: Configuration
	- Description: It should be able to configure ZenTank
	- Priority: middle
	- Category: Configuration
	- Acceptance-Criteria:
		1. The user should be able to configure target water parameters (pH, salinity, temp, etc.)
		2. The user should be able to configure the wlan interface
		3. The user should be able to configure the http-address
		4. The user should be able to configure the Rpi PWM frequency
		5. The user should be able to configure the current language
		6. The user should be able to configure if alerts are active and how they should be handled
		7. The user should be able to configure if profiling should be active
		8. The user should be able to configure if Prometheus is active
		9. The user should be able to configure capabilities so he only uses what he needs:
			1. Equipment
			2. Timers
			3. Lighting
			4. ATO
			5. Temperature
			6. Camera
			7. Doser
			8. pH
			9. Macro
			10. Health Check
			11. Dashboard
			12. DevMode
			13. Alert on Health Check
- [ ] Anforderungs-ID: 24
	- Title: Watchdog
	- Description: It should be possible to restart equipment automatically
	- Priority: middle
	- Category: Watchdog
	- Acceptance-Criteria:
		1. The application should be able to self heal equipment and other hardware if those devices die via a [watchdog](https://medium.com/@arslion/enabling-watchdog-on-raspberry-pi-b7e574dcba6b) application
		2. The application should log if any hardware device fails 

### System Requirements 
- [ ] Anforderungs-ID: 
	- Title:
	- Description:
	- Priority:
	- Category:
	- Acceptance-Criteria:
		1. 
