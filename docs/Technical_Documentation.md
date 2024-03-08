# Technical Documentation

This is an detailed technical documentation of ZenTank's systems, including the API, UI, Electronics, Data Structure and more.

## API Documentation

## UI Documentation

### Dashboard Presets

- Freshwater Aquarium
- Darkwater Aquarium
- Saltwater Aquarium
- Terrarium
- Paludarium
- Vivarium
- Insectarium
- Ecosphere

## Electronics

### Definitions

- Sensor: Retrieve Data from tanks
- Actuator: Controls AC / DC hardware devices like pumps (relays)
- GPIO: General Purpose IO Pins (40 pieces) on Raspberry PI
- I2C: Multi Master & Multi Slave Protocol
- SPI: Synchronous Communication protocol with Master Slave
- UART: Universal Asynchronous Receiver-Transmitter protocol
- DB9: Specific type of cable that allows communication over UART protocol
- Ethernet: Network communication over TCP/IP or UDP
- USB: Communication over USB to serial converter possible (UART, RS-232, RS-485)

### Sensor Types relevant for TankZen

- Temperature
- PH
- Water Level
- Light
- Humidity
- Motion
- Water Quality
- Salinity
- Dissolved Oxygen
- Total Dissolved Solids (TDS)
- Ammonia
- Waterflow
- Algae Growth

### Hardware Types relevant for TankZen (Controlled with Actuators)

- Pump
- Heater
- Cooler
- LED Lights
- Lights
- Automatic Feeder
- CO² Injector / Injector Valves
- Filter
- Misting System
- Dosing Pump
- Automatic Water Testing
- Water Change
- UV Sterilizer
- Ozone Generator
- Top-Off System
- Camera

### Hardware Planning

#### Technical Decisions

As base we want to use the any Raspberry Pi or other SBC that has 40 Pins as GPIO and has the same mapping as the Raspberry Pi 4. In Addition to that one could add their own mapping via creating a device in ZenTank as long as it doesn't deviate from some fixed GPIO pins like I2C or others.

