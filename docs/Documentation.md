## Project Overview 
ZenTank is a custom Aquarium and Terrarium controller based on Raspberry Pi. We wanted to created an affordable controller with as much functionality as possible while allowing the user to customize pretty much anything if they want.
## Requirement Analysis
Look at [Requirements Analysis](Requirements.md) for a detailed requirement analysis regarding our product. 
## Architecture
Look at [Architecture](Architecture.md) for a detailed requirement analysis regarding our product. 
### UML-Diagrams 
#### Class diagram 
![Classdiagram](link_zum_bild)

Description: This diagram shows the class structure and it's relations in the system. This might be subject to changes throughout development and will be updated then.

- [X] Settings:
- Properties:
	- ID: Long
	- name: String
	- address: String
	- capabilities: ``List<Capability>``
	- display: boolean
	- healthCheck: HealthCheck
	- https: boolean
	- interface: String
	- notifications: boolean
	- pprof: boolean
	- prometheus: boolean
	- rpi_pwm_freq: integer
- Methods:
	- CRUDL
- [X] Capability:
- Properties:
	- ID: Long
	- name: String
	- enabled: boolean
- Methods:
	- CRUDL
- [X] Error:
- Properties:
	- ID: Long
	- message: String
	- time: DateTime
	- count: integer
- Methods:
	- CRUDL
- [ ] Admin:
- Properties:
	- ID: Long
- Methods:
	- shutdown()
	- reboot()
	- reload()
	- upgrade()
	- systemInfo() -> cpu_temp, current_time, ip, model, name, uptime, version
	- updateCredentials() -> username, password
- [X] Driver:
- Properties:
	- ID: Long
	- name: String
	- pinMap: PinMap
	- type: String
- Methods:
	- CRUDL
- [X] Outlet (Missing Equipment Relation):
- Properties:
	- ID: Long
	- name: String
	- pin: GPIODigitalOutput
	- reverse: boolean
	- state: boolean
	- driver: Driver
	- equipment: Equipment
- Methods:
	- CRUDL
	- on()
	- off()
	- toggle()
	- getState()
	- reverse()
- [X] Inlet (Missing Equipment Relation (generic Object)):
- Properties:
	- ID: Long
	- name: String
	- pin: GPIODigitalInput
	- reverse: boolean
	- state: boolean
	- driver: Driver
	- equipment: Object
- Methods:
	- CRUDL
	- read()
	- isTriggered()
	- addStateChangeListener()
	- removeStateChangeListener()
- [X] Jack (Missing Equipment Relation (generic Object)):
- Properties:
	- ID: Long
	- name: String
	- pins: ``List<Pin>``
	- reverse: boolean
	- state: bolean
	- driver: Driver
- Methods:
	- CRUDL
	- stop()
	- pulse()
	- fade()
	- rampUp()
	- rampDown()
- [X] Analog InputJack (Missing Equipment Relation (generic Object)):
- Properties:
	- ID: Long
	- name: String
	- pin:
	- state: boolean
	- driver: Driver
- Methods:
	- CRUDL
	- read()
- [ ] Equipment:
- Properties:
	- ID: Long
	- name: String
	- state: boolean
	- outlet: Outlet
- Methods:
	- CRUDL
	- on()
	- off()
	- blink()
	- history()
- [ ] Temperature:
- Properties:
	- ID: Long
	- name: String
	- fahrenheit: boolean
	- alerts: boolean
	- min: integer
	- max: integer
	- heater_threshold: double
	- cooler_threshold: double
	- check_frequency: integer
	- sensor_state: String
	- cooler: Cooler
	- heater: Heater
	- sensor: Sensor
- Methods:
	- CRUDL
	- read()
- [ ] ATO:
- Properties:
	- ID: Long
	- name: String
	- alerts: boolean
	- check_frequency: integer
	- status: String
	- inlet: Inlet
	- pump: Equipment
- Methods:
	- CRUDL
	- history()
- [ ] Lights:
- Properties:
	- ID: Long
	- name: String
	- state: boolean
	- jack: Jack
	- channels: ``List<Channel>``
- Methods:
	- CRUDL
- [ ] Channel:
- Properties:
	- ID: Long
	- name: String
	- color: String
	- manual: boolean
	- min: integer
	- max: integer
	- state: boolean
	- pin: integer
	- value: integer
	- type: String
- Methods:
	- CRUDL
	- read()
	- isTriggered()
	- addStateChangeListener()
	- removeStateChangeListener
- [ ] Waves:
- Properties:
	- ID: Long
	- name: String
	- state: boolean
	- jack: Jack
	- channels: ``List<Channel>``
- Methods:
	- CRUDL
- [ ] Dosing:
- Properties:
	- ID: Long
	- name: String
	- pin: integer
	- jack: Jack
	- regiment: Regiment
- Methods:
	- CRUDL
	- calibrate()
	- history()
- [ ] Regiment
- Properties:
	- ID: Long
	- duration: double
	- state: boolean
	- speed: double
	- timer: Timer
- Methods:
	- CRUDL
- [ ] Misting:
- Properties:
	- ID: Long
	- name: String
	- pin: integer
	- jack: Jack
	- regiment: Regiment
- Methods:
	- CRUDL
	- calibrate()
	- history()
