# 🚀 JMS (Java Message Service)

This repository demonstrates a simple **Java Message Service (JMS)** application using two independent projects:

- **JMS-First-Client**: Acts as the message **producer** (sends messages to a queue or a topic).
- **JMS-Second-Client**: Acts as the message **consumer** (receives messages from a queue or a topic).

Both projects use **Jakarta JMS**, **JNDI**, and run on the **Payara Embedded Server**.

---

## 📽️ Demo Video
[![Java EAR Project Demo](https://github.com/chamikathereal/JMS/blob/main/JMS.png)](https://youtu.be/04cRmt_z5i4)

---

## 📦 Projects Overview

### 1. JMS-First-Client (Producer)
Sends messages to:
- A **queue** via `QueueSender.java`
- A **topic** via `TopicSender.java`

#### Project Structure
```

JMS-First-Client
├── src/
│   └── main/
│       └── java/
│           └── lk.jiat.ee.client/
│               ├── QueueSender.java
│               └── TopicSender.java
├── pom.xml

```

---

### 2. JMS-Second-Client (Consumer)
Receives messages from:
- A **queue** via `QueueReceiver.java`
- A **topic** via `TopicReceiver.java`

#### Project Structure
```

JMS-Second-Client
├── src/
│   └── main/
│       └── java/
│           └── lk.jiat.ee.client/
│               ├── QueueReceiver.java
│               └── TopicReceiver.java
├── pom.xml

````

---

## 🚀 Technologies Used

- **Java 11**
- **Jakarta JMS (jakarta.jms)**
- **JNDI (Java Naming and Directory Interface)**
- **Payara Embedded Server 6.2025.4**
- **Maven**

---

## 🛠️ How to Run

### 🔹 Prerequisites
- JDK 11 installed
- Maven installed
- Payara resources (Queue/Topic and connection factories) already configured:
  - `jms/MyQueueConnectionFactory`
  - `jms/MyQueue`
  - `jms/MyConnectionFactory`
  - `jms/MyTopic`

### 🔹 1. Start JMS Receiver
Open terminal in `JMS-Second-Client` and run:

```bash
mvn clean compile exec:java -Dexec.mainClass="lk.jiat.ee.client.QueueReceiver"
# Or for topic
mvn clean compile exec:java -Dexec.mainClass="lk.jiat.ee.client.TopicReceiver"
````

### 🔹 2. Send Messages via Producer

Open terminal in `JMS-First-Client` and run:

```bash
mvn clean compile exec:java -Dexec.mainClass="lk.jiat.ee.client.QueueSender"
# Or for topic
mvn clean compile exec:java -Dexec.mainClass="lk.jiat.ee.client.TopicSender"
```

You should see messages being printed in the receiver terminal.

---

## 🧪 Message Flow Summary

| Producer (First Client) | Consumer (Second Client)     |
| ----------------------- | ---------------------------- |
| QueueSender → MyQueue   | ← QueueReceiver              |
| TopicSender → MyTopic   | ← TopicReceiver (subscriber) |

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---

## 🤝 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

## 🧑‍💻 Author

**Chamika Gayashan**  
Undergraduate Software Engineer | Sri Lanka  
Linkedin: [@chamikathereal](https://www.linkedin.com/in/chamikathereal/)