Because the GPIO pins are somewhat limited in a sense that there are only certain amount of pins for I2C, UART and PWM we use some additional boards that might or might not be integrated later in the final ZenTank Pi HAT. If you want to see the additional boards we have chosen for now look in the [components](#components) section, there you can also find the pin outs needed for those boards and components. The question if we integrate those external boards as internal circuits is currently not clear because this is mainly a viability question in terms of: "Why reinventing the wheel if there is a component that is tested and working out there and we can just add it as addition to the board?".

If you want to see how we wired up certain components you can look this up in our [wiring](#wiring) section below.

#### Components

##### GPIO Pin Out

![[GPIO-Pinout-Diagram-2.png]]

##### DB9 Pin Out

![[s-l1600.jpg]]

##### RJ45 Pin Out

![[sermrv.png]]

##### [TCA9548A - I2C Multiplexer](https://www.amazon.de/DollaTek-TCA9548A-Multiplexer-Breakout-Erweiterungsplatine/dp/B07DK63GMK/ref=sr_1_1?adgrpid=72510435538&dib=eyJ2IjoiMSJ9.a7_Bzif3N_tMENbqiCURu9o6Fit7XrrGblvk8OtoPzx8RYIcWep2rCxzUO6AM6YxX_SpjUz3KrrNvtGiAZSApGMfMJGBsfsCv5BRQf1lp0bRfAAzWmE3Fc5S21U3kMpc4_EABeRghRvtMkkImOWGmRpVwgNrHbN7Un5VftpUwCi-wbuFowd76zUMJmt1gOq21zsExbU_n6O8CRLcwlek1oXIGKuNwLsfdFAWjV4aIdI.xoWglJ4ZIOU7KW_cs0gkFA7Ff4C2kA5nO0ZIyYGeSWQ&dib_tag=se&hvadid=391551384604&hvdev=c&hvlocphy=9044703&hvnetw=g&hvqmt=e&hvrand=13550488112241265467&hvtargid=kwd-326513435004&hydadcr=29221_1989447&keywords=tca9548a&qid=1708957929&sr=8-1)

![[61850c4YrHL._AC_SL1000_.jpg]]

##### [PCA9685 - 16 Channel PWM Driver](https://www.az-delivery.de/en/products/pca9685-servotreiber?gad_source=1&gclid=CjwKCAiAivGuBhBEEiwAWiFmYfD8Oc6e0kqdo6CXPEIiSTjrfykOO-gxHC2yXLg8mUVZMdUM3FgdKRoCBpMQAvD_BwE&utm_campaign=16964979024&utm_content=136656817158&utm_medium=cpc&utm_source=google&utm_term=&variant=40364395410)

![[pca9685-16-kanal-12-bit-pwm-servotreiber-fur-raspberry-pi-359254.webp]]

##### [SC16IS752/762 - I2C/SPI MCU](https://www.amazon.de/Youmile-Busschnittstelle-Zweikanal-UART-Konvertierungsmodul-Erweiterungsplatine-Stiftleiste-DuPont-Kabel/dp/B09HGRVYM6)

![[61hGYh7GBWL._SL1200_.jpg]]

#### Wiring

- **Base**: 40 Pin header to connect Raspberry Pi (Compatible with Raspberry Pi Zero W, Zero 2, Pi 3, Pi 4)
- **Feeder Plug**:
  - Type: 3 Pin Molex Female
  - Pin Out:
    - Pin 1: 3.3v Power
    - Pin 2: Ground
    - Pin 3: GPIO 0
- **I2C Plug**:
  - Type: 4 Pin Molex Female
  - Pin Out:
    - Pin 1: 5V Power
    - Pin 2: TCA9548A SD 2
    - Pin 3: TCA9548A SC 2
    - Pin 4: Ground
- **Temperature Sensor Plugs (DS18B20)**:
  - Type: 3 Pin Screw/Plug Terminal
  - Pin Out:
    - Plug 1:
      - Pin 1: 5V Power
      - Pin 2: GPIO 5 (Data)
      - Pin 3: Ground
    - Plug 2:
      - Pin 1: 5V Power
      - Pin 2: GPIO 6 (Data)
      - Pin 3: Ground
- **pH Sensor Plug**:
  - Type: 3 Pin Barrel Jack (screwable)
  - Pin Out:
    - Pin 1:
    - Pin 2:
    - Pin 3:
- **12v-24v DC Power Input Plug:**
  - Type: DC Barrel Jack
  - Pin Out
  -

- **Extensions**:
  - Boards:
    - TCA9548A:
      - Type:
      - Pin Out:
        - GPIO 2 (SDA) to SDA
        - GPIO 3 (SCL) to SCL
        - Ground to GND
        - 5V to VIN
        - GPIO 17 to A0
        - GPIO 27 to A1
        - GPIO 22 to A2
    - PCA9685:
      - Type:
      - Pin Out RJ45 PWM 1:
        - TCA9548A Ground to GND
        - TCA9548A 5V to VCC
        - TCA9548A SD0 to SDA
        - TCA9548A SC0 to SCL
      - Pin Out RJ45 PWM 2:
        - TCA9548A Ground to GND
        - TCA9548A 5V to VCC
        - TCA9548A SD1 to SDA
        - TCA9548A SC1 to SCL
    - SC16IS752/762:
      - Type:
      - Pin Out:
        - TCA9548A Ground to GND
        - TCA9548A  5V to VCC
        - TCA9548A SD3 to SDA
        - TCA9548A SC3 to SCL
  - DB9:
    - A:
      - Type:
      - Pin Out:
    - B:
      - Type:
      - Pin Out:
  - RJ45 Data:
    - Type:
    - Pin Out:
      - Pin 1: 5V
      - Pin 2: Ground
      - Pin 3: GPIO 8
      - Pin 4: GPIO 7
      - Pin 5: GPIO 1
      - Pin 6: GPIO 12
      - Pin 7: GPIO 20
      - Pin 8: GPIO 21
  - RJ45 PWM:
    - PWM 1:
      - Type:
      - Pin Out:
        - Pin 1: PCA9685 1
        - Pin 2: PCA9685 2
        - Pin 3: PCA9685 3
        - Pin 4: PCA9685 4
        - Pin 5: PCA9685 5
        - Pin 6: PCA9685 6
        - Pin 7: PCA9685 6 - V+
        - Pin 8: PCA9685 6 - GND
    - PWM 2:
      - Type:
      - Pin Out:
        - Pin 1: PCA9685 8
        - Pin 2: PCA9685 9
        - Pin 3: PCA9685 10
        - Pin 4: PCA9685 11
        - Pin 5: PCA9685 12
        - Pin 6: PCA9685 13
        - Pin 7: PCA9685 13 - V+
        - Pin 8: PCA9685 13 - GND

## Data Structure

## Architecture Overview

The whole project is developed in a Domain Driven Design (DDD) which allows us to better modularize code packets that really belong together. Besides that we are using a REST API architecture with a changeable UI, meaning that we deliver our data via the REST protocol in a stateless fashion and the UI can be changed by the user. We certainly provide a react UI but if the user might want to use something else or customize his UI he can certainly do so, so we are kinda in the headless realm here also. If you look at the file structure you will notice that the API and the UI are looking pretty much identical with some minor deviations, that is because we are mirroring the structure of the API to the UI.

## External Dependencies

**Backend**:

- Springboot
- Springboot Web
- Springboot Data JPA
- Springboot Data Redis
- PostgreSQL
- Springboot Validation
- Springboot Security
- Springboot Actuator
- Springboot Devtools
- Springboot Mail
- Springboot RestDocs
- Spring Doc OpenAPI Starter WebMVC UI
- Lombok
- Prometheus
- Pi4J Core
- Pi4J Devices
- Usb4Java
- Springboot Test
- Gatling Core
- Gatling HTTP

**UI**:

- Dependencies:
  - Axios
  - Bootstrap
  - i18next
  - i18next-browser-languagedetector
  - react
  - react-beautiful-dnd
  - react-bootstrap
  - react-dom
  - react-i18next
  - react-router-dom
  - react-scripts
  - reactflow
  - recharts
  - styled-components
- DevDependencies:
  - @types/jest
  - @types/node
  - @types/react
  - @types/react-bootstrap
  - @types/react-dom
  - node-sass
  - typescript

## Version Control

Because we are writing code here, version control is super important. We are using Git because we are familiar with it and our repository is hosted on GitHub. In addition to that we are using Git-flow as branching method, which allows us to differentiate between code features.

## Developer Guides

### Setting Up the Development Environment

### Cloning the Repository
