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
```

# NEW

## High-Level Architecture
```mermaid
flowchart TD
    User["End User"] --> UI["Frontend - Angular or React"]
    UI --> API["Backend API - Spring Boot or Node.js"]
    API --> DB["Database: PostgreSQL or MySQL"]
    API --> Reports["Reporting Service"]
    Reports --> Export["Export Formats: PDF, Excel, CSV"]

```

## Entity Relationship Diagram (ERD)
```mermaid
erDiagram
    CUSTOMER ||--o{ QUOTE : "requests"
    CUSTOMER ||--o{ INVOICE : "receives"
    CUSTOMER ||--o{ PAYMENT : "makes"

    QUOTE ||--o{ QUOTELINEITEM : "contains"
    INVOICE ||--o{ INVOICELINEITEM : "contains"

    INVOICE ||--o{ PAYMENT : "paid_by"
    INVOICE ||--o{ CREDITNOTE : "adjusted_by"
    
    TEMPLATE ||--o{ QUOTE : "applied_to"
    TEMPLATE ||--o{ INVOICE : "applied_to"

    REPORT ||--o{ CUSTOMER : "analyzes"
    REPORT ||--o{ INVOICE : "analyzes"
    REPORT ||--o{ PAYMENT : "analyzes"
```

## Quote Workflow
```mermaid
stateDiagram-v2
    [*] --> Draft
    Draft --> Review : "Submit for approval"
    Review --> Approved : "Manager approves"
    Review --> Rejected : "Manager rejects"
    Approved --> Sent : "Send to customer"
    Sent --> Converted : "Convert to Sales Order"
    Sent --> Expired : "Expiration date passed"
    Converted --> [*]
    Expired --> [*]
```

## Invoice Workflow
```mermaid
stateDiagram-v2
    [*] --> Draft
    Draft --> Sent : "Send to customer"
    Sent --> Paid : "Payment received"
    Sent --> Overdue : "Past due date"
    Overdue --> Paid : "Customer settles"
    Overdue --> WrittenOff : "Write-off decision"
    Paid --> [*]
    WrittenOff --> [*]
```

## Recurring Invoice Workflow
```mermaid
flowchart LR
    Template["Recurring Invoice Template"] --> Schedule["Billing Schedule - Monthly/Quarterly/Yearly"]
    Schedule --> AutoGen["Automatic Invoice Generation"]
    AutoGen --> Notify["Customer Notification"]
    AutoGen --> Invoice["Invoice Created"]
    Invoice --> Payment["Payment Tracking"]
```

## Overdue Collection Workflow
```mermaid
flowchart TD
    Overdue["Overdue Invoice"] --> Reminder1["Automated Reminder #1"]
    Reminder1 --> Reminder2["Automated Reminder #2"]
    Reminder2 --> Collection["Collection Workflow"]
    Collection --> Communication["Customer Communication"]
    Communication --> Resolution["Payment / Write-off / Legal Action"]
```

## Reporting Dashboard
```mermaid
flowchart TD
    Reports["Reports Module"] --> Aging["Invoice Aging Report"]
    Reports --> Sales["Sales Analysis"]
    Reports --> PaymentPerf["Payment Performance"]
    Reports --> Overdue["Overdue & Collections"]
    Reports --> Tax["Tax Reports"]
    Reports --> Custom["Custom Report Builder"]




