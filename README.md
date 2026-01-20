\# Shopping Cart System (Java)



A simple Java project that models a shopping cart with products, basic validation,

and file-based actions.  

Designed as a junior-level portfolio project focusing on clean object-oriented design.



\## Features

\- Create products with name and price

\- Add and remove products from a shopping cart

\- Prevent invalid products (price <= 0)

\- Custom exception when removing a product that does not exist

\- Calculate and display total cart price

\- Process cart actions from a file

\- Log results to an output file



\## How to Run

1\. Open the project in IntelliJ IDEA

2\. Make sure `cart-actions.txt` is in the project root

3\. Run the `Main` class

4\. View console output and `cart-actions.log`



\## Example Output

```text

OK: ADD iPhone 15 ($999.99) -> total=999.99

OK: ADD HP Laptop ($1200.00) -> total=2199.99

OK: REMOVE iPhone 15 ($999.99) -> total=1200.00

FAILED: REMOVE;Does Not Exist;10.00 -> Product not found in the cart

FAILED: ADD;Broken Item;-10 -> Product price must be positive



