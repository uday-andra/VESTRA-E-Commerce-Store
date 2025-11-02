<!-- VESTRA Fashions README -->

<h1 align="center">🛍️ VESTRA Fashions</h1>
<h3 align="center">A Real-Time Full Stack E-Commerce Clothing Store</h3>

<p align="center">
  <img src="https://readme-typing-svg.herokuapp.com?font=Fira+Code&size=24&pause=1000&color=00F7FF&center=true&vCenter=true&width=800&lines=Java+Full+Stack+E-Commerce+App;Secure+Online+Clothing+Store;Razorpay+Integrated+Payments;Admin+%26+User+Dashboards;Real-Time+Order+Tracking" alt="Typing Animation"/>
</p>

---

## 📖 Overview

**VESTRA Fashions** (*“Vestra” means “Your Clothing” in Latin*) is a **real-time e-commerce platform** for online clothing shopping.

It includes a **modern, responsive frontend** with React + TailwindCSS and a **secure backend** powered by Java, Spring Boot, Spring Security, and JWT.

This project demonstrates **real-world production-level functionality**, including:
- User & Admin dashboards
- Razorpay / UPI / COD payment integration
- Live order tracking
- Email invoice generation
- Wallet system
- Secure JWT authentication and authorization

Built with a focus on **scalability, modularity, and data security** — ideal for professional portfolios and hiring showcases.

---

## 🎯 Key Features

### 👗 **User Features**
- Browse products by category — **Mens, Womens, Kids**
- Filter, and view product details
- Add items to **Wishlist** and **Cart**
- **Checkout securely** using Razorpay / UPI / COD
- Receive **order confirmation emails and invoices**
- **Live Order Tracking** after placing an order
- Access **VESTRA Wallet**, **My Orders**, **My Wishlist**, **Notifications**, and **Saved Addresses**
- Manage profile and **securely logout**
- Authentication with **JWT Tokens** and encrypted passwords

---

### 🧩 **Admin Features**
- Full **Admin Dashboard** with control over:
  - 👕 Products (CRUD, categories, variants)
  - 📦 Orders (status, refunds, live tracking)
  - 👥 Users (roles, permissions)
  - 📊 Analytics (revenue, reports, inventory levels)
  - ⚙️ Settings (tax, delivery, payment config)
- Generate **business reports & visual analytics**
- Role-based access management with **Spring Security**
- Complete **inventory and order lifecycle** management

---

## 🧠 Tech Stack

| Category | Technologies Used |
|-----------|------------------|
| **Frontend** | React, TailwindCSS, Bootstrap, JavaScript (ES6), Axios |
| **Backend** | Java, Spring Boot 4, Spring Security, JWT, REST APIs |
| **Database** | MySQL |
| **Payments** | Razorpay, UPI, Cash on Delivery |
| **Email / Notifications** | Spring Mail (SMTP) |
| **Tools** | VS Code, IntelliJ IDEA, Postman, Git/GitHub |
| **Browsers Tested** | Chrome, Edge, Firefox |

---
## 🔐 Authentication & Security

- **JWT (JSON Web Token)** based authentication  
- **Spring Security** for RBAC (Role-Based Access Control)  
- **Password hashing** using BCrypt  
- **CORS policy** for secure cross-origin requests  
- **HTTPS** ready (via NGINX / reverse proxy)  
- Secure environment variables for API keys and DB credentials  

---

## 💳 Payment Integration

- **Razorpay Gateway** integrated for real-time payments  
- Supports **UPI**, **Card**, and **Cash on Delivery (COD)**  
- Razorpay Webhook verifies payment signatures  
- Order & Invoice automatically generated after successful payment  

---

## 📧 Email & Invoice

- Spring Mail (SMTP) integration  
- Auto-generated **order confirmation** + **PDF invoice** sent to user  
- Templates designed for professional retail experience  

---

## 🧾 Database Schema

| Table | Description |
|--------|--------------|
| `users` | Stores user details, passwords, roles |
| `products` | Product details, pricing, stock |
| `categories` | Mens/Womens/Kids categories |
| `orders` | User orders, payment details |
| `order_items` | Individual order products |
| `cart_items` | User cart items |
| `wishlist` | User wishlist |
| `wallet` | Wallet balance, credits, refunds |
| `notifications` | User alerts, order updates |

---

- ## 🧰 Tools & Setup

### 🧑‍💻 Development Tools

<p align="center">
  <img src="https://skillicons.dev/icons?i=java,spring,react,tailwind,bootstrap,js,mysql,maven,vscode,idea,postman" /> </p>

### 🔧 Prerequisites

| Tool | Version | Purpose |
|------|----------|----------|
| ☕ **Java** | 21+ | Backend development with Spring Boot |
| 🌿 **Spring Boot** | 4.x | REST APIs & Microservices |
| ⚛️ **React** | 18+ | Frontend SPA framework |
| 🎨 **Tailwind CSS / Bootstrap** | Latest | Styling & responsive design |
| 🧩 **MySQL** | 8+ | Database |
| 📦 **Maven** | 3.8+ | Build & dependency management |
| 💻 **VS Code / IntelliJ IDEA** | — | IDEs for frontend & backend |
| 🧪 **Postman** | — | API testing |


## 🖼️ SCREENSHOTS

<p align="center">
  <a href="https://github.com/uday-andra/VESTRA-E-Commerce-Store/tree/main/Screenshots" target="_blank">
    <img src="https://img.shields.io/badge/📸%20View%20All%20Screenshots-Click%20Here-00bcd4?style=for-the-badge&logo=github" alt="View Screenshots"/>
  </a>
</p>


## 🪜 Setup Steps

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/uday-andra/VESTRA-E-Commerce-Store
cd VESTRA
```
### 2️⃣ Backend Setup
```
cd Backend
cd vestra_backend
mvn clean install
mvn spring-boot:run
```
### 3️⃣ Frontend Setup
```
cd Frontend
cd vestra_frontend
npm install
npm run dev
```
### 4️⃣ Access the App
Frontend: http://localhost:5173/

Backend:  http://localhost:8080/



## 🤝 Contributing

Contributions, issues, and feature requests are welcome!
Feel free to check the issues page
.

Steps to Contribute:

1. Fork this repository 🍴

2. Create a new branch (``` git checkout -b feature/AmazingFeature ```)

3. Commit your changes ( ``` git commit -m 'Add some AmazingFeature' ```)

4. Push to the branch (``` git push origin feature/AmazingFeature ```)

5. Open a Pull Request 🚀

 

## 📬 Contact

UDAYCHANDRA ANDRA

📧 Email: udayandra003@gmail.com

💼 LinkedIn: https://www.linkedin.com/in/andra-udaychandra

🐙 GitHub: https://github.com/uday-andra

