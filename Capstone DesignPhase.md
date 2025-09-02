# Architecture

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

```

# Database

```mermaid
erDiagram
    USERS {
        int UserID PK
        string Name
        string Email
        string Password
        string Role
    }

    CLIENTS {
        int ClientID PK
        string Name
        string Contact
        string Email
        string Address
    }

    QUOTATIONS {
        int QuoteID PK
        int ClientID FK
        date DateCreated
        float TotalAmount
        string Status
    }

    INVOICES {
        int InvoiceID PK
        int QuoteID FK
        int ClientID FK
        date InvoiceDate
        float AmountDue
        string Status
    }

    PAYMENTS {
        int PaymentID PK
        int InvoiceID FK
        date PaymentDate
        float PaymentAmount
        string PaymentMethod
    }

    CLIENTS ||--o{ QUOTATIONS : has
    QUOTATIONS ||--o{ INVOICES : generates
    CLIENTS ||--o{ INVOICES : receives
    INVOICES ||--o{ PAYMENTS : records
```

# Dataflow Diagram

```mermaid
flowchart TD
    A[Client / User] -->|Request Quotation| B[Frontend Interface]
    B -->|Send Request| C[Quotation Service]
    C -->|Retrieve Client Info| D[Client Database]
    C -->|Save Quotation| E[Quotation Database]
    C -->|Send Quotation| A
    A -->|Approve Quotation| C
    C -->|Generate Invoice| F[Invoice Service]
    F -->|Save Invoice| G[Invoice Database]
    F -->|Send Invoice| A
    A -->|Make Payment| H[Payment Service]
    H -->|Save Payment| I[Payment Database]
    H -->|Update Invoice Status| G
```

# 2.2 System Interaction Diagram (SID)

```mermaid
sequenceDiagram
    participant Client as Client/User
    participant Frontend as Frontend UI
    participant Backend as Backend Services
    participant DB as Database

    Client->>Frontend: Login / Request Quotation
    Frontend->>Backend: Validate User / Process Request
    Backend->>DB: Retrieve Client Details
    DB-->>Backend: Return Client Data
    Backend->>DB: Save Quotation
    Backend-->>Frontend: Send Quotation Confirmation
    Frontend-->>Client: Display Quotation

    Client->>Frontend: Approve Quotation
    Frontend->>Backend: Generate Invoice
    Backend->>DB: Save Invoice
    Backend-->>Frontend: Send Invoice
    Frontend-->>Client: Display Invoice

    Client->>Frontend: Make Payment
    Frontend->>Backend: Process Payment
    Backend->>DB: Save Payment & Update Invoice Status
    Backend-->>Frontend: Payment Confirmation
    Frontend-->>Client: Display Payment Status

