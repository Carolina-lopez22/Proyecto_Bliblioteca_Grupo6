
---

# 📚 **Biblioteca 2.0 – Sistema de Gestión de Biblioteca (Java + Swing) Grupo No. 6 Progra1B**

Bienvenido al repositorio del proyecto **Biblioteca 2.0**, un sistema completo de gestión de biblioteca desarrollado en **Java**, utilizando **Swing** para la interfaz gráfica y aplicando una arquitectura **MVC** bien organizada.

Este proyecto permite administrar:

- 👤 Usuarios  
- 📘 Materiales (Libros)  
- 🔄 Préstamos  
- 💾 Persistencia de datos en **archivos CSV**  

Todo desde una interfaz amigable y funcional.

---

# 🏗️ **Arquitectura del Proyecto**

```
Proyecto_Biblioteca_Grupo6/
 ├── src/
 │   ├── models/   → Lógica del negocio
 │   ├── ui/       → Interfaz gráfica (Swing)
 │   └── utils/    → Utilidades
 ├── books.csv     → Base de datos de libros
 ├── users.csv     → Base de datos de usuarios
 ├── loans.csv     → Base de datos de préstamos
 └── README.md
```
```
Proyecto_Biblioteca_Grupo6/
│
├── books.csv
├── loans.csv
├── users.csv
│
├── src/
│   ├── models/
│   │     ├── Admin.java
│   │     ├── Book.java
│   │     ├── Library.java
│   │     ├── Loan.java
│   │     ├── Main.java
│   │     ├── Student.java
│   │     └── User.java
│   │
│   ├── ui/
│   │     ├── LoanOperationPanel.java
│   │     ├── LoanTableModel.java
│   │     ├── LoanViewPanel.java
│   │     ├── LoginFrame.java
│   │     ├── MainFrame.java
│   │     ├── MainPanel.java
│   │     ├── MaterialOperationPanel.java
│   │     ├── MaterialTableModel.java
│   │     ├── MaterialViewPanel.java
│   │     ├── OperationUserPanel.java
│   │     ├── UserTableModel.java
│   │     └── UserViewPanel.java
│   │
│   └── utils/
│         └── Date.java
│
└── README.md
```
---

# 🧩 **1. Paquete `models` – Lógica del Sistema**

### **📘 Book**
Control de libros, validación de año, copias disponibles.

### **👤 User / 🎓 Student / 🛡️ Admin**
Sistema de usuarios con roles y control de deudores.

### **🔄 Loan**
Registra préstamos, fechas, días permitidos y estado.

### **🏛️ Library**
La clase central del sistema.  
Gestiona:

- CRUD de usuarios  
- CRUD de libros  
- CRUD de préstamos  
- Autenticación  
- **Persistencia en CSV**  
- Control de deudores  

---

# 🖥️ **2. Paquete `ui` – Interfaz Gráfica (Swing)**

Incluye:

- Login  
- Menú principal  
- CRUD de usuarios  
- CRUD de materiales  
- CRUD de préstamos  
- Tablas de visualización  

Cada módulo tiene:

- Panel de operaciones  
- Panel de visualización  
- Modelo de tabla personalizado  

---

# 💾 **3. Persistencia de Datos (CSV)**

El sistema ahora utiliza **archivos CSV** para almacenar toda la información:

### 📘 **books.csv**
```
codigo,titulo,autor,anio,copias
```

### 👤 **users.csv**
```
id,nombre,tipo,esDeudor,password
```

### 🔄 **loans.csv**
```
idUsuario,idLibro,fechaPrestamo,maxDias,devuelto
```

### ✔ Ventajas del uso de CSV:
- Fácil de leer y editar manualmente  
- Compatible con Excel, Google Sheets y otros programas  
- No requiere serialización binaria  
- Más transparente para depuración  

### ✔ La clase `Library`:
- Lee los CSV al iniciar  
- Escribe los CSV después de cada operación  
- Mantiene sincronizados los datos entre UI y archivos  

---

# 🚀 **Cómo Ejecutar el Proyecto**

1. Clona el repositorio:  
   ```
   git clone https://github.com/tuusuario/Proyecto_Biblioteca_Grupo6.git
   ```

2. Abre el proyecto en tu IDE.

3. Usa **JDK 17**.

4. Ejecuta:

```
src/ui/LoginFrame.java
```

5. Inicia sesión con el usuario por defecto:

```
Usuario: admin
Contraseña: 1234
```

---

# 👥 **Autores**

- Saúl Humberto Chávez Rivas  
- Yesica Carolina López Ordoñez 
- Carlos Eduardo Corado Ibañez 

---

# 📄 **Licencia**

Proyecto con fines educativos.

---
