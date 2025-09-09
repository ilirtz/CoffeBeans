☕ Coffee Beans Web App

This Java web application allows users to manage and explore premium coffee beans using Jakarta EE 10. It demonstrates the use of JavaServer Faces (JSF), CDI beans, and a Derby database backend. Users can view, add, and simulate ordering coffee beans through a styled user interface.



🚀 Features

✅ View coffee beans from a Derby database
✅ Add new coffee bean entries
✅ Contact page (static content)
✅ Simulated order & payment form
✅ Modern UI with basic CSS styling



🛠 Technologies Used

**Java 17**
**Jakarta EE 10**
**JSF (Jakarta Faces)**
**CDI (`@Named`, `@SessionScoped`)**
**Apache Derby (network mode)**
**GlassFish 7**
**NetBeans 20**
**Maven**


🧪 How to Run

1. Open the project in **NetBeans 20**
2. Make sure **Apache Derby** is running:
   - Go to `Services > Java DB > Start Server`
3. Use this SQL to create the required table:

sql
CREATE TABLE coffeebeans (
  id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  name VARCHAR(50),
  origin VARCHAR(50),
  roast_level VARCHAR(50),
  flavor_notes VARCHAR(100),
  price_per_kg DOUBLE
);


💡 Notes
This project uses session-scoped beans to maintain data state.

order.xhtml simulates ordering — no real payments.

beans.xml enables CDI for @Named beans.

loadBeans() retrieves live data from the Derby database.

📸 Optional Screenshots
Add interface screenshots here if required by your coursework.

👤 Author
Student Name: [Ilir Tzaferai]
Project: CoffeeBeansWebApp
University  / Course / Module: [London Metropolitan / Computer Science / CS5003 Data Structures and Specialist Programming]
Date: May 2025
