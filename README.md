E-Commerce Automation Framework
This is a test automation framework for automating the e-commerce platform using Java, Selenium WebDriver, and TestNG. It includes automated flows for login, product filtering, adding items to the cart, and completing a purchase.

Features:
1. Automates login and product navigation.
2. Filters products (e.g., watches by material) and adds them to the cart.
3. Handles cart management and quantity adjustment.
4. Verifies order completion and captures order ID.
   
Technology Stack:
Java, Selenium WebDriver, TestNG, Maven, WebDriverManager.

Setup:
  Prerequisites:
    Java 1.8+
    Maven
    Git
    
Steps to Run:
  Clone the repository:
    git clone https://github.com/JyothsnaChukka/ecommerce-automation.git
  Build the project:
    mvn clean install
  Run the tests:
    mvn test
Project Structure:
  src/main/java/com/automation/pages: Page Object Model classes.
  src/test/java/com/automation/tests: Test cases.
  
Future Enhancements:
  Add cross-browser testing.
  Integrate data-driven testing.
