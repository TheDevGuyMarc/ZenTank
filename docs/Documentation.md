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