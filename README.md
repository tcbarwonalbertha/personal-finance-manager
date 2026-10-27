# Personal Finance Manager

A Java project built step-by-step while learning Java programming, problem-solving, and software development fundamentals.

## Project Goal

The goal of this project is to build a Personal Finance Manager application that allows users to:

- Track income
- Track expenses
- Categorize transactions
- Manage budgets
- View financial reports
- Store and retrieve financial data

## Current Features

- Display welcome message
- Display application title
- Accept user input using Scanner
- Store data using variables
- Evaluate income using conditional statements (`if`, `else if`, `else`)
- Organize code using methods
- Use method parameters
- Return values from methods
- Repeat code using a `while` loop
- Control the application using a boolean variable
- Display an interactive finance menu
- Add income
- Add expenses
- View current balance
- Create income and expense transaction objects
- Store multiple transactions using an `ArrayList`
- View transaction history
- Read transaction data using getter methods
- Process stored transactions using an enhanced `for` loop
- Categorize income and expense transactions
- Validate monthly income input
- Validate income amounts
- Validate expense amounts
- Validate menu input
- Reject text when numeric input is required
- Reject zero and negative transaction amounts
- Prevent expenses from exceeding the available balance
- Handle invalid menu choices
- Exit the application through the menu

## Technologies

- Java
- IntelliJ IDEA
- Git
- GitHub

## Learning Progress

### Version 0.1

- Created Java project
- Created Main class
- Printed application title

### Version 0.2

- Learned variables
- Learned Scanner user input
- Learned `if` statements
- Learned `else` statements
- Learned `else if` statements
- Built a simple income evaluation program

### Version 0.3

- Learned methods
- Created reusable methods
- Learned method parameters

### Version 0.4

- Learned methods with return values
- Learned `while` loops
- Practiced the increment operator (`++`)

### Version 0.5

- Learned the `boolean` data type
- Used a boolean variable to control a loop
- Created an interactive menu using a `while` loop
- Accepted menu choices using `scanner.nextInt()`
- Learned the difference between `=` and `==`
- Added an Exit option to stop the menu loop

### Version 0.6

- Made the Add Income option functional
- Made the Add Expense option functional
- Made the View Balance option functional
- Added balance tracking
- Separated income from balance
- Added handling for invalid menu choices
- Added an exit message
- Created a reusable `displayMenu()` method
- Learned more about variable scope
- Practiced using `if`, `else if`, and `else` for menu choices

### Version 0.7

- Created a separate `Transaction` class
- Learned the difference between a class and an object
- Created private fields for transaction amount and type
- Learned how constructors initialize objects
- Learned how `this` refers to the current object
- Created getter methods for private fields
- Created `Transaction` objects using `new`
- Learned about `ArrayList`
- Created an `ArrayList<Transaction>` to store transactions
- Used `.add()` to store transaction objects
- Stored starting income as a transaction
- Stored additional income transactions
- Stored expense transactions
- Learned the enhanced `for` loop
- Used an enhanced `for` loop to process stored transactions
- Added a View Transactions menu option
- Displayed transaction history using getter methods

### Version 0.8

- Added transaction categories
- Added a `category` field to the `Transaction` class
- Updated the `Transaction` constructor to accept a category
- Learned how `this.category = category` stores the constructor parameter in the object
- Created a `getCategory()` getter method
- Added user input for income categories
- Added user input for expense categories
- Stored categories with income and expense transactions
- Displayed categories in transaction history
- Learned how `scanner.nextLine()` clears the leftover Enter after `scanner.nextDouble()`
- Practiced storing and retrieving additional data from objects

### Version 0.9

- Added input validation for monthly income
- Added input validation for income amounts
- Added input validation for expense amounts
- Added menu input validation using `hasNextInt()`
- Prevented text input where numbers are required
- Prevented zero and negative income amounts
- Prevented zero and negative expense amounts
- Prevented expenses from exceeding the available balance
- Learned how `hasNextDouble()` checks whether input is a valid number
- Learned how `hasNextInt()` checks whether input is a valid integer
- Learned how `!` means NOT in a condition
- Learned how `<=` and `>` are used for value validation
- Learned the difference between input-type validation and value validation
- Practiced nested `while` loops for repeated input validation
### Version 1.0

- Learned the basics of Java file handling
- Learned how `FileWriter` writes data to a file
- Learned how `FileReader` reads data from a file
- Learned how `BufferedReader` reads text line by line
- Learned how `IOException` handles file-related errors
- Learned how `try-with-resources` automatically closes files
- Created a `saveTransactions()` method
- Created a `loadTransactions()` method
- Saved income and expense transactions to `transactions.csv`
- Loaded saved transactions when the application starts
- Recreated `Transaction` objects from saved data
- Recalculated income and balance from saved transactions
- Prevented duplicate starting income when loading saved data
- Successfully tested data persistence after restarting the application
## Future Features

- ## Future Features

- Refactor the application using object-oriented programming (OOP)
- Create separate classes for transaction management and file handling
- Improve input validation for transaction categories
- Save transactions automatically after each change
- Add transaction dates and timestamps
- Add the ability to edit and delete transactions
- Build a graphical user interface using JavaFX
- Add budget management and spending limits
- Add financial reports and summaries
- Add charts and data visualization
- Add database storage
- Add CSV and PDF export functionality
- Add user registration and login functionality
- Improve financial calculations and currency formatting
- Add error handling and automated testing
- Package the application as a Windows installer
- Prepare the application for distribution
## Author

Albertha TC Barwon