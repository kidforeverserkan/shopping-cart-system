# Shopping Cart System (Java)

A simple Java project that models a shopping cart with products, basic validation,
and custom exception handling.  
Designed as a junior-level portfolio project focusing on clean object-oriented design.

## Features
- Create products with name and price
- Add and remove products from a shopping cart
- Prevent invalid products (price ≤ 0)
- Custom exception when removing a product that does not exist
- Calculate and display total cart price
- Clear separation between domain logic and demo code

## Project Structure
- `Product` – immutable product with validation
- `ShoppingCart` – manages cart operations and totals
- `Customer` – represents the cart owner
- `ProductNotFoundException` – domain-specific runtime exception
- `Main` – demo entry point

## How to Run
1. Open the project in IntelliJ IDEA
2. Run the `Main` class
3. View output in the console

## Example Output
OK: ADD iPhone 15 ($999.99) -> total=999.99
OK: ADD HP Laptop ($1200.00) -> total=2199.99
OK: REMOVE iPhone 15 ($999.99) -> total=1200.00
FAILED: REMOVE;Does Not Exist;10.00 -> Product not found in the cart
FAILED: ADD;Broken Item;-10 -> Product price must be positive



## Design Decisions
- Product validation is handled in the constructor to prevent invalid state
- Runtime exceptions are used for domain errors that should not be silently ignored
- Collections are encapsulated and exposed as read-only views
- No frameworks used — core Java only

## Purpose
This project was built as part of a Java learning portfolio to demonstrate:
- Object-oriented principles
- Exception handling
- Clean, readable code
- Practical GitHub-ready project structure
