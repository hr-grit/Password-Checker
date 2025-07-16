# Password-Checker
A simple Java console application that checks the complexity of a given password and suggests strong passwords if the entered password is weak.

# Features
1) Checks password strength based on:
- Minimum length (8 characters)
- Presence of uppercase and lowercase letters
- Presence of digits
- Presence of special characters

2) Categorizes password strength as:
- Weak
- Moderate
- Strong

3) Suggests strong random passwords if the password is weak

--> The password is scored based on 5 rules:
- Minimum length ≥ 8
- Contains uppercase letters
- Contains lowercase letters
- Contains digits
- Contains special characters (!@#$%^&*()-_=+<>?)

--> Score Mapping:
- Score ≤ 2 → Weak
- Score 3–4 → Moderate
- Score 5 → Strong

--> Password Suggestions:
- Uses SecureRandom to generate strong passwords of 12 characters, ensuring each contains all required character types.
