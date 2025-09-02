```mermaid
%%{init: {"themeVariables": {"primaryColor": "#f9f9f9","edgeLabelBackground":"#ffffff","fontFamily":"Arial"}}}%%
graph TB
    %% Presentation Layer - Light Blue
    PL["<b><u>Presentation Layer - Frontend</u></b>
- Dashboard (Quotations, Invoices, Payments)
- Quotation Creation Form
- Invoice Generation Form
- Reports & Analytics Pages
Technologies: Angular, HTML, CSS, JS"]
    style PL fill:#d0e7ff,stroke:#4da6ff,stroke-width:2px,color:#000

    %% Application Layer - Light Green
    AL["<b><u>Application Layer - Backend</u></b>
- User Management Service
- Client Management Service
- Quotation Service
- Invoice Service
- Notification Service (Email/SMS)
- Reporting Service
Technologies: Java Spring Boot / Node.js / PHP Laravel"]
    style AL fill:#d0ffd6,stroke:#33cc33,stroke-width:2px,color:#000

    %% Database Layer - Light Orange
    DB["<b><u>Database Layer</u></b>
- User Table
- Client Table
- Quotation Table
- Invoice Table
- Payment Table
Technologies: MySQL / PostgreSQL"]
    style DB fill:#ffe0b3,stroke:#ff9933,stroke-width:2px,color:#000

    %% Layer connections
    PL -->|Calls APIs| AL
    AL -->|Reads/Writes Data| DB

