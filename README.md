# Trek Roulette

---
This is the documentation for the Trek Roulette web application for Enterprise Java, Spring 2023.

### Problem Statement

Star Trek debuted in 1966, and has continued to release new TV episodes across multiple series in the decades since.  With so much content out there to view, many fans will binge-watch an entire series, beginning with the pilot episode and proceeding through in order until the series finale.  Other fans, however, have a more chaotic approach to the oeuvre of Star Trek episodes.

While it is possible to pick "random" episodes from the series one has access to through various streaming services and physical media, it can be overwhelming to make that choice consciously.  Perhaps time is limited, so wasting precious minutes choosing an episode can be the difference between fitting in an episode and needing to do something else.  Perhaps work stress leaves one with a fried brain and little desire to make any decisions, making the prospect of choosing from among dozens or hundreds of episodes a daunting proposition.

Trek Roulette intends to make that random selection process less stressful, requiring minimal human input to select an episode and indicate what media will be used to view the show.
### Project Technologies/Techniques

* **Security/Authentication**
  * TBD
* **Database**
  * MySQL 8.0.22
* **ORM Framework**
  * Hibernate 6.1.7
* **Dependency Management**
  * Maven
* **Web Services consumed using Java**
  * [Star Trek API (STAPI)](https://mvnrepository.com/artifact/com.cezarykluczynski.stapi/stapi-client)
  * REST API (to support STAPI access)
* **CSS**
  * Bootstrap 5
* **Data Validation**
  * Bootstrap Validator
  * Hibernate validation (is this a thing? how does it work?)
* **Logging**
  * Log4J2
* **Hosting**
  * AWS
* **Independent Research Topic/s**
  * Mocking exception tests
  * APIs/plugins to achieve mocking
  * Configuration and concept
* **Unit Testing**
  * JUnit tests to achieve 80%+ code coverage
* **IDE**
  * IntelliJ IDEA

### Design Documents

[User Stories](userStories.md)
[Project Plan](projectPlan.md)
[Application Flow](appFlow.md)
[Screen Design](screenDesign/screenDesign.md)

### TimeLog

[Time Log](timeLog.md) 