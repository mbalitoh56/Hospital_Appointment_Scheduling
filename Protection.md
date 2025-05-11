## 🔒 Branch Protection Rules for `master`

### ✔️ Rule Summary

We have enabled the following protection rules on the `master` branch to ensure the stability, security, and quality of the codebase:

1. **Require Pull Request Reviews (At Least 1 Reviewer):**

   * No one can merge code directly without a review.
   * This encourages peer reviews, which catch bugs early and improve code quality.

2. **Require Status Checks to Pass (CI Integration):**

   * Only code that passes all automated tests (e.g., unit, integration, API) can be merged.
   * This prevents broken or untested features from being deployed to production.

3. **Disable Direct Pushes:**

   * Developers cannot push directly to the `master` branch.
   * All changes must go through a Pull Request (PR), fostering collaboration and transparency.



## 💡 Why These Rules Matter

| Rule                      | Benefit                                                                                            |
| ------------------------- | -------------------------------------------------------------------------------------------------- |
| **Review Requirements**   | Ensures code is seen by at least one other team member. Reduces errors and spreads knowledge.      |
| **Passing Status Checks** | Enforces automated testing before merge, preventing broken code in production.                     |
| **No Direct Pushes**      | Protects `main` from accidental or unauthorized changes. Enforces the proper development workflow. |

---

## ✅ Best Practices

* Create feature branches from `main`.
* Open a pull request and request a review.
* Ensure your commits pass all checks (e.g., GitHub Actions).
* Only merge once approved and all checks have passed.

  # Branch protection rule screenshot
  
![Branch Protection](https://github.com/user-attachments/assets/9f727b02-3866-4698-b3a9-cdaa04ca979e)

  

