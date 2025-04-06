# Reflection

### Challenges in Choosing Granularity for States/Actions

One of the key challenges was **deciding the level of detail** for states and actions in both state and activity diagrams. If states were too granular (e.g., breaking down every micro-action like "Button Clicked" or "Input Field Validated"), the diagrams became cluttered and hard to read. On the other hand, if too abstract (e.g., just using “Processing” or “Completed”), important logic or transitions were lost.

We aimed for a **balance between clarity and completeness**, especially for critical objects like `Appointment` and workflows like `Book Appointment`, where key transitions (e.g., “Pending → Confirmed → Completed”) needed to be visible without overwhelming the reader.

---

### Aligning Diagrams with Agile User Stories

Another challenge was **mapping UML diagrams to Agile artifacts** such as user stories and sprint tasks. Agile user stories often describe *what* the user wants (“As a patient, I want to cancel my appointment”) without prescribing *how* it should be implemented. Translating that into precise UML transitions or workflows required close reading of the user stories and functional requirements.

To address this, we used a **traceability matrix** to map diagrams to specific user stories and functional requirements, ensuring that **each diagram had a direct purpose** tied to a real stakeholder need.

---

### ⚙️ State Diagrams vs. Activity Diagrams

| Aspect              | State Diagrams                            | Activity Diagrams                               |
|---------------------|--------------------------------------------|--------------------------------------------------|
| Focus               | Object behavior over time                 | Step-by-step workflow or process                |
| Best For            | Modeling lifecycle of objects (e.g., Appointment) | Describing processes (e.g., Booking, Cancelling) |
| Trigger             | Events and conditions                     | Actions and decision points                     |
| Challenges          | Avoiding over-complex transitions         | Representing concurrent actions clearly         |
| Strength            | Great for understanding how an object reacts | Clear for visualizing full user/system processes |

In summary, **state diagrams helped define how system entities behave**, such as how an `Appointment` moves from "Pending" to "Completed". Meanwhile, **activity diagrams were crucial for illustrating full workflows** involving multiple actors like the patient, system, and admin. Using both offered a holistic view of both **internal behavior** and **external processes**.




