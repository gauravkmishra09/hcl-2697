export const greet = (name) => {
  return `Hello, ${name}`;
};

export function sayHello(name) {
  if (!name) {
    return 'Hello, Guest!';
  }
  return `Hello, ${name}!`;
}

export function greetInHindi(name) {
  if (!name) {
    return 'नमस्ते, अतिथि!';
  }
  return `नमस्ते, ${name}!`;
}

export function processOrder(item, price, quantity = 1) {
  if (!item || price <= 0 || quantity <= 0) {
    throw new Error('Invalid order details');
  }
  return {
    item,
    quantity,
    totalAmount: price * quantity,
    status: 'CONFIRMED'
  };
}

export function processPayment(amount, paymentMethod = 'UPI') {
  if (!amount || amount <= 0) {
    throw new Error('Invalid payment amount');
  }

  const validMethods = ['UPI', 'CARD', 'NETBANKING', 'COD'];
  const method = paymentMethod.toUpperCase();

  if (!validMethods.includes(method)) {
    throw new Error('Invalid payment method');
  }

  return {
    amount,
    paymentMethod: method,
    status: 'SUCCESS'
  };
}

// export function add(a, b) {
//   return a + b;
// }
