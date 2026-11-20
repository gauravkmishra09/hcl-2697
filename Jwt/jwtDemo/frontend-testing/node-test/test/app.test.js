import test from 'node:test';
import assert from 'node:assert';
import { greet, sayHello, greetInHindi, processOrder, processPayment } from '../app.js';

test('greet returns greeting with name', () => {
  const result = greet('John');
  assert.strictEqual(result, 'Hello, John');
});

test('sayHello returns greeting with provided name', () => {
  const result = sayHello('Rahul');
  assert.strictEqual(result, 'Hello, Rahul!');
});

test('sayHello returns default greeting when name is not provided', () => {
  const result = sayHello();
  assert.strictEqual(result, 'Hello, Guest!');
});

test('greetInHindi returns Namaste with provided name', () => {
  const result = greetInHindi('अमित');
  assert.strictEqual(result, 'नमस्ते, अमित!');
});

test('greetInHindi returns default greeting when name is not provided', () => {
  const result = greetInHindi();
  assert.strictEqual(result, 'नमस्ते, अतिथि!');
});

test('processOrder processes valid order correctly', () => {
  const result = processOrder('Laptop', 50000, 2);
  assert.deepStrictEqual(result, {
    item: 'Laptop',
    quantity: 2,
    totalAmount: 100000,
    status: 'CONFIRMED'
  });
});

test('processOrder throws error for invalid price or quantity', () => {
  assert.throws(() => {
    processOrder('Mobile', -500, 1);
  }, /Invalid order details/);
});

test('processPayment processes valid payment successfully', () => {
  const result = processPayment(1500, 'CARD');
  assert.deepStrictEqual(result, {
    amount: 1500,
    paymentMethod: 'CARD',
    status: 'SUCCESS'
  });
});

test('processPayment uses default payment method UPI when not specified', () => {
  const result = processPayment(500);
  assert.strictEqual(result.paymentMethod, 'UPI');
  assert.strictEqual(result.status, 'SUCCESS');
});

test('processPayment throws error for non-positive amount', () => {
  assert.throws(() => {
    processPayment(0, 'UPI');
  }, /Invalid payment amount/);
});

test('processPayment throws error for unsupported payment method', () => {
  assert.throws(() => {
    processPayment(1000, 'BITCOIN');
  }, /Invalid payment method/);
});

// test('add adds two numbers properly', () => {
//   const result = add(3, 7);
//   assert.strictEqual(result, 10);
// });
