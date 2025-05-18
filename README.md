# 🚂 Railway Reservation System

<div align="center">

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)
![Version](https://img.shields.io/badge/Version-1.0.0-blue.svg?style=for-the-badge)

A modern console-based Railway Reservation System built with Java, implementing Object-Oriented Programming principles and file-based persistence.

[Features](#-features) • [Installation](#-installation) • [Usage](#-usage) • [Architecture](#-architecture) • [Contributing](#-contributing) • [License](#-license)

</div>

## ✨ Features

- **Ticket Management**
  - Book train tickets with detailed passenger information
  - Cancel existing bookings
  - View all booked tickets
  - Unique ticket ID generation

- **Train Information**
  - Multiple train routes
  - Real-time seat availability tracking
  - Detailed train information display

- **User Experience**
  - Intuitive console interface
  - Input validation
  - Clear error messages
  - Formatted output display

- **Data Persistence**
  - File-based storage using CSV format
  - Automatic data backup
  - Efficient data retrieval

## 🚀 Installation

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Git (for cloning the repository)

### Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/nilansh-07/railway-reservation-system.git
   cd railway-reservation-system
   ```

2. Compile the source code:
   ```bash
   cd src
   javac *.java
   ```

3. Run the application:
   ```bash
   java Main
   ```

## 💻 Usage

### Booking a Ticket

1. Select option 1 from the main menu
2. View available trains and their details
3. Enter passenger information:
   - Passenger name
   - Candidate name (if different)
   - Age
   - Gender
4. Select train number
5. Confirm booking

### Canceling a Ticket

1. Select option 2 from the main menu
2. Enter passenger name
3. Enter train number
4. Confirm cancellation

### Viewing Tickets

1. Select option 3 from the main menu
2. View all booked tickets with details:
   - Ticket ID
   - Passenger information
   - Train details
   - Route information

## 🏗️ Architecture

### Project Structure

```
src/
├── Main.java           # Application entry point and UI
├── User.java          # User entity class
├── Train.java         # Train entity class
├── Ticket.java        # Ticket entity class
└── BookingSystem.java # Business logic and data management
```

### Class Design

- **User Class**
  - Manages passenger information
  - Handles user data validation
  - Supports CSV serialization

- **Train Class**
  - Manages train details
  - Tracks seat availability
  - Handles booking operations

- **Ticket Class**
  - Combines user and train information
  - Generates unique ticket IDs
  - Manages ticket data persistence

- **BookingSystem Class**
  - Core business logic
  - File I/O operations
  - Data management

## 🤝 Contributing

We welcome contributions! Please follow these steps:

1. Fork the repository
2. Create a feature branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m 'Add some feature'
   ```
4. Push to the branch:
   ```bash
   git push origin feature/your-feature-name
   ```
5. Open a Pull Request

### Development Guidelines

- Follow Java coding conventions
- Add comments for complex logic
- Write clear commit messages
- Update documentation as needed
- Test your changes thoroughly

### Future Enhancements

- [ ] Add GUI using JavaFX
- [ ] Implement database storage
- [ ] Add user authentication
- [ ] Support multiple languages
- [ ] Add payment integration
- [ ] Implement seat selection
- [ ] Add booking history
- [ ] Support ticket modification

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👥 Authors

- Your Name - Initial work - [YourGitHub](https://github.com/nilansh-07)

## 🙏 Acknowledgments

- Thanks to all contributors
- Inspired by real-world railway systems
- Built with Java best practices

---

<div align="center">
Made with ❤️ by Nilansh
</div> 