- [ ] PhProbe:
- Properties:
	- ID: Long
	- name: String
	- state: boolean
	- min: double
	- max: double
	- alerts: boolean
	- address: integer
	- check_frequency: integer
	- downer_eq: String
	- upper_eq: String
	- analog_input: AnalogInput
- Methods:
	- CRUDL
	- calibrate()
	- measure()
- [ ] Macro:
- Properties:
	- ID: Long
	- name: String
	- reversible: boolean
	- steps: ``List<Step>``
- Methods:
	- CRUDL
	- reverse()
	- run()
- [ ] Step:
- Properties:
	- ID: Long
	- name: String
	- type: String
	- equipment: Long
	- state: boolean
	- duration: double
- Methods:
	- CRUDL
- [ ] Timer:
- Properties:
	- ID: Long
	- name: String
	- target: ``List<Object>``
	- type: String
	- state: boolean
	- month: String
	- week: String
	- day: String
	- hour: String
	- minute: String
	- second: String
- Methods:
	- CRUDL
- [ ] Camera:
- Properties:
	- ID: Long
	- name: String
	- capture_flags: String
	- state: boolean
	- imageDir: String
	- videoDir: String
- Methods:
	- CRUDL
	- listImages()
	- capture()
	- captureVideo()
#### Activity diagram 
![Activitydiagram](link_zum_bild) 

Description: This diagram visualizes the flow of activities and processes in the system.
#### Sequence diagram 
![Sequencediagram](link_zum_bild) 

Description: This diagram shows interactions between objects in a specified sequence in the system.
## Design 
### UI

#### Branding
1. **Brand Essence**: TankZen embodies the harmony and balance of nature within enclosed ecosystems, promoting tranquility and well-being for aquatic and terrestrial life forms.
2. **Brand Values**:
    - Harmony: Promoting balance and coexistence within ecosystems.
    - Innovation: Leveraging technology to enhance the care and management of enclosed environments.
    - Sustainability: Supporting responsible and eco-friendly practices in aquarium and terrarium maintenance.
    - Community: Fostering a community of enthusiasts passionate about aquatic and terrestrial life.
3. **Brand Personality**:
    - Calm
    - Trustworthy
    - Modern
    - Progressive
    - Inclusive
4. **Color Palette**:
    - Deep blue: Represents the depths of aquatic environments and tranquility.
    - Green: Symbolizes growth, vitality, and connection to nature.
    - Neutral tones: Provides balance and complements the primary colors.
5. **Typography**:
    - Clean and modern fonts for a professional and approachable appearance.
    - Sans-serif fonts for readability and simplicity.
6. **Logo Design**:
    - Incorporate elements such as water droplets, leaves, fish, or geometric shapes to represent the diverse ecosystems supported by TankZen.
    - Use gradients or overlapping colors to evoke depth and dimensionality.
    - Aim for a balanced and symmetrical composition to reflect the harmony and equilibrium promoted by TankZen.

![[japanese-bonsai-tree-logo-free-vector.jpg]]
#### Layout
The Layout of ZenTank should be clean and minimal, it is preferable that it consists of a sidebar menu that it is retractable.
Otherwise we want to use grids as much as possible to clean up confusing sections if there are any.

#### Color scheme
See Color Palette in branding guide.

#### UX

#### Sitemap 
In the following you can see the sitemap planned for ZenTanks UI:

```
- Login
- Dashboard
- Temperature
- Timer
- Lighting
- ATO
- Equipment
- Dosing
- Ph
- Misting
- Waves
- Macro
- Settings
```
### Datenbankdesign 
![ERD](link_zum_bild) 

## Infrastructure & DevOps 
### Infrastructure 
- Platform: Raspberry Pi
- Database: 
	- PostgreSQL for RDB
	- Redis for Caching
- Network: 
	- Load Balancer
	- Webserver
### DevOps
- Continuous Integration (CI): Github Actions 
- Continuous Deployment (CD): Github Actions
- Configurationsmanagement: Terraform 
- Monitoring & Logging: Grafana & Prometheus
- Automated Tests:
	- JUnit
	- Gattling
	- Jest
	- Cypress

## Implementation 
### Technologies 
- **Java 21**: Java is a Object Oriented programming language that is easily cross platform and can be read as simple as english
- **Springboot**: Springboot is a Java framework that allows creating applications easily
- **Typescript**: Typescript is the Object Oriented brother of Javascript and allows static types
- **React**: React is a frontend framework that allows creating UI easily

### Code 
#### Repository
- [Main Repository](https://github.com/TheDevGuyMarc/ZenTank)
#### Code Snippets
```

```

## Test 
### Testplan
### Testfälle 
- Testfall 1: Beschreibung des Testfalls. 
- Testfall 2: Beschreibung des Testfalls. 
- ... 

## Deployment 
### Deployment-Strategy 

### Installation 
#### Raspberry Pi

#### Other Linux Platforms

## Maintenance & Support 
### Bugfixes
If you find any bug please open an Issue on GitHub via the Issue template that we provide. We will analyse the problem then and will work on a fix as soon as possible if necessary.
## Technical Documentation
Look at [Technical Documentation](Technical__Documentation.md) for a detailed technical documentation of ZenTank.
## Sources & References 

### Sources
- 
### References
- 